package org.ec.xm.api.controller;

import io.swagger.annotations.*;
import org.ec.xm.dto.XM0203.XM0203A08DTO;
import org.ec.xm.service.XM0210Service;
import org.ec.utils.JSONResult;
import org.ec.xm.dto.XM0210.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import javax.validation.Valid;

/**
 * XM0210: 项目执行 - 资金管理(区县)（上级资金下达页面）
 * 作者：
 * 日期：
 */
@RestController
@CrossOrigin
@Api("XM0210: 项目执行 - 资金管理(区县)（上级资金下达页面）")
@RequestMapping("/XM0210")
public class XM0210Controller extends BaseController {

    /**
     * XM0210Service
     */
    private final XM0210Service xm0210Service;

    @Autowired
    public XM0210Controller(XM0210Service xm0210Service) {
        this.xm0210Service = xm0210Service;
    }

    /**
     * A01: 项目数据获取+查询框(区县)（查询项目列表，包含分页和查询）
     */
    @ApiOperation(value = "项目数据获取+查询框(区县)", notes = "查询项目列表，包含分页和查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01(XM0210A01InputDTO input) {
        JSONResult<XM0210A01DTO> jsonResult = new JSONResult<>();
        XM0210A01DTO xm0202A01DTO = new XM0210A01DTO();
        List<XM0210A01S01DTO> xm0202A01DTOList=  xm0210Service.getListById(input.getKeyWord(),input.getOrganizationId());
        if(xm0202A01DTOList.size()>=0){
            List<XM0210A01S01DTO> returnedMh0105A01DTOList = new ArrayList<>();
            int page=input.getPage();
            int pageSize=input.getPageSize();
            int totalCount=xm0202A01DTOList.size();
            for(int i = (page-1)*(pageSize) ; i<xm0202A01DTOList.size()&& i<page*pageSize;i++){
                returnedMh0105A01DTOList.add(xm0202A01DTOList.get(i));
            }
            xm0202A01DTO.setProject(returnedMh0105A01DTOList);
            jsonResult.setTotalCount(totalCount);
            jsonResult.setData(xm0202A01DTO);
            return jsonResult;
        }
        else{
            jsonResult.setMessage("获取列表失败");
            return jsonResult;
        }
    }

    /**
     * A02: 筛选树获取列表(区县)（通过筛选树获取列表）
     */
    @ApiOperation(value = "筛选树获取列表(区县)", notes = "通过筛选树获取列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A02")
    public JSONResult A02(@Valid XM0210A02InputDTO input) {
        JSONResult<List<XM0210A13DTO>> jsonResult = new JSONResult<>();
        List<XM0210A13DTO>  xm0202A02DTOList=  xm0210Service.getAllYearsByOrganization(input.getOrganizationId());
        jsonResult.setData(xm0202A02DTOList);
        return jsonResult;
    }

