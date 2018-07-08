package org.ec.xm.api.controller;

import io.swagger.annotations.*;
import org.ec.xm.service.XM0202Service;
import org.ec.utils.JSONResult;
import org.ec.xm.dto.XM0202.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import javax.validation.Valid;

/**
 * XM0202: 项目执行 - 项目管理（项目管理页面）
 * 作者：
 * 日期：
 */
@RestController
@CrossOrigin
@Api("XM0202: 项目执行 - 项目管理（项目管理页面）")
@RequestMapping("/XM0202")
public class XM0202Controller extends BaseController {

    /**
     * XM0202Service
     */
    private final XM0202Service xm0202Service;

    @Autowired
    public XM0202Controller(XM0202Service xm0202Service) {
        this.xm0202Service = xm0202Service;
    }

    /**
     * A01: 项目数据获取+查询框（查询项目列表，包含分页和查询）
     */
    @ApiOperation(value = "项目数据获取+查询框", notes = "查询项目列表，包含分页和查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01( XM0202A01InputDTO input) {
        JSONResult<XM0202A01DTO> jsonResult = new JSONResult<>();
        XM0202A01DTO xm0202A01DTO = new XM0202A01DTO();
         List<XM0202A01S01DTO> xm0202A01DTOList=  xm0202Service.getListById(input.getKeyWord(),input.getOrganizationId());
        if(xm0202A01DTOList.size()>=0){
            List<XM0202A01S01DTO> returnedMh0105A01DTOList = new ArrayList<>();
            int page=input.getPage();
            int pageSize=input.getPageSize();
            int totalCount=xm0202A01DTOList.size();
            for(int i = (page-1)*(pageSize) ; i<xm0202A01DTOList.size()&& i<page*pageSize;i++){
                String[] s=new String[]{};
                if(xm0202A01DTOList.get(i).getSource()!=null&&xm0202A01DTOList.get(i).getSource()!="") {
                   s = xm0202A01DTOList.get(i).getSource().split(" ");
                }
                xm0202A01DTOList.get(i).setSourceArray(s);
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
     * A02: 筛选树（项目管理筛选数据获取）
     */
    @ApiOperation(value = "筛选树", notes = "项目管理筛选数据获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A02")
    public JSONResult A02(@Valid XM0202A02InputDTO input) {
        JSONResult<List<XM0202A02DTO>> jsonResult = new JSONResult<>();
        List<XM0202A02DTO>  xm0202A02DTOList=  xm0202Service.getAllYears(input.getOrganizationId());
        jsonResult.setData(xm0202A02DTOList);
        return jsonResult;
    }

    /**
     * A03: 新增项目（项目新增）
     */
    @ApiOperation(value = "新增项目", notes = "项目新增", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JSONResult A03(@Valid @RequestBody XM0202A03InputDTO input) throws Exception {
        JSONResult jsonResult = new JSONResult();
        int  insert=0;
            String s="";
        if(input.getSourceArray()!=null)
             for(int i=0;i<input.getSourceArray().length;i++){
                    s=s+input.getSourceArray()[i]+" ";
             }
             input.setSource(s);
            insert = xm0202Service.addProject(input);
         if(insert>0){
             jsonResult.setMessage("新增成功");
             return jsonResult;
         }
       else {
              throw new Exception("新增失败");
         }

    }

    /**
     * A04: 资金下达表（获取区县资金下达详情）
     */
    @ApiOperation(value = "资金下达表", notes = "获取区县资金下达详情", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A04")
    public JSONResult A04(@Valid XM0202A04InputDTO input) {
        JSONResult<List<XM0202A04DTO>> jsonResult = new JSONResult<>();
        List<XM0202A04DTO> xm0202A04DTOList = new ArrayList<>();
       xm0202A04DTOList=xm0202Service.getDownDetail(input);
        jsonResult.setData(xm0202A04DTOList);
        return jsonResult;
    }

    /**
     * A05: 查看文件（查看文件）
     */
    @ApiOperation(value = "查看文件", notes = "查看文件", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JSONResult A05( XM0202A05InputDTO input) {
        JSONResult<List<XM0202A05DTO>> jsonResult = new JSONResult<>();
        List<XM0202A05DTO> xm0202A05DTOList = new ArrayList<>();
        xm0202A05DTOList=xm0202Service.getFileList(input);
        jsonResult.setData(xm0202A05DTOList);
        return jsonResult;
    }

    /**
     * A06: 项目编辑提交（项目编辑提交）
     */
    @ApiOperation(value = "项目编辑提交", notes = "项目编辑提交", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A06")
    public JSONResult A06( @RequestBody XM0202A06InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        String s="";
        if(input.getSourceArray()!=null)
        for(int i=0;i<input.getSourceArray().length;i++){
            s=s+input.getSourceArray()[i]+" ";
        }
        input.setSource(s);
        int mark=  xm0202Service.updateProjectById(input);
        return jsonResult;
    }

    /**
     * A07: 项目删除（根据ID删除项目）
     */
    @ApiOperation(value = "项目删除", notes = "根据ID删除项目", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A07")
    public JSONResult A07(@Valid @RequestBody XM0202A07InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        xm0202Service.deleteProject(input.getProjectId());
        jsonResult.setMessage("删除成功"); // 实现后删除本行
        return jsonResult;
    }

    /**
     * A08: 项目确认（项目状态改为确认）
     */
    @ApiOperation(value = "项目确认", notes = "项目状态改为确认", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A08")
    public JSONResult A08(@Valid @RequestBody XM0202A08InputDTO input) {
        JSONResult jsonResult = new JSONResult();
         xm0202Service.sureProject(input.getProjectId());
         jsonResult.setMessage("确认成功");
        return jsonResult;
    }
}
