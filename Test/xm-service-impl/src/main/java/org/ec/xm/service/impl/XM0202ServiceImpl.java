package org.ec.xm.service.impl;

import org.ec.xm.dao.mapper.*;
import org.ec.xm.dto.XM0202.*;
import org.ec.xm.service.XM0202Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * XM0202: 项目执行 - 项目管理（项目管理页面）
 * 作者：
 * 日期：
 */
@Component
@Transactional
public class XM0202ServiceImpl implements XM0202Service {
    @Value("${xxl.job.admin.addresses}")
    private String adminAddresses;
    private final XmProjectMapper xmProjectMapper;
    private final XmTaskMapper xmTaskMapper;
    private final XmFundingMapper xmFundingMapper;
    private final XmFundingDetailMapper xmFundingDetailMapper;
    private final XmMoneySourceMapper xmMoneySourceMapper;
    private final XmProgressMapper xmProgressMapper;
    private final XmProgressReplyMapper xmProgressReplyMapper;
    private final XmProjectConfigMapper xmProjectConfigMapper;
    private final XmProjectFileMapper xmProjectFileMapper;
    private final XmTaskRecordMapper xmTaskRecordMapper;
    public XM0202ServiceImpl(XmProjectMapper xmProjectMapper, XmTaskMapper xmTaskMapper, XmFundingMapper xmFundingMapper, XmFundingDetailMapper xmFundingDetailMapper, XmMoneySourceMapper xmMoneySourceMapper, XmProgressMapper xmProgressMapper, XmProgressReplyMapper xmProgressReplyMapper, XmProjectConfigMapper xmProjectConfigMapper, XmProjectFileMapper xmProjectFileMapper, XmTaskRecordMapper xmTaskRecordMapper) {
        this.xmProjectMapper = xmProjectMapper;
        this.xmTaskMapper = xmTaskMapper;
        this.xmFundingMapper = xmFundingMapper;
        this.xmFundingDetailMapper = xmFundingDetailMapper;
        this.xmMoneySourceMapper = xmMoneySourceMapper;
        this.xmProgressMapper = xmProgressMapper;
        this.xmProgressReplyMapper = xmProgressReplyMapper;
        this.xmProjectConfigMapper = xmProjectConfigMapper;
        this.xmProjectFileMapper = xmProjectFileMapper;
        this.xmTaskRecordMapper = xmTaskRecordMapper;
    }

    @Override
    public int addProject(XM0202A03InputDTO input) throws Exception {
        input.setStatus(false);
        int index=0;
        try {
            index= xmProjectMapper.addProject(input);
        }
        catch (Exception e){
            throw new Exception("项目编码相同，请重新输入");
        }
        if (index>0){
            /* return xmProjectMapper.addConfig(input.getTimedTaskType(),input.getDataTemplateId(),input.getId());*/
            for (int i = 0; i < input.getTimedTaskType().length; i++) {
                if (input.getTimedTaskType()[i] != "") {
                    try {
                        Map<String, String> params = new HashMap<>();
                        String taskParam = String.valueOf(input.getId()) + "," + String.valueOf(input.getDataTemplateId()[i]) + "," +input.getTimedTaskType()[i] + input.getDataTemplateId()[i]+"定时任务";

                        String cron;
                        if (input.getTimedTaskType()[i].equals("每月"))
                            cron = "0 0 0 1 * ?";
                        else
                            cron = "0 0 0 1 1/3 ? ";
                        params.put("jobGroup", "2");
                        params.put("jobCron", cron);
                        params.put("jobDesc", "测试");
                        params.put("author", "li");
                        params.put("executorRouteStrategy", "FIRST");
                        params.put("executorHandler", "TestJobHandler");
                        params.put("executorParam", taskParam);
                        params.put("executorBlockStrategy", "SERIAL_EXECUTION");
                        params.put("executorFailStrategy", "FAIL_RETRY");
                        params.put("glueType", "BEAN");
                        String repMsg = HttpPostUrl.sendPost(adminAddresses + "/jobinfo/add", params);
                        repMsg.substring(repMsg.lastIndexOf(":") + 2, repMsg.indexOf("}") - 1);
                        int timingTaskId = Integer.parseInt(repMsg.substring(repMsg.lastIndexOf(":") + 2, repMsg.indexOf("}") - 1));
                        xmProjectMapper.addConfig(input.getTimedTaskType()[i], input.getDataTemplateId()[i], input.getId(), timingTaskId);
                    }catch (Exception e){
                        throw new Exception("新增配置失败");
                    }
                }
            }
            return 1;
    }
        else{
           return -1;
        }
    }