    /**
     * A03: 查看文件(区县)（区县查看文件）
     */
    @ApiOperation(value = "查看文件(区县)", notes = "区县查看文件", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A03")
    public JSONResult A03(@Valid XM0210A03InputDTO input) {
        JSONResult<List<XM0210A03DTO>> jsonResult = new JSONResult<>();
        List<XM0210A03DTO> xm0210A03DTOList = new ArrayList<>();

        // TODO 业务逻辑: A03: 查看文件(区县)（区县查看文件）
        jsonResult.setMessage("接口未实现"); // 实现后删除本行

        jsonResult.setData(xm0210A03DTOList);
        return jsonResult;
    }

    /**
     * A04: 资金信息获取（获取区县资金来源的信息）
     */
    @ApiOperation(value = "资金信息获取", notes = "获取区县资金来源的信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A04")
    public JSONResult A04(@Valid XM0210A04InputDTO input) {
        JSONResult<XM0210A04DTO> jsonResult = new JSONResult<>();
        XM0210A04DTO xm0210A04DTO  = new XM0210A04DTO();
        xm0210A04DTO=xm0210Service.getAllSource(input);
        jsonResult.setData(xm0210A04DTO);
        return jsonResult;
    }

    /**
     * A05: 资金来源新增（区县资金来源新增）
     */
    @ApiOperation(value = "资金来源新增", notes = "区县资金来源新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A05")
    public JSONResult A05(@Valid @RequestBody XM0210A05InputDTO input) throws Exception {
        JSONResult jsonResult = new JSONResult();
    if(input.getMoney()==null||input.getMoney()<=0||input.getSource()==""){
        throw new Exception("");
    }
        int mark1 = xm0210Service.addSource(input);
        if(mark1>=0) {
            jsonResult.setMessage("新增来源成功");
              return jsonResult;
        }
        else{
            jsonResult.setMessage("新增来源失败");
            return jsonResult;
        }
    }

    /**
     * A06: 资金来源编辑（区县编辑资金来源）
     */
    @ApiOperation(value = "资金来源编辑", notes = "区县编辑资金来源", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A06")
    public JSONResult A06(@Valid @RequestBody XM0210A06InputDTO input) {
        JSONResult jsonResult = new JSONResult();

        // TODO 业务逻辑: A06: 资金来源编辑（区县编辑资金来源）
        jsonResult.setMessage("接口未实现"); // 实现后删除本行

        return jsonResult;
    }

    /**
     * A07: 资金来源删除（区县资金来源删除）
     */
    @ApiOperation(value = "资金来源删除", notes = "区县资金来源删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A07")
    public JSONResult A07(@Valid @RequestBody XM0210A07InputDTO input) {
        JSONResult jsonResult = new JSONResult();

        // TODO 业务逻辑: A07: 资金来源删除（区县资金来源删除）
        jsonResult.setMessage("接口未实现"); // 实现后删除本行

        return jsonResult;
    }

    /**
     * A08: 资金分配(区县)（项目资金分配）
     */
    @ApiOperation(value = "资金分配(区县)", notes = "项目资金分配", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A08")
    public JSONResult A08(@Valid @RequestBody XM0210A08InputDTO input) {
        JSONResult jsonResult = new JSONResult();

        // TODO 业务逻辑: A08: 资金分配(区县)（项目资金分配）
        jsonResult.setMessage("接口未实现"); // 实现后删除本行

        return jsonResult;
    }

    /**
     * A09: 文件上传(区县)（区县文件上传）
     */
    @ApiOperation(value = "文件上传(区县)", notes = "区县文件上传", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A09")
    public JSONResult A09(@Valid @RequestBody XM0210A09InputDTO input) {
        JSONResult<XM0210A09DTO> jsonResult = new JSONResult<>();
        XM0210A09DTO xm0210A09DTO = new XM0210A09DTO();

        // TODO 业务逻辑: A09: 文件上传(区县)（区县文件上传）
        jsonResult.setMessage("接口未实现"); // 实现后删除本行

        jsonResult.setData(xm0210A09DTO);
        return jsonResult;
    }

    /**
     * A10: 文件删除(区县)（区县文件删除）
     */
    @ApiOperation(value = "文件删除(区县)", notes = "区县文件删除", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A10")
    public JSONResult A10(@Valid @RequestBody XM0210A10InputDTO input) {
        JSONResult jsonResult = new JSONResult();

        // TODO 业务逻辑: A10: 文件删除(区县)（区县文件删除）
        jsonResult.setMessage("接口未实现"); // 实现后删除本行

        return jsonResult;
    }

    /**
     * A11: 资金下达展示(区县)（区县资金下达展示）
     */
    @ApiOperation(value = "资金下达展示(区县)", notes = "区县资金下达展示", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A11")
    public JSONResult A11( XM0210A11InputDTO input) {
        JSONResult<List<XM0210A11DTO>> jsonResult = new JSONResult<>();
        List<XM0210A11DTO> xm0210A11DTOList = new ArrayList<>();
         xm0210A11DTOList=xm0210Service.getDownTableData(input);

        if(xm0210A11DTOList.size()>=0){
            List<XM0210A11DTO> returnedMh0105A01DTOList = new ArrayList<>();
            int page=input.getPage();
            int pageSize=input.getPageSize();
            int totalCount=xm0210A11DTOList.size();
            for(int i = (page-1)*(pageSize) ; i<xm0210A11DTOList.size()&& i<page*pageSize;i++){
                returnedMh0105A01DTOList.add(xm0210A11DTOList.get(i));
            }
            jsonResult.setTotalCount(totalCount);
            jsonResult.setData(returnedMh0105A01DTOList);
            return jsonResult;
        }
        else{
            jsonResult.setMessage("获取列表失败");
            return jsonResult;
        }
    }

    /**
     * A12: 资金下达详情(区县)（获取学校资金下达详情）
     */
    @ApiOperation(value = "资金下达详情(区县)", notes = "获取学校资金下达详情", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A12")
    public JSONResult A12(@Valid XM0210A12InputDTO input) {
        JSONResult<List<XM0210A12DTO>> jsonResult = new JSONResult<>();
        List<XM0210A12DTO> xm0210A12DTOList = new ArrayList<>();

        // TODO 业务逻辑: A12: 资金下达详情(区县)（获取学校资金下达详情）
        jsonResult.setMessage("接口未实现"); // 实现后删除本行

        jsonResult.setData(xm0210A12DTOList);
        return jsonResult;
    }

    /**
     * A13: 资金下达筛选树(区县)（区县资金管理筛选树）
     */
    @ApiOperation(value = "资金下达筛选树(区县)", notes = "区县资金管理筛选树", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A13")
    public JSONResult A13(@Valid XM0210A13InputDTO input) {
        JSONResult<List<XM0210A13DTO>> jsonResult = new JSONResult<>();
        List<XM0210A13DTO>  xm0202A02DTOList=  xm0210Service.getAllYears(input.getOrganizationId());
        jsonResult.setData(xm0202A02DTOList);
        return jsonResult;
    }

    /**
     * A14: 资金下达组织获取(区县)（下达组织获取）
     */
    @ApiOperation(value = "资金下达组织获取(区县)", notes = "下达组织获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A14")
    public JSONResult A14(@Valid XM0210A14InputDTO input) {
        JSONResult<List<XM0210A14DTO>> jsonResult = new JSONResult<>();
        List<XM0210A14DTO> xm0210A14DTOList = new ArrayList<>();

        // TODO 业务逻辑: A14: 资金下达组织获取(区县)（下达组织获取）
        jsonResult.setMessage("接口未实现"); // 实现后删除本行

        jsonResult.setData(xm0210A14DTOList);
        return jsonResult;
    }

    /**
     * A15: 资金下达编辑提交(区县)（编辑资金下达后提交）
     */
    @ApiOperation(value = "资金下达编辑提交(区县)", notes = "编辑资金下达后提交", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A15")
    public JSONResult A15(@Valid @RequestBody XM0210A15InputDTO input) {
        JSONResult jsonResult = new JSONResult();

        // TODO 业务逻辑: A15: 资金下达编辑提交(区县)（编辑资金下达后提交）
        jsonResult.setMessage("接口未实现"); // 实现后删除本行

        return jsonResult;
    }

    /**
     * A16: 资金下达项目获取（根据组织id获取项目）
     */
    @ApiOperation(value = "资金下达项目获取", notes = "根据组织id获取项目", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A16")
    public JSONResult A16(@Valid XM0210A16InputDTO input) {
        JSONResult<List<XM0210A16DTO>> jsonResult = new JSONResult<>();
        List<XM0210A16DTO> xm0210A16DTOList = new ArrayList<>();
        xm0210A16DTOList=    xm0210Service.getAllProjects(input);
        jsonResult.setData(xm0210A16DTOList);
        return jsonResult;
    }

    /**
     * A17: 上级下达资金筛选树（上级下达资金筛选树）
     */
    @ApiOperation(value = "上级下达资金筛选树", notes = "上级下达资金筛选树", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A17")
    public JSONResult A17(@Valid XM0210A17InputDTO input) {
        JSONResult<List<XM0210A17DTO>> jsonResult = new JSONResult<>();
        List<XM0210A17DTO> xm0210A17DTOList = new ArrayList<>();

        // TODO 业务逻辑: A17: 上级下达资金筛选树（上级下达资金筛选树）
        jsonResult.setMessage("接口未实现"); // 实现后删除本行

        jsonResult.setData(xm0210A17DTOList);
        return jsonResult;
    }

    /**
     * A18: 资金下达文件列表获取（文件列表获取）
     */
    @ApiOperation(value = "资金下达文件列表获取", notes = "文件列表获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A18")
    public JSONResult A18(@Valid XM0210A18InputDTO input) {
        JSONResult<List<XM0210A18DTO>> jsonResult = new JSONResult<>();
        List<XM0210A18DTO> xm0210A18DTOList = new ArrayList<>();
        xm0210A18DTOList = xm0210Service.getAllFileList(input);
        jsonResult.setData(xm0210A18DTOList);
        return jsonResult;
    }
}
