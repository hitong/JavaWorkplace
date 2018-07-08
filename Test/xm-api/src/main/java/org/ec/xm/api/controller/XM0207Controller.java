package org.ec.xm.api.controller;

import io.swagger.annotations.*;
import org.ec.attachment.service.IAttachmentUploaderService;
import org.ec.utils.BeanMapper;
import org.ec.xm.entity.XmProgress;
import org.ec.xm.entity.XmProgressReply;
import org.ec.xm.entity.XmProjectFile;
import org.ec.xm.entity.XmTask;
import org.ec.xm.service.XM0207Service;
import org.ec.utils.JSONResult;
import org.ec.xm.dto.XM0207.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import javax.validation.Valid;

/**
 * XM0207: 项目执行 - 任务详情(学校)（基础信息页面）
 * 作者：
 * 日期：
 */
@RestController
@CrossOrigin
@Api("XM0207: 项目执行 - 任务详情(学校)（基础信息页面）")
@RequestMapping("/XM0207")
public class XM0207Controller extends BaseController {

    /**
     * XM0207Service
     */
    private final XM0207Service xm0207Service;
    private final IAttachmentUploaderService iAttachmentUploaderService;

    @Autowired
    public XM0207Controller(XM0207Service xm0207Service, IAttachmentUploaderService iAttachmentUploaderService) {
        this.xm0207Service = xm0207Service;
        this.iAttachmentUploaderService = iAttachmentUploaderService;
    }