    @Override
    public List<XM0202A01S01DTO> getListById(String keyword, Integer organazition_id) {

        List<XM0202A01S01DTO> list=xmProjectMapper.selectAllById(keyword,organazition_id);
        List<Map> map= xmFundingMapper.projectMap(organazition_id);
        for(int i=0;i<list.size();i++){
            Object totalMoney = xmFundingMapper.getProjectTotalMoney(list.get(i).getId(), organazition_id);
            if(totalMoney!=null){
                list.get(i).setTotalMoney((double)totalMoney);
            }
            else {
                list.get(i).setTotalMoney((double)0);
            }
        }
        for(int i=0;i<map.size();i++){
          long prjId= (long) map.get(i).get("project_id");
            for(int j=0;j<list.size();j++){
                if(list.get(j).getId()==prjId){
                    list.get(j).setMoney((double)map.get(i).get("money"));
                    break;
                }
            }
        }
        return list;
    }

    @Override
    public List<XM0202A02DTO> getAllYears(Integer id) {
        List<XM0202A02DTO> xm0202A02DTOList=xmProjectMapper.getAllYears(id);
        return  xm0202A02DTOList;
    }

    @Override
    public int updateProjectById(XM0202A06InputDTO input) {
        int mark = xmProjectMapper.updataByProjectId(input);
        if (mark > 0) {
            int mark1 = 0;
            Integer[] allId = xmProjectMapper.selectAllConfigIdByProjectId(input.getProjectId());
            Integer[] timingNum = xmProjectConfigMapper.getAllTimingTaskId(input.getProjectId());
            for (int m = 0; m < allId.length; m++) {
                for (int i = 0;input.getDataTemplateId()!=null&& i <input.getDataTemplateId().length; i++) {
                    if (allId[m].equals(input.getProjectConfigId()[i])) {
                        allId[m] = 0;
                        timingNum[m] = 0;
                    }
                }
            }
            for (int i = 0; i < allId.length; i++) {
                if (allId[i] != 0 && timingNum[i] != 0) {
                    xmProjectMapper.deleteByProjectId(allId[i]);
                    Map<String, String> params = new HashMap<>();
                    String id = String.valueOf(timingNum[i]);
                    params.put("id", id);
                    HttpPostUrl.sendPost(adminAddresses+"/jobinfo/remove", params);
                }
            }
            for (int i = 0;  input.getDataTemplateId()!=null&&i < input.getDataTemplateId().length; i++) {
                if (input.getTimedTaskType()[i] != "" && input.getDataTemplateId()[i] != null && input.getTimedTaskType()[i] != null) {
                    if (input.getProjectConfigId()[i] == null) {
                        Map<String, String> params = new HashMap<>();
                        String taskParam = String.valueOf(input.getProjectId()) + "," + String.valueOf(input.getDataTemplateId()[i]) + "," +input.getTimedTaskType()[i] + input.getDataTemplateId()[i]+"定时任务";
                        String cron;
                        if (input.getTimedTaskType()[i].equals("每月"))
                            cron = "0 0 0 1 * ?";
                        else
                            cron = "0 0 0 1 1/3 ? ";
                        params.put("jobGroup", "2");
                        params.put("jobCron", cron);
                        params.put("jobDesc", "测试");
                        params.put("author", "li");
                        params.put("executorRouteStrategy", "FIRST");
                        params.put("executorHandler", "TestJobHandler");
                        params.put("executorParam", taskParam);
                        params.put("executorBlockStrategy", "SERIAL_EXECUTION");
                        params.put("executorFailStrategy", "FAIL_RETRY");
                        params.put("glueType", "BEAN");
                        String repMsg = HttpPostUrl.sendPost(adminAddresses + "/jobinfo/add", params);
                        repMsg.substring(repMsg.lastIndexOf(":") + 2, repMsg.indexOf("}") - 1);
                        int timingTaskId = Integer.parseInt(repMsg.substring(repMsg.lastIndexOf(":") + 2, repMsg.indexOf("}") - 1));
                        xmProjectMapper.addConfig(input.getTimedTaskType()[i], input.getDataTemplateId()[i], input.getProjectId(), timingTaskId);
                    } else if (input.getProjectConfigId()[i] != null) {
                        XM0202A01S02DTO xm0202A01S02DTO = new XM0202A01S02DTO();
                        xm0202A01S02DTO.setDatatemplateid(input.getDataTemplateId()[i]);
                        xm0202A01S02DTO.setTimedtasktype(input.getTimedTaskType()[i]);
                        xm0202A01S02DTO.setProjectConfigId(input.getProjectConfigId()[i]);
                        xmProjectMapper.updateProjectConfigById(xm0202A01S02DTO);
                        Map<String, String> params = new HashMap<>();
                        String taskParam = String.valueOf(input.getProjectId()) + "," + String.valueOf(input.getDataTemplateId()[i]) + "," +input.getTimedTaskType()[i] + input.getDataTemplateId()[i]+"定时任务";
                        String cron;
                        String id = String.valueOf(input.getTimingTaskId()[i]);
                        if (input.getTimedTaskType()[i].equals("每月"))
                            cron = "0 0 0 1 * ?";
                        else
                            cron = "0 0 0 1 1/3 ? ";
                        params.put("jobGroup", "2");
                        params.put("jobCron", cron);
                        params.put("jobDesc", "测试");
                        params.put("author", "li");
                        params.put("executorRouteStrategy", "FIRST");
                        params.put("executorHandler", "TestJobHandler");
                        params.put("executorParam", taskParam);
                        params.put("executorBlockStrategy", "SERIAL_EXECUTION");
                        params.put("executorFailStrategy", "FAIL_RETRY");
                        params.put("glueType", "BEAN");
                        params.put("id", id);
                        HttpPostUrl.sendPost(adminAddresses+"/jobinfo/update", params);
                    }

               }
           }

           return mark1;
       }
        return mark;
    }

