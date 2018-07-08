package org.ec.xm.api.controller;

import io.swagger.annotations.*;
import org.ec.utils.BeanMapper;
import org.ec.xm.dto.XM0206.XM0206A01DTO;
import org.ec.xm.entity.XmTask;
import org.ec.xm.service.XM0206Service;
import org.ec.utils.JSONResult;
import org.ec.xm.dto.XM0206.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import javax.validation.Valid;

/**
 * XM0206: 项目执行 - 任务管理(学校)（任务管理(学校)页面）
 * 作者：
 * 日期：
 */
@RestController
@CrossOrigin
@Api("XM0206: 项目执行 - 任务管理(学校)（任务管理(学校)页面）")
@RequestMapping("/XM0206")
public class XM0206Controller extends BaseController {

    /**
     * XM0206Service
     */
    private final XM0206Service xm0206Service;

    @Autowired
    public XM0206Controller(XM0206Service xm0206Service) {
        this.xm0206Service = xm0206Service;
    }

    /**
     * A01: 任务列表获取(学校)（获取任务列表）
     */
    @ApiOperation(value = "任务列表获取(学校)", notes = "获取任务列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01(@Valid XM0206A01InputDTO input) {
        JSONResult<List<XM0206A01DTO>> jsonResult = new JSONResult<>();
        List<XM0206A01DTO> xm0206A01DTOList = xm0206Service.getAllSchoolTask(input.getOrganizationId());
        List<XM0206A01DTO> xm0206A01DTOListSelected = new ArrayList<>();
        if (xm0206A01DTOList.size() > 0) {
            int page = input.getPageNum();
            int pageSize = input.getPageSize();
            for (int i = (page - 1) * pageSize; i < xm0206A01DTOList.size() && i < page * pageSize; i++) {
                double money = 0;
                try {
                    money = xm0206Service.getTaskMoney(xm0206A01DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch(Exception ex) {
                }
                xm0206A01DTOList.get(i).setMoney(money);
                xm0206A01DTOListSelected.add(xm0206A01DTOList.get(i));
            }
        }
        jsonResult.setData(xm0206A01DTOListSelected);
        jsonResult.setTotalCount(xm0206A01DTOList.size());
        return jsonResult;
    }

    /**
     * A02: 任务查询获取(学校)（获取任务列表）
     */
    @ApiOperation(value = "任务查询获取(学校)", notes = "获取任务列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A02")
    public JSONResult A02(@Valid XM0206A02InputDTO input) {
        JSONResult<List<XM0206A02DTO>> jsonResult = new JSONResult<>();
        List<XM0206A02DTO> xm0206A02DTOList = xm0206Service.getSchoolSearchTask(input.getOrganizationId(), input.getKeyWord());
        List<XM0206A02DTO> xm0206A02DTOListSelected = new ArrayList<>();
        if (xm0206A02DTOList.size() > 0) {
            int page = input.getPageNum();
            int pageSize = input.getPageSize();
            for (int i = (page - 1) * pageSize; i < xm0206A02DTOList.size() && i < page * pageSize; i++) {
                double money = 0;
                try {
                    money = xm0206Service.getTaskMoney(xm0206A02DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch (Exception ex) {
                }
                xm0206A02DTOList.get(i).setMoney(money);
                xm0206A02DTOListSelected.add(xm0206A02DTOList.get(i));
            }
        }
        jsonResult.setData(xm0206A02DTOListSelected);
        jsonResult.setTotalCount(xm0206A02DTOList.size());
        return jsonResult;
    }

    /**
     * A03: 文件资料获取(学校)（获取任务列表）
     */
    @ApiOperation(value = "文件资料获取(学校)", notes = "获取任务列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A03")
    public JSONResult A03(@Valid XM0206A03InputDTO input) {
        JSONResult<List<XM0206A03DTO>> jsonResult = new JSONResult<>();
        List<XM0206A03DTO> xm0208A06DTOList = xm0206Service.getSchoolFile(input.getTaskId(), input.getGeOrganizationId());

        // TODO 业务逻辑: A06: 文件资料获取(区县)（文件资料获取）

        jsonResult.setData(xm0208A06DTOList);
        return jsonResult;
    }

    /**
     * A04: 上级文件获取(学校)（上级文件获取）
     */
    @ApiOperation(value = "上级文件获取(学校)", notes = "上级文件获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A04")
    public JSONResult A04(@Valid XM0206A04InputDTO input) {
        JSONResult<List<XM0206A04DTO>> jsonResult = new JSONResult<>();
        List<XM0206A04DTO> fundingFiles = xm0206Service.getSchoolFundingFile(input.getTaskId());
        List<XM0206A04DTO> xm0206A04DTOList = xm0206Service.getSchoolSuperiorFile(xm0206Service.getSuperiorTaskId(input.getTaskId()), xm0206Service.getUpOrganizationId(input.getTaskId()));
        for (int i = 0; i < fundingFiles.size(); i++)
            xm0206A04DTOList.add(fundingFiles.get(i));

        jsonResult.setData(xm0206A04DTOList);
        return jsonResult;
    }

    /**
     * A05: 任务筛选树获取(学校)（获取任务筛选树）
     */
    @ApiOperation(value = "任务筛选树获取(学校)", notes = "获取任务筛选树", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JSONResult A05(@Valid XM0206A05InputDTO input) {
        JSONResult<List<XM0206A05DTO>> jsonResult = new JSONResult<>();
        List<XM0206A05DTO> xm0206A05DTOList = xm0206Service.getSchoolSelectTree(input.getOrganizationId());
        jsonResult.setData(xm0206A05DTOList);
        return jsonResult;
    }

    /**
     * A06: 项目任务获取(学校)（获取任务列表）
     */
    @ApiOperation(value = "项目任务获取(学校)", notes = "获取任务列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A06")
    public JSONResult A06(@Valid XM0206A06InputDTO input) {
        JSONResult<List<XM0206A06DTO>> jsonResult = new JSONResult<>();
        List<XM0206A06DTO> xm0206A06DTOList = xm0206Service.getSchoolProjectTask(input.getOrganizationId(), input.getProjectId());
        List<XM0206A06DTO> xm0206A06DTOListSelected = new ArrayList<>();
        if (xm0206A06DTOList.size() > 0) {
            int page = input.getPageNum();
            int pageSize = input.getPageSize();
            for (int i = (page - 1) * pageSize; i < xm0206A06DTOList.size() && i < page * pageSize; i++) {
                double money = 0;
                try {
                    money = xm0206Service.getTaskMoney(xm0206A06DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch (Exception ex) {

                }
                xm0206A06DTOList.get(i).setMoney(money);
                xm0206A06DTOListSelected.add(xm0206A06DTOList.get(i));
            }
        }
        jsonResult.setData(xm0206A06DTOListSelected);
        jsonResult.setTotalCount(xm0206A06DTOList.size());
        return jsonResult;
    }

    /**
     * A07: 年份任务获取（通过年份获取任务列表）
     */
    @ApiOperation(value = "年份任务获取", notes = "通过年份获取任务列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A07")
    public JSONResult A07(@Valid XM0206A07InputDTO input) {
        JSONResult<List<XM0206A07DTO>> jsonResult = new JSONResult<>();
        List<XM0206A07DTO> xm0206A07DTOList = xm0206Service.getSchoolYearTask(input.getOrganizationId(), input.getYear());
        List<XM0206A07DTO> xm0206A07DTOListSelected = new ArrayList<>();
        if (xm0206A07DTOList.size() > 0) {
            int page = input.getPageNum();
            int pageSize = input.getPageSize();
            for (int i = (page - 1) * pageSize; i < xm0206A07DTOList.size() && i < page * pageSize; i++) {
                double money = 0;
                try {
                    money = xm0206Service.getTaskMoney(xm0206A07DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch(Exception ex) {
                }
                xm0206A07DTOList.get(i).setMoney(money);
                xm0206A07DTOListSelected.add(xm0206A07DTOList.get(i));
            }
        }
        jsonResult.setData(xm0206A07DTOListSelected);
        jsonResult.setTotalCount(xm0206A07DTOList.size());
        return jsonResult;
    }

    /**
     * A08: 退回或催报任务获取(学校)（-）
     */
    @ApiOperation(value = "退回或催报任务获取(学校)", notes = "-", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A08")
    public JSONResult A08(@Valid XM0206A08InputDTO input) {
        JSONResult<List<XM0206A08DTO>> jsonResult = new JSONResult<>();
        List<XM0206A08DTO> xm0206A08DTOList = new ArrayList<>();
        if(input.getType().equals("return"))
            xm0206A08DTOList = xm0206Service.getSchoolReturnTasks(input.getOrganizationId());
        if(input.getType().equals("urge"))
            xm0206A08DTOList = xm0206Service.getSchoolUrgedTasks(input.getOrganizationId());
        List<XM0206A08DTO> xm0206A08DTOListSelected = new ArrayList<>();
        if (xm0206A08DTOList.size() > 0) {
            int page = input.getPageNum();
            int pageSize = input.getPageSize();
            for (int i = (page - 1) * pageSize; i < xm0206A08DTOList.size() && i < page * pageSize; i++) {
                double money = 0;
                try {
                    money = xm0206Service.getTaskMoney(xm0206A08DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch(Exception ex) {
                }
                xm0206A08DTOList.get(i).setMoney(money);
                xm0206A08DTOListSelected.add(xm0206A08DTOList.get(i));
            }
        }
        jsonResult.setData(xm0206A08DTOListSelected);
        jsonResult.setTotalCount(xm0206A08DTOList.size());
        return jsonResult;
    }
}
