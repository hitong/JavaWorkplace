package org.ec.xm.api.controller;

import io.swagger.annotations.*;
import org.ec.attachment.service.IAttachmentUploaderService;
import org.ec.utils.BeanMapper;
import org.ec.xm.dto.XM0205.XM0205A01DTO;
import org.ec.xm.dto.XM0207.XM0207A03DTO;
import org.ec.xm.entity.XmProgress;
import org.ec.xm.entity.XmProgressReply;
import org.ec.xm.entity.XmProjectFile;
import org.ec.xm.entity.XmTask;
import org.ec.xm.service.XM0209Service;
import org.ec.utils.JSONResult;
import org.ec.xm.dto.XM0209.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;
import javax.validation.Valid;

/**
 * XM0209: 项目执行 - 任务详情(区县)（基础信息页面）
 * 作者：
 * 日期：
 */
@RestController
@CrossOrigin
@Api("XM0209: 项目执行 - 任务详情(区县)（基础信息页面）")
@RequestMapping("/XM0209")
public class XM0209Controller extends BaseController {

    /**
     * XM0209Service
     */
    private final XM0209Service xm0209Service;
    private final IAttachmentUploaderService iAttachmentUploaderService;

    @Autowired
    public XM0209Controller(XM0209Service xm0209Service,IAttachmentUploaderService iAttachmentUploaderService) {
        this.xm0209Service = xm0209Service;
        this.iAttachmentUploaderService = iAttachmentUploaderService;
    }

