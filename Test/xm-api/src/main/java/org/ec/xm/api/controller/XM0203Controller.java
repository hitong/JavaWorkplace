package org.ec.xm.api.controller;

import io.swagger.annotations.*;
import org.ec.attachment.service.IAttachmentUploaderService;
import org.ec.utils.BeanMapper;
import org.ec.xm.entity.XmProjectFile;
import org.ec.xm.service.XM0203Service;
import org.ec.utils.JSONResult;
import org.ec.xm.dto.XM0203.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import javax.validation.Valid;

/**
 * XM0203: 项目执行 - 项目详情（基础信息页面）
 * 作者：
 * 日期：
 */
@RestController
@CrossOrigin
@Api("XM0203: 项目执行 - 项目详情（基础信息页面）")
@RequestMapping("/XM0203")
public class XM0203Controller extends BaseController {

    /**
     * XM0203Service
     */
    private final XM0203Service xm0203Service;
    private final IAttachmentUploaderService iAttachmentUploaderService;

    @Autowired
    public XM0203Controller(XM0203Service xm0203Service, IAttachmentUploaderService iAttachmentUploaderService) {
        this.xm0203Service = xm0203Service;
        this.iAttachmentUploaderService = iAttachmentUploaderService;
    }

    /**
     * A01: 任务状态查询（任务状态查询）
     */
    @ApiOperation(value = "任务状态查询", notes = "任务状态查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01(@Valid XM0203A01InputDTO input) {
        JSONResult<List<XM0203A01DTO>> jsonResult = new JSONResult<>();
        List<XM0203A01DTO> xm0203A01DTOList = new ArrayList<>();
        xm0203A01DTOList = xm0203Service.getTaskList(input);
        if (xm0203A01DTOList.size() >= 0) {
            List<XM0203A01DTO> returnedMh0105A01DTOList = new ArrayList<>();
            int page = input.getPage();
            int pageSize = input.getPageSize();
            int totalCount = xm0203A01DTOList.size();
            for (int i = (page - 1) * (pageSize); i < xm0203A01DTOList.size() && i < page * pageSize; i++) {
                returnedMh0105A01DTOList.add(xm0203A01DTOList.get(i));
            }
            jsonResult.setTotalCount(totalCount);
            jsonResult.setData(returnedMh0105A01DTOList);
            return jsonResult;
        } else {
            jsonResult.setMessage("获取列表失败");
            return jsonResult;
        }
    }

    /**
     * A02: 项目信息（项目信息获取）
     */
    @ApiOperation(value = "项目信息", notes = "项目信息获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A02")
    public JSONResult A02(@Valid XM0203A02InputDTO input) {
        JSONResult<XM0203A02DTO> jsonResult = new JSONResult<>();
        XM0203A02DTO xm0203A02DTO = new XM0203A02DTO();
        xm0203A02DTO = xm0203Service.getProjectDetailById(input.getProjectId(), input.getOrganizaitonId());
        jsonResult.setData(xm0203A02DTO);
        return jsonResult;
    }