    @Override
    public int sureProject(Integer id) {
        int mark=xmProjectMapper.sureProject(id);
        return mark;
    }

    @Override
    public int deleteProject(Integer id) {
        Integer[] fundingIds=xmProjectFileMapper.getAllProjectFundingId(id);
      Integer[] num=xmTaskMapper.getAllTaskId(id);
      for(int i=0;i<num.length;i++){
         xmProgressMapper.delteFromProgress(num[i]);
         xmProgressReplyMapper.deleteFromProgressReply(num[i]);
         xmProjectFileMapper.deleteFromProjectFile(num[i]);
         xmTaskRecordMapper.deleteFromTaskRecord(num[i]);
      }
      for(int i=0;i<fundingIds.length;i++){
            xmProjectFileMapper.deleteFilebByFundingId(fundingIds[i]);
      }
        xmFundingMapper.deleteFromFunding(id);
        xmFundingDetailMapper.deleteFromFundingDetail(id);
        xmMoneySourceMapper.deleteFromMoneySource(id);
        xmProjectConfigMapper.deleteFromProjectConfig(id);
        xmTaskMapper.deleteFromTask(id);
      int mark=  xmProjectMapper.deleteFromProject(id);
        return mark;
    }

    @Override
    public List<XM0202A04DTO> getDownDetail(XM0202A04InputDTO input) {
        return xmFundingMapper.getTotalMoney(input);
    }

    @Override
    public List<XM0202A05DTO> getFileList(XM0202A05InputDTO input) {
        return xmProjectFileMapper.getMoneyDownFile(input);
    }


}