    /**
     * A01: 任务信息获取(区县)（根据id查询任务详情）
     */
    @ApiOperation(value = "任务信息获取(区县)", notes = "根据id查询任务详情", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01(@Valid XM0209A01InputDTO input) {
        JSONResult<XM0209A01DTO> jsonResult = new JSONResult<>();
        XM0209A01DTO xm0209A01DTO = new XM0209A01DTO();
        XmTask xmTask= xm0209Service.getTaskById(input.getTaskId());
        if(xmTask==null){
            return null;
        }
        xm0209A01DTO.setName(xm0209Service.getProjectName(xmTask.getProjectId()));
        xm0209A01DTO.setTaskName(xmTask.getName());
        xm0209A01DTO.setStatus(xmTask.getStatus());
        xm0209A01DTO.setType(xmTask.getType());
        xm0209A01DTO.setBeginAt(xmTask.getBeginAt());
        xm0209A01DTO.setFinishAt(xmTask.getFinishAt());
        xm0209A01DTO.setSuperiorOrganizationId(xmTask.getSuperiorOrganizationId());
        xm0209A01DTO.setSuperiorTaskId(xmTask.getSuperiorTaskId());
        xm0209A01DTO.setOrganizationId(xmTask.getOrganizationId());
        xm0209A01DTO.setDataTemplateId(xmTask.getDataTemplateId());
        xm0209A01DTO.setRemark(xmTask.getRemark());
        xm0209A01DTO.setProjectId(xmTask.getProjectId());
        XM0209A01DTO xm0205A01DTO1= BeanMapper.map(xm0209A01DTO,XM0209A01DTO.class);
        jsonResult.setData(xm0205A01DTO1);
        return jsonResult;
    }

    /**
     * A02: 最新动态获取(区县)（根据id查询最新动态）
     */
    @ApiOperation(value = "最新动态获取(区县)", notes = "根据id查询最新动态", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A02")
    public JSONResult A02(@Valid XM0209A02InputDTO input) {

        JSONResult<List<XM0209A08DTO>> jsonResult = new JSONResult<>();
        List<XM0209A08DTO> xm0209A08DTOList= new ArrayList<>();
        List<Map<String,Object>> map= new ArrayList<>();
        Map inputMap= new HashMap();
        inputMap.put("task_id",input.getTaskId());//该任务
        inputMap.put("superior_task_id",input.getSuperiorTaskId());//上级任务
        inputMap.put("organization_id",input.getOrganizationId());//该任务组织
        List<XM0209A14DTO> xm0209A14DTOList = new ArrayList<>();
        xm0209A14DTOList=xm0209Service.getSubordinateOrganizationName(input.getOrganizationId());
        inputMap.put("list",xm0209A14DTOList);
        inputMap.put("size",xm0209A14DTOList.size());

        map=xm0209Service.getContent(inputMap);
        if(map.size()!=0){
            for(int i=0;i<map.size();i++){
                XM0209A08DTO xm0209A08DTO = new XM0209A08DTO();
                List<XM0209A08S01DTO> xm0209A08S01DTOList=new ArrayList<>();

                XM0209A08S01DTO xm0209A08S01DTO=new XM0209A08S01DTO();
                xm0209A08S01DTO.setProcessId(Integer.parseInt(map.get(i).get("id").toString()));
                xm0209A08S01DTO.setName(xm0209Service.getProgressUserName(Integer.parseInt(map.get(i).get("user_id").toString())));
                xm0209A08S01DTO.setCompany(xm0209Service.getOrganization(Integer.parseInt(map.get(i).get("organization_id").toString())));
                xm0209A08S01DTO.setContent(map.get(i).get("content").toString());
                xm0209A08S01DTO.setCreatedAt( Timestamp.valueOf(map.get(i).get("created_at").toString()));
                xm0209A08S01DTO.setReplyNum(xm0209Service.getProgressReplyNum(Integer.parseInt(map.get(i).get("id").toString())));
                xm0209A08S01DTOList.add(xm0209A08S01DTO);
                xm0209A08DTO.setContentLetters(xm0209A08S01DTOList);
                xm0209A08DTOList.add(xm0209A08DTO);

            }
            jsonResult.setData(xm0209A08DTOList);
           // jsonResult.setTotalCount(counts);
        }
        else{
            //jsonResult.setMessage("暂无最新动态");
        }
        return jsonResult;
    }


    /**
     * A03: 资料列表获取(区县)（区县文件列表获取）
     */
    @ApiOperation(value = "资料列表获取(区县)", notes = "区县文件列表获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A03")
    public JSONResult A03(@Valid XM0209A03InputDTO input) {
        JSONResult<List<XM0209A03DTO>> jsonResult = new JSONResult<>();
        List<XmProjectFile> xmProjectFileList = xm0209Service.getFileListAndStatus(input.getTaskId(),input.getOrganizationId());
        List<XM0209A03DTO> xm0209A03DTOList = BeanMapper.mapList(xmProjectFileList, XM0209A03DTO.class);

        jsonResult.setData(xm0209A03DTOList);
        return jsonResult;
    }

    /**
     * A04: 最新动态回复查看(区县)（最新动态回复查看）
     */
    @ApiOperation(value = "最新动态回复查看(区县)", notes = "最新动态回复查看", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A04")
    public JSONResult A04(@Valid XM0209A04InputDTO input) {
        JSONResult<List<XM0209A04DTO>> jsonResult = new JSONResult<>();
        List<XM0209A04DTO> xm0205A04DTOList = new ArrayList<>();

        Map inputMap= new HashMap();
        int counts=0;
        inputMap.put("page",input.getPage()*input.getPageSize());
        inputMap.put("pageSize",input.getPageSize());
        inputMap.put("progress_id",input.getProgressId());

        List<XmProgressReply> xmProgressReplyList= new ArrayList<>();
        xmProgressReplyList=xm0209Service.getProgressReply(inputMap);
        counts=xm0209Service.getProgressReplyNum(input.getProgressId());

        for(int i=0;i<xmProgressReplyList.size();i++){
            XM0209A04DTO xm0205A04DTO=new XM0209A04DTO();
            xm0205A04DTO.setOrganizationName(xm0209Service.getOrganization(xmProgressReplyList.get(i).getOrganizationId()));
            xm0205A04DTO.setContent(xmProgressReplyList.get(i).getContent());
            xm0205A04DTO.setCreatedAt(xmProgressReplyList.get(i).getCreatedAt());
            xm0205A04DTO.setName(xm0209Service.getProgressReplyUserName(xmProgressReplyList.get(i).getReplymanId()));
            xm0205A04DTOList.add(xm0205A04DTO);
        }
        jsonResult.setData(xm0205A04DTOList);
        jsonResult.setTotalCount(counts);

        return jsonResult;
    }

    /**
     * A05: 任务详情获取(分页&查询)(区县)（获取任务完成情况列表，包含分页和查询）
     */
    @ApiOperation(value = "任务详情获取(分页&查询)(区县)", notes = "获取任务完成情况列表，包含分页和查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JSONResult A05(@Valid XM0209A05InputDTO input) {
        JSONResult<List<XM0209A05DTO>> jsonResult = new JSONResult<>();

        List<XM0209A05DTO> xm0205A05DTOList= new ArrayList<XM0209A05DTO>();
        List<Map<String,Object>> map= new ArrayList<>();

        Map inputMap= new HashMap();
        inputMap.put("page",input.getPage()*input.getPageSize());
        inputMap.put("pageSize",input.getPageSize());
        inputMap.put("superior_task_id",input.getTaskId());
        inputMap.put("status",input.getStatus());

        int counts=xm0209Service.getCounts(inputMap);
        map=xm0209Service.getAllTaskById(inputMap);
        if(map.size()!=0) {
            for (int i = 0; i < map.size(); i++) {
                XM0209A05DTO xm0209A05DTO = new XM0209A05DTO();
                List<XM0209A05S01DTO> xm0209A05S01DTOList = new ArrayList<XM0209A05S01DTO>();
                XM0209A05S01DTO xm0209A05S01DTO = new XM0209A05S01DTO();
                xm0209A05S01DTO.setSchoolName(xm0209Service.getSchoolName(Integer.parseInt(map.get(i).get("organization_id").toString())));
                xm0209A05S01DTO.setName(map.get(i).get("name").toString());
                xm0209A05S01DTO.setType(map.get(i).get("type").toString());
                xm0209A05S01DTO.setTaskId(Integer.parseInt(map.get(i).get("id").toString()));
                xm0209A05S01DTO.setCreatedAt(Timestamp.valueOf(map.get(i).get("created_at").toString()));
                xm0209A05S01DTO.setBeginAt(Timestamp.valueOf(map.get(i).get("begin_at").toString()));
                xm0209A05S01DTO.setFinishAt(Timestamp.valueOf(map.get(i).get("finish_at").toString()));
                xm0209A05S01DTO.setStatus(map.get(i).get("status").toString());
                System.out.println(map.get(i).get("returnman_id"));
                if(map.get(i).get("returnman_id")!=null){
                    xm0209A05S01DTO.setReturnmanName(xm0209Service.getUserName(Integer.parseInt(map.get(i).get("returnman_id").toString())));
                }
                if(map.get(i).get("urgeman_id")!=null){
                    xm0209A05S01DTO.setUrgemanName(xm0209Service.getUserName(Integer.parseInt(map.get(i).get("urgeman_id").toString())));
                }

                xm0209A05S01DTOList.add(xm0209A05S01DTO);
                xm0209A05DTO.setPetitionLetters(xm0209A05S01DTOList);
                xm0205A05DTOList.add(xm0209A05DTO);
            }
            jsonResult.setData(xm0205A05DTOList);
            jsonResult.setTotalCount(counts);
        }
        else
        {
//            jsonResult.setMessage("暂无最新动态");
        }
        return jsonResult;
    }

    /**
     * A06: 任务详情催报(区县)（任务详情催报）
     */
    @ApiOperation(value = "任务详情催报(区县)", notes = "任务详情催报", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A06")
    public JSONResult A06(@Valid @RequestBody XM0209A06InputDTO input) {
        JSONResult jsonResult = new JSONResult();

        int count =0;
        for(int i=0;i<input.getOrganizationId().length;i++){
            XmTask xmTask=new XmTask();
            xmTask.setId(input.getOrganizationId()[i]);
            xmTask.setUrgedAt(input.getUrgedAt());
            xmTask.setUrgemanId(input.getUrgemanId());
            int flag= xm0209Service.updateUrge(xmTask);
            if(flag==1){
                count++;
            }
        }

        if(count>0) {
            jsonResult.setData("催报成功");
        }else{
            jsonResult.setData("催报失败");
        }

        return jsonResult;
    }

    /**
     * A07: 任务详情退回(区县)（任务详情退回）
     */
    @ApiOperation(value = "任务详情退回(区县)", notes = "任务详情退回", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A07")
    public JSONResult A07(@Valid @RequestBody XM0209A07InputDTO input) {
        JSONResult jsonResult = new JSONResult();

        int count =0;
        for(int i=0;i<input.getOrganizationId().length;i++){
            XmTask xmTask=new XmTask();
            xmTask.setId(input.getOrganizationId()[i]);
            xmTask.setReturnedAt(input.getReturnedAt());
            xmTask.setReturnmanId(input.getReturnedmanId());
            int flag= xm0209Service.updateReturn(xmTask);
            if(flag==1){
                xm0209Service.updateReturnStatus(xmTask);
                count++;
            }
        }

        if(count>0) {
            jsonResult.setData("退回成功");
        }else{
            jsonResult.setData("退回失败");
        }

        return jsonResult;
    }

    /**
     * A08: 动态信息内容获取(分页&查询)(区县)（获取任务内容列表，包含分页和查询）
     */
    @ApiOperation(value = "动态信息内容获取(分页&查询)(区县)", notes = "获取任务内容列表，包含分页和查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A08")
    public JSONResult A08(@Valid XM0209A08InputDTO input) {
        JSONResult<List<XM0209A08DTO>> jsonResult = new JSONResult<>();
        List<XM0209A08DTO> xm0209A08DTOList= new ArrayList<>();
        List<Map<String,Object>> map= new ArrayList<>();
        int counts=0;
        Map inputMap= new HashMap();
        inputMap.put("page",input.getPage()*input.getPageSize());
        inputMap.put("pageSize",input.getPageSize());
        inputMap.put("task_id",input.getTaskId());//当前任务id
        inputMap.put("organization_id",input.getSuperiorTaskId());//上级的任务id||选择的组织
        inputMap.put("user_id",input.getUserId());//当前组织的id
       if(input.getUserId()==-1){
           //计算数量
           counts=xm0209Service.getDynamicSubCounts(inputMap);
           map=xm0209Service.getContentSubAll(inputMap);
       }else{
           List<XM0209A14DTO> xm0209A14DTOList = new ArrayList<>();
           xm0209A14DTOList=xm0209Service.getSubordinateOrganizationName(input.getUserId());
           inputMap.put("list",xm0209A14DTOList);
           //计算数量
           counts=xm0209Service.getDynamicCounts(inputMap);
           map=xm0209Service.getContentAll(inputMap);
       }
        if(map.size()!=0){
            for(int i=0;i<map.size();i++){
                XM0209A08DTO xm0209A08DTO = new XM0209A08DTO();
                List<XM0209A08S01DTO> xm0209A08S01DTOList=new ArrayList<>();

                XM0209A08S01DTO xm0209A08S01DTO=new XM0209A08S01DTO();
                xm0209A08S01DTO.setProcessId(Integer.parseInt(map.get(i).get("id").toString()));
                xm0209A08S01DTO.setName(xm0209Service.getProgressUserName(Integer.parseInt(map.get(i).get("user_id").toString())));
                xm0209A08S01DTO.setCompany(xm0209Service.getOrganization(Integer.parseInt(map.get(i).get("organization_id").toString())));
                xm0209A08S01DTO.setContent(map.get(i).get("content").toString());
                xm0209A08S01DTO.setCreatedAt( Timestamp.valueOf(map.get(i).get("created_at").toString()));
                xm0209A08S01DTO.setReplyNum(xm0209Service.getProgressReplyNum(Integer.parseInt(map.get(i).get("id").toString())));
                xm0209A08S01DTOList.add(xm0209A08S01DTO);
                xm0209A08DTO.setContentLetters(xm0209A08S01DTOList);
                xm0209A08DTOList.add(xm0209A08DTO);
            }
            jsonResult.setData(xm0209A08DTOList);
            jsonResult.setTotalCount(counts);
        }
        else{
         //   jsonResult.setMessage("暂无最新动态");
        }
        return jsonResult;
    }

    /**
     * A09: 动态信息内容回复(区县)（根据id查询最新动态）
     */
    @ApiOperation(value = "动态信息内容回复(区县)", notes = "根据id查询最新动态", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A09")
    public JSONResult A09(@Valid @RequestBody XM0209A09InputDTO input) {
        JSONResult jsonResult = new JSONResult();

        XmProgressReply xmProgressReply=BeanMapper.map(input,XmProgressReply.class);
        xmProgressReply.setTaskId(input.getTaskId());
        xmProgressReply.setOrganizationId(input.getOrganizationId());
        xmProgressReply.setReplymanId(input.getReplymanId());
        xmProgressReply.setProgressId(input.getProgressId());

        xmProgressReply.setContent(input.getContent());
        xmProgressReply.setTaskId(input.getTaskId());
        System.out.println("进入动态内容回复中");

        int flag= xm0209Service.getContentReply(xmProgressReply);
        Object success = "内容回复成功";
        Object error = "回复失败";
        if(flag==1){
            jsonResult.setData(success);
        }
        else {
            jsonResult.setData(error);
        }

        return jsonResult;
    }

    /**
     * A10: 动态内容新增提交(区县)（动态内容新增）
     */
    @ApiOperation(value = "动态内容新增提交(区县)", notes = "动态内容新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A10")
    public JSONResult A10(@Valid @RequestBody XM0209A10InputDTO input) {
        JSONResult jsonResult = new JSONResult();

        XmProgress xmProgress=BeanMapper.map(input,XmProgress.class);
        xmProgress.setOrganizationId(input.getOrganizationId());
        xmProgress.setContent(input.getContent());
        xmProgress.setUserId(input.getUserId());
        xmProgress.setTaskId(input.getTaskId());
        System.out.println("进入动态内容新增中");

        int flag= xm0209Service.getContentAdd(xmProgress);
        Object success = "内容新增成功";
        Object error = "新增失败";
        if(flag==1){
            jsonResult.setData(success);
        }
        else {
            jsonResult.setData(error);
        }

        return jsonResult;
    }

    /**
     * A11: 资料上传提交(区县)（资料上传）
     */
    @ApiOperation(value = "资料上传提交(区县)", notes = "资料上传", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A11")
    public JSONResult A11(@Valid XM0209A11InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        String  filename=input.getFile().getOriginalFilename().toString();
        String type = filename.substring(filename.lastIndexOf(".")+1);
        String Name=filename.substring(0,filename.lastIndexOf("."));
        XmProjectFile xmProjectFile = new XmProjectFile();
        xmProjectFile.setName(Name);
        xmProjectFile.setSize((int) input.getFile().getSize());
        xmProjectFile.setType(type);
        xmProjectFile.setPath(iAttachmentUploaderService.uploadMultipartFile(input.getFile()).getUrl());
        xmProjectFile.setCreatorId(input.getCreatorId());
        xmProjectFile.setTaskId(input.getTaskId());
        xmProjectFile.setOrganizationId(input.getOrganizationId());

        xm0209Service.upLoadFile(xmProjectFile);

        return jsonResult;
    }

    /**
     * A12: 资料删除(区县)（资料删除）
     */
    @ApiOperation(value = "资料删除(区县)", notes = "资料删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A12")
    public JSONResult A12(@Valid @RequestBody XM0209A12InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        xm0209Service.deleteFile(input.getFileId());

        return jsonResult;
    }

    /**
     * A13: 文件下发状态改变（文件下发状态改变）
     */
    @ApiOperation(value = "文件下发状态改变", notes = "文件下发状态改变", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A13")
    public JSONResult A13(@Valid @RequestBody XM0209A13InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        Byte status;
        if(input.getStatus())
            status = 1;
        else
            status = 0;
        XmProjectFile xmProjectFile = new XmProjectFile();
        xmProjectFile.setId(input.getFileId());
        xmProjectFile.setStatus(status);
        xm0209Service.changeStatus(xmProjectFile);

        return jsonResult;
    }

    /**
     * A14: 下级组织获取(区县)（区县下级组织获取）
     */
    @ApiOperation(value = "下级组织获取(区县)", notes = "区县下级组织获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A14")
    public JSONResult A14(@Valid XM0209A14InputDTO input) {
        JSONResult<List<XM0209A14DTO>> jsonResult = new JSONResult<>();
        List<XM0209A14DTO> xm0209A14DTOList = new ArrayList<>();

        xm0209A14DTOList=xm0209Service.getSubordinateOrganizationName(input.getOrganizationId());

        List<XM0209A14DTO> xm0209A14DTOList1=BeanMapper.mapList(xm0209A14DTOList,XM0209A14DTO.class);
        jsonResult.setData(xm0209A14DTOList1);
        return jsonResult;
    }

    /**
     * A15: 修改任务状态（修改任务状态）
     */
    @ApiOperation(value = "修改任务状态", notes = "修改任务状态", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A15")
    public JSONResult A15(@Valid @RequestBody XM0209A15InputDTO input) {
        JSONResult jsonResult = new JSONResult();

        //设置区委的任务为已完成
        xm0209Service.setFinishTask(input.getTaskId());
        xm0209Service.setFinishNULL(input.getTaskId());
        //计算区委同级任务数量
        int num=xm0209Service.distinctsAllNum(input.getTaskId());
        //计算区委同级已完成任务数量
        int finishNum=xm0209Service.distinctsAllFinishNum(input.getTaskId());
        if(num==finishNum){
            //设置市委任务已完成
            int superTaskId=xm0209Service.getSuperiorTaskId(input.getTaskId());
            xm0209Service.setFinishTask(superTaskId);
        }

        return jsonResult;
    }

}
