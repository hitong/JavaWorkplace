package org.ec.xm.api.controller;

import io.swagger.annotations.*;
import org.ec.utils.BeanMapper;
import org.ec.xm.entity.XmProgress;
import org.ec.xm.entity.XmProgressReply;
import org.ec.xm.entity.XmTask;
import org.ec.xm.service.XM0205Service;
import org.ec.utils.JSONResult;
import org.ec.xm.dto.XM0205.*;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;
import javax.validation.Valid;

/**
 * XM0205: 项目执行 - 任务详情（基础信息页面）
 * 作者：
 * 日期：
 */
@RestController
@CrossOrigin
@Api("XM0205: 项目执行 - 任务详情（基础信息页面）")
@RequestMapping("/XM0205")
public class XM0205Controller extends BaseController {

    /**
     * XM0205Service
     */
    private final XM0205Service xm0205Service;

    @Autowired
    public XM0205Controller(XM0205Service xm0205Service) {
        this.xm0205Service = xm0205Service;
    }

    /**
     * A01: 任务信息获取（根据id查询任务详情）
     */
    @ApiOperation(value = "任务信息获取", notes = "根据id查询任务详情", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01(@Valid XM0205A01InputDTO input) {
        JSONResult<XM0205A01DTO> jsonResult = new JSONResult<>();
        XM0205A01DTO xm0205A01DTO = new XM0205A01DTO();
        XmTask xmTask= xm0205Service.getTaskById(input.getTaskId());
        if(xmTask==null){
            return null;
        }
        xm0205A01DTO.setName(xm0205Service.getProjectName(xmTask.getProjectId())); //xmTask.getProjectId()
        xm0205A01DTO.setTaskName(xmTask.getName());
        xm0205A01DTO.setStatus(xmTask.getStatus());
        xm0205A01DTO.setType(xmTask.getType());
        xm0205A01DTO.setBeginAt(xmTask.getBeginAt());
        xm0205A01DTO.setFinishAt(xmTask.getFinishAt());
        xm0205A01DTO.setDataTemplateId(xmTask.getDataTemplateId());
        xm0205A01DTO.setRemark(xmTask.getRemark());
        xm0205A01DTO.setProjectId(xmTask.getProjectId());
        XM0205A01DTO xm0205A01DTO1= BeanMapper.map(xm0205A01DTO,XM0205A01DTO.class);
        jsonResult.setData(xm0205A01DTO1);
        return jsonResult;
    }

    /**
     * A02: 最新动态获取（根据id查询最新动态）
     */
    @ApiOperation(value = "最新动态获取", notes = "根据id查询最新动态", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A02")
    public JSONResult A02(@Valid XM0205A02InputDTO input) {
        JSONResult<List<XM0205A08DTO>> jsonResult = new JSONResult<>();
        List<XM0205A08DTO> xm0205A08DTOList= new ArrayList<>();
        List<Map<String,Object>> map= new ArrayList<>();
        Map inputMap= new HashMap();
        inputMap.put("task_id",input.getTaskId());
        inputMap.put("superiorTaskId",input.getSuperiorTaskId());

        List<XM0205A11DTO> xm0205A11DTOList = new ArrayList<>();
        xm0205A11DTOList=xm0205Service.getSubordinateOrganizationName(input.getSuperiorTaskId());
        inputMap.put("list",xm0205A11DTOList);
        inputMap.put("size",xm0205A11DTOList.size());
        //计算数量
        //map=xm0205Service.getContentAll(inputMap);
       map=xm0205Service.getContent(inputMap);
        if(map.size()!=0){
            for(int i=0;i<map.size();i++){
                XM0205A08DTO xm0205A08DTO = new XM0205A08DTO();
                List<XM0205A08S01DTO> xm0205A08S01DTOList=new ArrayList<>();

                XM0205A08S01DTO xm0205A08S01DTO=new XM0205A08S01DTO();

                xm0205A08S01DTO.setProcessId(Integer.parseInt(map.get(i).get("id").toString()));
                xm0205A08S01DTO.setName(xm0205Service.getProgressUserName(Integer.parseInt(map.get(i).get("user_id").toString())));
                xm0205A08S01DTO.setCompany(xm0205Service.getOrganization(Integer.parseInt(map.get(i).get("organization_id").toString())));
                xm0205A08S01DTO.setContent(map.get(i).get("content").toString());
                xm0205A08S01DTO.setCreatedAt( Timestamp.valueOf(map.get(i).get("created_at").toString()));
                xm0205A08S01DTO.setReplyNum(xm0205Service.getProgressReplyNum(Integer.parseInt(map.get(i).get("id").toString())));
                xm0205A08S01DTOList.add(xm0205A08S01DTO);
                xm0205A08DTO.setContentLetters(xm0205A08S01DTOList);
                xm0205A08DTOList.add(xm0205A08DTO);

            }
            jsonResult.setData(xm0205A08DTOList);
        }
        return jsonResult;
    }


    /**
     * A03: 最新动态回复信息（最新动态回复信息）
     */
    @ApiOperation(value = "最新动态回复信息", notes = "最新动态回复信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JSONResult A03(@Valid @RequestBody XM0205A03InputDTO input) {
        JSONResult jsonResult = new JSONResult();


        return jsonResult;
    }

    /**
     * A04: 最新动态回复查看（最新动态回复查看）
     */
    @ApiOperation(value = "最新动态回复查看", notes = "最新动态回复查看", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A04")
    public JSONResult A04(@Valid XM0205A04InputDTO input) {
        JSONResult<List<XM0205A04DTO>> jsonResult = new JSONResult<>();
        List<XM0205A04DTO> xm0205A04DTOList = new ArrayList<>();

        Map inputMap= new HashMap();
        int counts=0;
        inputMap.put("page",input.getPage()*input.getPageSize());
        inputMap.put("pageSize",input.getPageSize());
        inputMap.put("progress_id",input.getProgressId());

        List<XmProgressReply> xmProgressReplyList= new ArrayList<>();
        xmProgressReplyList=xm0205Service.getProgressReply(inputMap);
        counts=xm0205Service.getProgressReplyNum(input.getProgressId());
        for(int i=0;i<xmProgressReplyList.size();i++){
            XM0205A04DTO xm0205A04DTO=new XM0205A04DTO();
            xm0205A04DTO.setOrganizationName(xm0205Service.getOrganization(xmProgressReplyList.get(i).getOrganizationId()));
            xm0205A04DTO.setContent(xmProgressReplyList.get(i).getContent());
            xm0205A04DTO.setCreatedAt(xmProgressReplyList.get(i).getCreatedAt());
            xm0205A04DTO.setName(xm0205Service.getProgressReplyUserName(xmProgressReplyList.get(i).getReplymanId()));
            xm0205A04DTOList.add(xm0205A04DTO);
        }
        jsonResult.setData(xm0205A04DTOList);
        jsonResult.setTotalCount(counts);

        return jsonResult;
    }

    /**
     * A05: 任务详情获取(分页&查询)（获取任务完成情况列表，包含分页和查询）
     */
    @ApiOperation(value = "任务详情获取(分页&查询)", notes = "获取任务完成情况列表，包含分页和查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JSONResult A05(@Valid  XM0205A05InputDTO input) {
        JSONResult<List<XM0205A05DTO>> jsonResult = new JSONResult<>();

        List<XM0205A05DTO> xm0205A05DTOList= new ArrayList<>();
        List<Map<String,Object>> map= new ArrayList<>();
        Map inputMap= new HashMap();
        inputMap.put("page",input.getPage()*input.getPageSize());
        inputMap.put("pageSize",input.getPageSize());
        inputMap.put("superior_task_id",input.getTaskId());
        inputMap.put("status",input.getStatus());

        int counts=xm0205Service.getCounts(inputMap);
        map=xm0205Service.getAllTaskById(inputMap);
        for(int i=0;i<map.size();i++){
            XM0205A05DTO xm0205A05DTO = new XM0205A05DTO();
            List<XM0205A05S01DTO> xm0205A05S01DTOList=new ArrayList<XM0205A05S01DTO>();
            XM0205A05S01DTO xm0205A05S01DTO=new XM0205A05S01DTO();

            xm0205A05S01DTO.setOrganizationName(xm0205Service.getOrganizationName(Integer.parseInt(map.get(i).get("organization_id").toString())));
            xm0205A05S01DTO.setName(map.get(i).get("name").toString());
            xm0205A05S01DTO.setType(map.get(i).get("type").toString());
            xm0205A05S01DTO.setTaskId(Integer.parseInt(map.get(i).get("id").toString()));
            xm0205A05S01DTO.setCreatedAt( Timestamp.valueOf(map.get(i).get("created_at").toString()));
            xm0205A05S01DTO.setBeginAt( Timestamp.valueOf(map.get(i).get("begin_at").toString()));
            xm0205A05S01DTO.setFinishAt( Timestamp.valueOf(map.get(i).get("finish_at").toString()));
            xm0205A05S01DTO.setStatus(map.get(i).get("status").toString());
            if(map.get(i).get("returnman_id")!=null){
                xm0205A05S01DTO.setReturnmanName(xm0205Service.getUserName(Integer.parseInt(map.get(i).get("returnman_id").toString())));
            }
            if(map.get(i).get("urgeman_id")!=null){
                xm0205A05S01DTO.setUrgemanName(xm0205Service.getUserName(Integer.parseInt(map.get(i).get("urgeman_id").toString())));
            }
            xm0205A05S01DTOList.add(xm0205A05S01DTO);
            xm0205A05DTO.setPetitionLetters(xm0205A05S01DTOList);
            xm0205A05DTOList.add(xm0205A05DTO);
        }

        jsonResult.setData(xm0205A05DTOList);
        jsonResult.setTotalCount(counts);
        return jsonResult;
    }

    /**
     * A06: 任务详情催报（任务详情催报）
     */
    @ApiOperation(value = "任务详情催报", notes = "任务详情催报", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A06")
    public JSONResult A06(@Valid @RequestBody XM0205A06InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        int count =0;
        for(int i=0;i<input.getOrganizationId().length;i++){
            XmTask xmTask=new XmTask();
            xmTask.setId(input.getOrganizationId()[i]);
            xmTask.setUrgedAt(input.getUrgedAt());
            xmTask.setUrgemanId(input.getUrgemanId());
            int flag= xm0205Service.updateUrge(xmTask);
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
     * A07: 任务详情退回（任务详情退回）
     */
    @ApiOperation(value = "任务详情退回", notes = "任务详情退回", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A07")
    public JSONResult A07(@Valid @RequestBody XM0205A07InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        //XmTask xmTask=BeanMapper.map(input,XmTask.class);
        int count =0;
        for(int i=0;i<input.getOrganizationId().length;i++){
            XmTask xmTask=new XmTask();
            xmTask.setId(input.getOrganizationId()[i]);
            xmTask.setReturnedAt(input.getReturnedAt());
            xmTask.setReturnmanId(input.getReturnmanId());
            int flag= xm0205Service.updateReturn(xmTask);
            if(flag==1){
                xm0205Service.updateReturnStatus(xmTask);
                int superTaskId=xm0205Service.getSuperiorTaskId(xmTask.getId());//获取市级任务id
                xm0205Service.setDistrib(superTaskId);//设置市级任务为执行中
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
     * A08: 动态信息内容获取(分页&查询)（获取任务内容列表，包含分页和查询）
     */
    @ApiOperation(value = "动态信息内容获取(分页&查询)", notes = "获取任务内容列表，包含分页和查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A08")
    public JSONResult A08(@Valid XM0205A08InputDTO input) {
        JSONResult<List<XM0205A08DTO>> jsonResult = new JSONResult<>();
        List<XM0205A08DTO> xm0205A08DTOList= new ArrayList<>();
        List<Map<String,Object>> map= new ArrayList<>();
        Map inputMap= new HashMap();
        int counts=0;
        inputMap.put("page",input.getPage()*input.getPageSize());
        inputMap.put("pageSize",input.getPageSize());
        inputMap.put("task_id",input.getTaskId());
        inputMap.put("organization_id",input.getSuperiorTaskId());
        inputMap.put("user_id",input.getUserId());
        if(input.getUserId()==-1){
            //计算数量
            counts=xm0205Service.getDynamicSubCounts(inputMap);
            map=xm0205Service.getContentSubAll(inputMap);
        }else{
            List<XM0205A11DTO> xm0205A11DTOList = new ArrayList<>();
            xm0205A11DTOList=xm0205Service.getSubordinateOrganizationName(input.getSuperiorTaskId());
            inputMap.put("list",xm0205A11DTOList);
            //计算数量
            counts=xm0205Service.getProgressCounts(inputMap);
            map=xm0205Service.getContentAll(inputMap);
        }
        if(map.size()!=0){
            for(int i=0;i<map.size();i++){
                XM0205A08DTO xm0205A08DTO = new XM0205A08DTO();
                List<XM0205A08S01DTO> xm0205A08S01DTOList=new ArrayList<>();

                XM0205A08S01DTO xm0205A08S01DTO=new XM0205A08S01DTO();

                xm0205A08S01DTO.setProcessId(Integer.parseInt(map.get(i).get("id").toString()));
                xm0205A08S01DTO.setName(xm0205Service.getProgressUserName(Integer.parseInt(map.get(i).get("user_id").toString())));
                xm0205A08S01DTO.setCompany(xm0205Service.getOrganization(Integer.parseInt(map.get(i).get("organization_id").toString())));
                xm0205A08S01DTO.setContent(map.get(i).get("content").toString());
                xm0205A08S01DTO.setCreatedAt( Timestamp.valueOf(map.get(i).get("created_at").toString()));
                xm0205A08S01DTO.setReplyNum(xm0205Service.getProgressReplyNum(Integer.parseInt(map.get(i).get("id").toString())));
                xm0205A08S01DTOList.add(xm0205A08S01DTO);
                xm0205A08DTO.setContentLetters(xm0205A08S01DTOList);
                xm0205A08DTOList.add(xm0205A08DTO);

            }
            jsonResult.setData(xm0205A08DTOList);
            jsonResult.setTotalCount(counts);
        }
        else {
            //jsonResult.setMessage("暂无最新动态");
        }
        return jsonResult;
    }

    /**
     * A09: 动态信息内容回复（根据id查询最新动态）
     */
    @ApiOperation(value = "动态信息内容回复", notes = "根据id查询最新动态", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A09")
    public JSONResult A09(@Valid @RequestBody XM0205A09InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        XmProgressReply xmProgressReply=BeanMapper.map(input,XmProgressReply.class);
        xmProgressReply.setTaskId(input.getTaskId());
        xmProgressReply.setOrganizationId(input.getOrganizationId());
        xmProgressReply.setReplymanId(input.getReplymanId());
        xmProgressReply.setProgressId(input.getProgressId());
        //xmProgressReply.setCreatedAt(input.getCreatedAt());

       // xmProgressReply.setUpdatedAt(new Date().format("yyyy-MM-dd HH:mm:ss"));

        xmProgressReply.setContent(input.getContent());
        xmProgressReply.setTaskId(input.getTaskId());
        System.out.println("进入动态内容回复中");

        int flag= xm0205Service.getContentReply(xmProgressReply);
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
     * A10: 动态内容新增提交（动态内容新增）
     */
    @ApiOperation(value = "动态内容新增提交", notes = "动态内容新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A10")
    public JSONResult A10(@Valid @RequestBody XM0205A10InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        XmProgress xmProgress=BeanMapper.map(input,XmProgress.class);
        xmProgress.setOrganizationId(input.getOrganizationId());
        xmProgress.setContent(input.getContent());
        xmProgress.setUserId(input.getUserId());
        xmProgress.setTaskId(input.getTaskId());
        System.out.println("进入动态内容新增中");

        int flag= xm0205Service.getContentAdd(xmProgress);
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
     * A11: 下级组织获取（获取下级组织）
     */
    @ApiOperation(value = "下级组织获取", notes = "获取下级组织", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A11")
    public JSONResult A11(@Valid XM0205A11InputDTO input) {
        JSONResult<List<XM0205A11DTO>> jsonResult = new JSONResult<>();
        List<XM0205A11DTO> xm0205A11DTOList = new ArrayList<>();

        xm0205A11DTOList=xm0205Service.getSubordinateOrganizationName(input.getOrganizationId());

        List<XM0205A11DTO> xm0205A11DTOList1=BeanMapper.mapList(xm0205A11DTOList,XM0205A11DTO.class);

        jsonResult.setData(xm0205A11DTOList1);
        return jsonResult;
    }
}