    /**
     * A01: 任务信息获取(学校)（根据id查询任务详情）
     */
    @ApiOperation(value = "任务信息获取(学校)", notes = "根据id查询任务详情", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01(@Valid XM0207A01InputDTO input) {
        JSONResult<XM0207A01DTO> jsonResult = new JSONResult<>();
        XM0207A01DTO xm0207A01DTO = new XM0207A01DTO();
        XmTask xmTask = xm0207Service.getTaskById(input.getTaskId());
        if(xmTask==null){
            return null;
        }
        xm0207A01DTO.setName(xm0207Service.getProjectName(xmTask.getProjectId()));
        xm0207A01DTO.setTaskName(xmTask.getName());
        xm0207A01DTO.setStatus(xmTask.getStatus());
        xm0207A01DTO.setType(xmTask.getType());
        xm0207A01DTO.setBeginAt(xmTask.getBeginAt());
        xm0207A01DTO.setFinishAt(xmTask.getFinishAt());
        xm0207A01DTO.setSuperiorOrganizationId(xmTask.getSuperiorOrganizationId());
        xm0207A01DTO.setSuperiorTaskId(xmTask.getSuperiorTaskId());
        xm0207A01DTO.setOrganizationId(xmTask.getOrganizationId());
        XM0207A01DTO xm0205A01DTO1 = BeanMapper.map(xm0207A01DTO, XM0207A01DTO.class);
        jsonResult.setData(xm0205A01DTO1);
        return jsonResult;
    }

    /**
     * A02: 最新动态获取(学校)（根据id查询最新动态）
     */
    @ApiOperation(value = "最新动态获取(学校)", notes = "根据id查询最新动态", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A02")
    public JSONResult A02(@Valid XM0207A02InputDTO input) {
     /*   JSONResult<List<XM0207A02DTO>> jsonResult = new JSONResult<>();
        List<XM0207A02DTO> xm0209A08DTOList= new ArrayList<>();
        List<Map<String,Object>> map= new ArrayList<>();

        map=xm0207Service.getContent(input.getTaskId());
        if(map.size()!=0){
            for(int i=0;i<map.size();i++){
                XM0207A02DTO xm0207A02DTO = new XM0207A02DTO();
                //List<XM0209A08S01DTO> xm0209A08S01DTOList=new ArrayList<>();

                // XM0209A08S01DTO xm0209A08S01DTO=new XM0209A08S01DTO();
                xm0207A02DTO.setProcessId(Integer.parseInt(map.get(i).get("id").toString()));
                xm0207A02DTO.setName(xm0207Service.getProgressUserName(Integer.parseInt(map.get(i).get("user_id").toString())));
                xm0207A02DTO.setOrganizationName(xm0207Service.getOrganization(Integer.parseInt(map.get(i).get("organization_id").toString())));
                xm0207A02DTO.setContent(map.get(i).get("content").toString());
                xm0207A02DTO.setCreatedAt( Timestamp.valueOf(map.get(i).get("created_at").toString()));
                // XM0209A02DTO.setReplyNum(xm0209Service.getProgressReplyNum(Integer.parseInt(map.get(i).get("id").toString())));
                //xm0209A08S01DTOList.add(xm0209A08S01DTO);
                // XM0209A02DTO.setContentLetters(xm0209A08S01DTOList);
                xm0209A08DTOList.add(xm0207A02DTO);
            }
            jsonResult.setData(xm0209A08DTOList);
        }
        else{
            jsonResult.setMessage("暂无最新动态");
        }
        return jsonResult;*/
        JSONResult<List<XM0207A05DTO>> jsonResult = new JSONResult<>();
        List<XM0207A05DTO> xm0209A08DTOList = new ArrayList<>();
        List<Map<String, Object>> map = new ArrayList<>();
        Map inputMap = new HashMap();
        inputMap.put("taskId",input.getTaskId());
        inputMap.put("superiorTaskId",input.getSuperiorTaskId());
       // inputMap.put("organization_id",input.getOrganizationId());
        //inputMap.put("user_id",input.getUserId());
        map = xm0207Service.getContent(inputMap);
        if(map.size()!=0) {
            for (int i = 0; i < map.size(); i++) {
                XM0207A05DTO xm0207A05DTO = new XM0207A05DTO();
                List<XM0207A05S01DTO> xm0207A05S01DTOList = new ArrayList<>();

                XM0207A05S01DTO xm0207A05S01DTO = new XM0207A05S01DTO();
                xm0207A05S01DTO.setProcessId(Integer.parseInt(map.get(i).get("id").toString()));
                xm0207A05S01DTO.setName(xm0207Service.getProgressUserName(Integer.parseInt(map.get(i).get("user_id").toString())));
                xm0207A05S01DTO.setCompany(xm0207Service.getOrganization(Integer.parseInt(map.get(i).get("organization_id").toString())));
                xm0207A05S01DTO.setContent(map.get(i).get("content").toString());
                xm0207A05S01DTO.setCreatedAt(Timestamp.valueOf(map.get(i).get("created_at").toString()));
                xm0207A05S01DTO.setReplyNum(xm0207Service.getProgressReplyNum(Integer.parseInt(map.get(i).get("id").toString())));
                xm0207A05S01DTOList.add(xm0207A05S01DTO);
                xm0207A05DTO.setContentLetters(xm0207A05S01DTOList);
                xm0209A08DTOList.add(xm0207A05DTO);

            }
            jsonResult.setData(xm0209A08DTOList);
        }
        else {
//            jsonResult.setMessage("暂无最新动态");
        }
        return jsonResult;
    }


    /**
     * A03: 资料列表获取(学校)（-）
     */
    @ApiOperation(value = "资料列表获取(学校)", notes = "-", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A03")
    public JSONResult A03(@Valid XM0207A03InputDTO input) {
        JSONResult<List<XM0207A03DTO>> jsonResult = new JSONResult<>();
        List<XmProjectFile> xmProjectFileList = xm0207Service.getFileListByTaskId(input.getTaskId(),input.getOrganizationId());
        List<XM0207A03DTO> xm0207A03DTOList = BeanMapper.mapList(xmProjectFileList, XM0207A03DTO.class);

        jsonResult.setData(xm0207A03DTOList);
        return jsonResult;
    }

    /**
     * A04: 最新动态回复查看(学校)（最新动态回复查看）
     */
    @ApiOperation(value = "最新动态回复查看(学校)", notes = "最新动态回复查看", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A04")
    public JSONResult A04(@Valid XM0207A04InputDTO input) {
        JSONResult<List<XM0207A04DTO>> jsonResult = new JSONResult<>();
        List<XM0207A04DTO> xm0205A04DTOList = new ArrayList<>();

        List<XmProgressReply> xmProgressReplyList= new ArrayList<>();

        Map inputMap= new HashMap();
        int counts=0;
        inputMap.put("page",input.getPage()*input.getPageSize());
        inputMap.put("pageSize",input.getPageSize());
        inputMap.put("progress_id",input.getProgressId());
        xmProgressReplyList=xm0207Service.getProgressReply(inputMap);
        counts=xm0207Service.getProgressReplyNum(input.getProgressId());
        for(int i=0;i<xmProgressReplyList.size();i++){
            XM0207A04DTO xm0205A04DTO=new XM0207A04DTO();
            xm0205A04DTO.setOrganizationName(xm0207Service.getOrganization(xmProgressReplyList.get(i).getOrganizationId()));
            xm0205A04DTO.setContent(xmProgressReplyList.get(i).getContent());
            xm0205A04DTO.setCreatedAt(xmProgressReplyList.get(i).getCreatedAt());
            xm0205A04DTO.setName(xm0207Service.getProgressReplyUserName(xmProgressReplyList.get(i).getReplymanId()));
            xm0205A04DTOList.add(xm0205A04DTO);
        }
        jsonResult.setData(xm0205A04DTOList);
        jsonResult.setTotalCount(counts);

        return jsonResult;
    }

    /**
     * A05: 动态信息内容获取(分页&查询)(学校)（获取任务内容列表，包含分页和查询）
     */
    @ApiOperation(value = "动态信息内容获取(分页&查询)(学校)", notes = "获取任务内容列表，包含分页和查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JSONResult A05(@Valid XM0207A05InputDTO input) {
        JSONResult<List<XM0207A05DTO>> jsonResult = new JSONResult<>();
        List<XM0207A05DTO> xm0209A08DTOList = new ArrayList<>();
        List<Map<String, Object>> map = new ArrayList<>();
        Map inputMap = new HashMap();
        inputMap.put("page", input.getPage() * input.getPageSize());
        inputMap.put("pageSize", input.getPageSize());
        inputMap.put("task_id", input.getTaskId());
       inputMap.put("organization_id",input.getSuperiorTaskId());
       inputMap.put("user_id",input.getUserId());
        //计算数量
        int counts = xm0207Service.getDynamicCounts(inputMap);
        map = xm0207Service.getContentAll(inputMap);
        if(map.size()!=0) {
            for (int i = 0; i < map.size(); i++) {
                XM0207A05DTO xm0207A05DTO = new XM0207A05DTO();
                List<XM0207A05S01DTO> xm0207A05S01DTOList = new ArrayList<>();

                XM0207A05S01DTO xm0207A05S01DTO = new XM0207A05S01DTO();
                xm0207A05S01DTO.setProcessId(Integer.parseInt(map.get(i).get("id").toString()));
                xm0207A05S01DTO.setName(xm0207Service.getProgressUserName(Integer.parseInt(map.get(i).get("user_id").toString())));
                xm0207A05S01DTO.setCompany(xm0207Service.getOrganization(Integer.parseInt(map.get(i).get("organization_id").toString())));
                xm0207A05S01DTO.setContent(map.get(i).get("content").toString());
                xm0207A05S01DTO.setCreatedAt(Timestamp.valueOf(map.get(i).get("created_at").toString()));
                xm0207A05S01DTO.setReplyNum(xm0207Service.getProgressReplyNum(Integer.parseInt(map.get(i).get("id").toString())));
                xm0207A05S01DTOList.add(xm0207A05S01DTO);
                xm0207A05DTO.setContentLetters(xm0207A05S01DTOList);
                xm0209A08DTOList.add(xm0207A05DTO);

            }
            jsonResult.setData(xm0209A08DTOList);
            jsonResult.setTotalCount(counts);
        }
        else {
         //   jsonResult.setMessage("暂无最新动态");
        }
        return jsonResult;
    }


    /**
     * A06: 动态信息内容回复(学校)（根据id查询最新动态）
     */
    @ApiOperation(value = "动态信息内容回复(学校)", notes = "根据id查询最新动态", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A06")
    public JSONResult A06(@Valid @RequestBody XM0207A06InputDTO input) {
        JSONResult jsonResult = new JSONResult();

        XmProgressReply xmProgressReply=BeanMapper.map(input,XmProgressReply.class);
        xmProgressReply.setTaskId(input.getTaskId());
        xmProgressReply.setOrganizationId(input.getOrganizationId());
        xmProgressReply.setReplymanId(input.getReplymanId());
        xmProgressReply.setProgressId(input.getProgressId());

        xmProgressReply.setContent(input.getContent());
        xmProgressReply.setTaskId(input.getTaskId());
        System.out.println("进入动态内容回复中");

        int flag= xm0207Service.getContentReply(xmProgressReply);
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
     * A07: 动态内容新增提交(学校)（动态内容新增）
     */
    @ApiOperation(value = "动态内容新增提交(学校)", notes = "动态内容新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A07")
    public JSONResult A07(@Valid @RequestBody XM0207A07InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        XmProgress xmProgress=BeanMapper.map(input,XmProgress.class);
        xmProgress.setOrganizationId(input.getOrganizationId());
        xmProgress.setContent(input.getContent());
        xmProgress.setUserId(input.getUserId());
        xmProgress.setTaskId(input.getTaskId());
        System.out.println("进入动态内容新增中");

        int flag= xm0207Service.getContentAdd(xmProgress);
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
     * A08: 资料上传提交(学校)（资料上传）
     */
    @ApiOperation(value = "资料上传提交(学校)", notes = "资料上传", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A08")
    public JSONResult A08(@Valid XM0207A08InputDTO input) {
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

        xm0207Service.fileAddApiByTask(xmProjectFile);

        return jsonResult;
    }

    /**
     * A09: 资料删除(学校)（资料删除）
     */
    @ApiOperation(value = "资料删除(学校)", notes = "资料删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A09")
    public JSONResult A09(@Valid @RequestBody XM0207A09InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        xm0207Service.deleteFileByFileId(input.getFileId());

        return jsonResult;
    }

    /**
     * A10: 修改任务状态(学校)（修改任务状态）
     */
    @ApiOperation(value = "修改任务状态(学校)", notes = "修改任务状态", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A10")
    public JSONResult A10(@Valid @RequestBody XM0207A10InputDTO input) {
        JSONResult jsonResult = new JSONResult();

        xm0207Service.setFinishTask(input.getTaskId());
        xm0207Service.setFinishNULL(input.getTaskId());
        return jsonResult;
    }

}