    /**
     * A03: 资金分配（项目资金分配）
     */
    @ApiOperation(value = "资金分配", notes = "项目资金分配", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JSONResult A03(@RequestBody XM0203A03InputDTO input) throws Exception {
        JSONResult jsonResult = new JSONResult();
        int mark = 0;
        mark = xm0203Service.addMoney(input);
        if (mark > 0) {
            jsonResult.setData(mark);
            return jsonResult;
        } else {
            throw new Exception("请至少输入一位组织的金额");
        }
    }

    /**
     * A04: 文件上传（文件上传）
     */
    @ApiOperation(value = "文件上传", notes = "文件上传", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JSONResult A04(XM0203A04InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        String filename = input.getFile().getOriginalFilename().toString();
        String type = filename.substring(filename.lastIndexOf(".") + 1);
        String Name = filename.substring(0, filename.lastIndexOf("."));
        Byte status;
        XmProjectFile xmProjectFile = new XmProjectFile();
        xmProjectFile.setName(Name);
        xmProjectFile.setSize((int) input.getFile().getSize());
        xmProjectFile.setType(type);
        xmProjectFile.setPath(iAttachmentUploaderService.uploadMultipartFile(input.getFile()).getUrl());
        xmProjectFile.setOrganizationId(input.getOrganizationId());
        xmProjectFile.setCreatorId(input.getCreatorId());
        xmProjectFile.setFundingId(input.getFundingId());
        xmProjectFile.setSource(input.getSource());
        if (input.getStatus()) {
            status = 1;
        } else {
            status = 0;
        }
        xmProjectFile.setStatus(status);

        xm0203Service.fileUpLoad(xmProjectFile);
        return jsonResult;
    }

    /**
     * A05: 文件删除（文件删除）
     */
    @ApiOperation(value = "文件删除", notes = "文件删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A05")
    public JSONResult A05(@Valid @RequestBody XM0203A05InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        xm0203Service.deleteFile(input.getProjectFileId());

        return jsonResult;
    }

    /**
     * A06: 资金下达展示（项目信息获取）
     */
    @ApiOperation(value = "资金下达展示", notes = "项目信息获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A06")
    public JSONResult A06(@Valid XM0203A06InputDTO input) {
        JSONResult<List<XM0203A06DTO>> jsonResult = new JSONResult<>();
        List<XM0203A06DTO> xm0203A06DTOList = new ArrayList<>();

        xm0203A06DTOList = xm0203Service.getDownList(input);
        if (xm0203A06DTOList.size() >= 0) {
            List<XM0203A06DTO> returnedMh0105A01DTOList = new ArrayList<>();
            int page = input.getPage();
            int pageSize = input.getPageSize();
            int totalCount = xm0203A06DTOList.size();
            for (int i = (page - 1) * (pageSize); i < xm0203A06DTOList.size() && i < page * pageSize; i++) {
                returnedMh0105A01DTOList.add(xm0203A06DTOList.get(i));
            }
            jsonResult.setTotalCount(totalCount);
            jsonResult.setData(returnedMh0105A01DTOList);
            return jsonResult;
        } else {
            jsonResult.setMessage("获取列表失败");
            return jsonResult;
        }
    }

    /**
     * A07: 资金下达详情（获取区县资金下达详情）
     */
    @ApiOperation(value = "资金下达详情", notes = "获取区县资金下达详情", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A07")
    public JSONResult A07(XM0203A07InputDTO input) {
        JSONResult<List<XM0203A07DTO>> jsonResult = new JSONResult<>();
        List<XM0203A07DTO> xm0203A07DTOList = new ArrayList<>();
        xm0203A07DTOList = xm0203Service.getDownDetail(input);

        if (xm0203A07DTOList.size() >= 0) {
            jsonResult.setTotalCount(xm0203A07DTOList.size());
            jsonResult.setData(xm0203A07DTOList);
            return jsonResult;
        } else {
            jsonResult.setMessage("获取列表失败");
            return jsonResult;
        }
    }

    /**
     * A08: 资金信息获取（获取资金来源的信息）
     */
    @ApiOperation(value = "资金信息获取", notes = "获取资金来源的信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A08")
    public JSONResult A08(@Valid XM0203A08InputDTO input) {
        JSONResult<XM0203A08DTO> jsonResult = new JSONResult<>();
        XM0203A08DTO xm0203A08DTO = new XM0203A08DTO();
        xm0203A08DTO = xm0203Service.getAllSource(input);
        jsonResult.setData(xm0203A08DTO);
        return jsonResult;
    }

    /**
     * A09: 资金来源新增（新增资金来源）
     */
    @ApiOperation(value = "资金来源新增", notes = "新增资金来源", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A09")
    public JSONResult A09(@Valid @RequestBody XM0203A09InputDTO input) throws Exception {
        JSONResult jsonResult = new JSONResult();
        if (input.getMoney() == null || input.getMoney() <= 0 || input.getSource() == "") {
            throw new Exception("");
        }
        int mark = xm0203Service.addSource(input);
        if (mark > 0) {
            jsonResult.setMessage("新增来源成功");
            return jsonResult;
        } else {
            jsonResult.setMessage("新增来源失败");
            return jsonResult;
        }
    }

    /**
     * A10: 资金来源编辑（编辑资金来源）
     */
    @ApiOperation(value = "资金来源编辑", notes = "编辑资金来源", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A10")
    public JSONResult A10(@RequestBody XM0203A10InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        double [] array=new double[2];
        array = xm0203Service.getRemainMoney(input.getOrganizationId(), input.getProjectId());
        jsonResult.setData(array);
        return jsonResult;
    }

    /**
     * A11: 资金来源删除（资金来源删除）
     */
    @ApiOperation(value = "资金来源删除", notes = "资金来源删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A11")
    public JSONResult A11(@Valid @RequestBody XM0203A11InputDTO input) {
        JSONResult jsonResult = new JSONResult();

        // TODO 业务逻辑: A11: 资金来源删除（资金来源删除）
        jsonResult.setMessage("接口未实现"); // 实现后删除本行

        return jsonResult;
    }

    /**
     * A12: 资金下达组织获取（下达组织获取）
     */
    @ApiOperation(value = "资金下达组织获取", notes = "下达组织获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A12")
    public JSONResult A12( XM0203A12InputDTO input) {
        JSONResult<List<XM0203A12DTO>> jsonResult = new JSONResult<>();
        List<XM0203A12DTO> xm0203A12DTOList = new ArrayList<>();
        xm0203A12DTOList = xm0203Service.getAllOrganization(input.getOrganizationId());
        if (xm0203A12DTOList.size() >= 0) {
            jsonResult.setData(xm0203A12DTOList);
            return jsonResult;
        } else {
            jsonResult.setMessage("获取列表失败");
            return jsonResult;
        }
    }

    /**
     * A13: 资金下达编辑提交（编辑资金下达后提交）
     */
    @ApiOperation(value = "资金下达编辑提交", notes = "编辑资金下达后提交", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A13")
    public JSONResult A13(@RequestBody XM0203A13InputDTO input) throws Exception {
        JSONResult jsonResult = new JSONResult();
        try {
            int mark = xm0203Service.changeDownDetail(input);
        } catch (Exception e) {

            throw new Exception("修改失败");
        }
        return jsonResult;
    }

    /**
     * A14: 文件列表获取（根据资金资金下达ID查看文件列表）
     */
    @ApiOperation(value = "文件列表获取", notes = "根据资金资金下达ID查看文件列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A14")
    public JSONResult A14(@Valid XM0203A14InputDTO input) {
        JSONResult<List<XM0203A14DTO>> jsonResult = new JSONResult<>();
        List<XmProjectFile> xmProjectFileList = xm0203Service.getFileList(input.getFundingId());
        List<XM0203A14DTO> xm0203A14DTOList = BeanMapper.mapList(xmProjectFileList, XM0203A14DTO.class);

        jsonResult.setData(xm0203A14DTOList);
        return jsonResult;
    }

    /**
     * A15: 区县下达筛选树获取（获取区县列表）
     */
    @ApiOperation(value = "区县下达筛选树获取", notes = "获取区县列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A15")
    public JSONResult A15(@Valid XM0203A15InputDTO input) {
        JSONResult<List<XM0203A15DTO>> jsonResult = new JSONResult<>();
        List<XM0203A15DTO> xm0203A15DTOList = new ArrayList<>();

        // TODO 业务逻辑: A15: 区县下达筛选树获取（获取区县列表）
        jsonResult.setMessage("接口未实现"); // 实现后删除本行

        jsonResult.setData(xm0203A15DTOList);
        return jsonResult;
    }

    /**
     * A16: 区县下达资金详情（区县下达资金详情）
     */
    @ApiOperation(value = "区县下达资金详情", notes = "区县下达资金详情", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A16")
    public JSONResult A16(@Valid XM0203A16InputDTO input) {
        JSONResult<List<XM0203A16DTO>> jsonResult = new JSONResult<>();
        List<XM0203A16DTO> xm0203A16DTOList = new ArrayList<>();
        xm0203A16DTOList = xm0203Service.getSchoolDeatail(input);
        if (xm0203A16DTOList.size() >= 0) {
            List<XM0203A16DTO> returnedMh0105A01DTOList = new ArrayList<>();
            int page = input.getPageNum();
            int pageSize = input.getPageSize();
            int totalCount = xm0203A16DTOList.size();
            for (int i = (page - 1) * (pageSize); i < xm0203A16DTOList.size() && i < page * pageSize; i++) {
                returnedMh0105A01DTOList.add(xm0203A16DTOList.get(i));
            }
            jsonResult.setTotalCount(totalCount);
            jsonResult.setData(returnedMh0105A01DTOList);
            return jsonResult;
        } else {
            jsonResult.setMessage("获取列表失败");
            return jsonResult;
        }
    }

    /**
     * A17: 文件编辑（修改文件部分内容）
     */
    @ApiOperation(value = "文件编辑", notes = "修改文件部分内容", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A17")
    public JSONResult A17(@Valid @RequestBody XM0203A17InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        Byte status;
        XmProjectFile xmProjectFile = new XmProjectFile();
        xmProjectFile.setId(input.getFileId());
        xmProjectFile.setSource(input.getSource());
        if (input.getStatus()) {
            status = 1;
        } else {
            status = 0;
        }
        xmProjectFile.setStatus(status);

        xm0203Service.changeFileById(xmProjectFile);
        // TODO 业务逻辑: A17: 文件编辑（修改文件部分内容）

        return jsonResult;
    }
}
