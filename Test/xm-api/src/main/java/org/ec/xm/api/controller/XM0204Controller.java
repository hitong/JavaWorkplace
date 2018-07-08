package org.ec.xm.api.controller;

import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.ec.utils.BeanMapper;
import org.ec.xm.entity.XmTask;
import org.ec.xm.service.XM0204Service;
import org.ec.utils.JSONResult;
import org.ec.xm.dto.XM0204.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import javax.validation.Valid;

/**
 * XM0204: 项目执行 - 任务管理（任务管理页面）
 * 作者：
 * 日期：
 */
@RestController
@CrossOrigin
@Api("XM0204: 项目执行 - 任务管理（任务管理页面）")
@RequestMapping("/XM0204")
public class XM0204Controller extends BaseController {

    /**
     * XM0204Service
     */
    private final XM0204Service xm0204Service;

    @Autowired
    public XM0204Controller(XM0204Service xm0204Service) {
        this.xm0204Service = xm0204Service;
    }

    /**
     * A01: 任务列表获取（获取任务列表）
     */
    @ApiOperation(value = "任务列表获取", notes = "获取任务列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01(@Valid XM0204A01InputDTO input) {
        JSONResult<List<XM0204A01DTO>> jsonResult = new JSONResult<>();
        List<XM0204A01DTO> xm0204A01DTOList = xm0204Service.getAllCityTask(input.getOrganizationId());

        List<XM0204A01DTO> xm0204A01DTOListSelected = new ArrayList<>();
        if (xm0204A01DTOList.size() > 0) {
            int page = input.getPageNum();
            int pageSize = input.getPageSize();
            for (int i = (page - 1) * pageSize; i < xm0204A01DTOList.size() && i < page * pageSize; i++) {
                double money = 0;
                try {
                    money = xm0204Service.getProjectMoney(xm0204A01DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch (Exception ex) {
                }
                xm0204A01DTOList.get(i).setMoney(money);
                xm0204A01DTOListSelected.add(xm0204A01DTOList.get(i));
            }
        }
        jsonResult.setData(xm0204A01DTOListSelected);
        jsonResult.setTotalCount(xm0204A01DTOList.size());
        return jsonResult;
    }

    /**
     * A02: 任务新增提交（任务新增提交）
     */
    @ApiOperation(value = "任务新增提交", notes = "任务新增提交", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JSONResult A02(@Valid @RequestBody XM0204A02InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        XmTask xmTask = new XmTask();
        xmTask.setProjectId(input.getProjectId());
        xmTask.setName(input.getName());
        xmTask.setType(input.getType());
        xmTask.setDataTemplateId(input.getDataTemplateId());
        xmTask.setBeginAt(input.getBeginAt());
        xmTask.setOrganizationId(input.getCreatedOrganizationId());
        xmTask.setFinishAt(input.getFinishAt());
        xmTask.setTaskMode("临时任务");
        xmTask.setEnable(false);
        xmTask.setStatus("待下发");
        xmTask.setRemark(input.getRemark());

        xm0204Service.insert(xmTask);
        return jsonResult;
    }

    /**
     * A03: 任务删除（删除任务）
     */
    @ApiOperation(value = "任务删除", notes = "删除任务", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A03")
    public JSONResult A03(@Valid @RequestBody XM0204A03InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        xm0204Service.deleteByPrimaryKey(input.getTaskId());
        return jsonResult;
    }

    /**
     * A04: 任务编辑提交（任务编辑提交）
     */
    @ApiOperation(value = "任务编辑提交", notes = "任务编辑提交", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A04")
    public JSONResult A04(@Valid @RequestBody XM0204A04InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        XmTask xmTask = new XmTask();
        xmTask.setId(input.getTaskId());
        xmTask.setName(input.getName());
        xmTask.setType(input.getType());
        xmTask.setProjectId(input.getProjectId());
        xmTask.setDataTemplateId(input.getDataTemplateId());
        xmTask.setBeginAt(input.getBeginAt());
        xmTask.setFinishAt(input.getFinishAt());
        xmTask.setRemark(input.getRemark());
        xm0204Service.editTask(xmTask);

        return jsonResult;
    }

    /**
     * A05: 任务查询获取（获取任务列表）
     */
    @ApiOperation(value = "任务查询获取", notes = "获取任务列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JSONResult A05(@Valid XM0204A05InputDTO input) {
        JSONResult<List<XM0204A05DTO>> jsonResult = new JSONResult<>();
        List<XM0204A05DTO> xm0204A05DTOList = xm0204Service.getCitySearchTask(input.getOrganizationId(), input.getKeyWord());
        List<XM0204A05DTO> xm0204A05DTOListSelected = new ArrayList<>();
        if (xm0204A05DTOList.size() > 0) {
            int page = input.getPageNum();
            int pageSize = input.getPageSize();
            for (int i = (page - 1) * pageSize; i < xm0204A05DTOList.size() && i < page * pageSize; i++) {
                double money = 0;
                try {
                    money = xm0204Service.getProjectMoney(xm0204A05DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch (Exception ex) {
                }
                xm0204A05DTOList.get(i).setMoney(money);
                xm0204A05DTOListSelected.add(xm0204A05DTOList.get(i));
            }
        }
        jsonResult.setData(xm0204A05DTOListSelected);
        jsonResult.setTotalCount(xm0204A05DTOList.size());
        return jsonResult;
    }

    /**
     * A06: 任务筛选树获取（获取项目筛选树）
     */
    @ApiOperation(value = "任务筛选树获取", notes = "获取项目筛选树", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A06")
    public JSONResult A06(@Valid XM0204A06InputDTO input) {
        JSONResult<List<XM0204A06DTO>> jsonResult = new JSONResult<>();
        List<XM0204A06DTO> xm0204A06DTOList = xm0204Service.getCitySelectTree(input.getOrganizationId());
        jsonResult.setData(xm0204A06DTOList);
        return jsonResult;
    }

    /**
     * A07: 项目任务获取（获取任务列表）
     */
    @ApiOperation(value = "项目任务获取", notes = "获取任务列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A07")
    public JSONResult A07(@Valid XM0204A07InputDTO input) {
        JSONResult<List<XM0204A07DTO>> jsonResult = new JSONResult<>();
        List<XM0204A07DTO> xm0204A07DTOList = xm0204Service.getCityProjectTask(input.getOrganizationId(), input.getProjectId(),input.getKeyWord());
        List<XM0204A07DTO> xm0204A07DTOListSelected = new ArrayList<>();

        if (xm0204A07DTOList.size() > 0) {
            int page = input.getPageNum();
            int pageSize = input.getPageSize();
            for (int i = (page - 1) * pageSize; i < xm0204A07DTOList.size() && i < page * pageSize; i++) {
                double money = 0;
                try {
                    money = xm0204Service.getProjectMoney(xm0204A07DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch (Exception ex) {
                }
                xm0204A07DTOList.get(i).setMoney(money);
                xm0204A07DTOListSelected.add(xm0204A07DTOList.get(i));
            }
        }
        jsonResult.setData(xm0204A07DTOListSelected);
        jsonResult.setTotalCount(xm0204A07DTOList.size());
        return jsonResult;
    }

    /**
     * A08: 组织信息获取（获取组织列表）
     */
    @ApiOperation(value = "组织信息获取", notes = "获取组织列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A08")
    public JSONResult A08(@Valid XM0204A08InputDTO input) {
        JSONResult<List<XM0204A08DTO>> jsonResult = new JSONResult<>();
        List<XM0204A08DTO> xm0204A08DTOList = xm0204Service.getCityLowOrganization(input.getTaskId(), input.getOrganizationId());
        jsonResult.setTotalCount(xm0204A08DTOList.size());
        jsonResult.setData(xm0204A08DTOList);
        return jsonResult;
    }

    /**
     * A09: 任务下发（任务下发）
     */
    @ApiOperation(value = "任务下发", notes = "任务下发", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A09")
    public JSONResult A09(@Valid @RequestBody XM0204A09InputDTO input) {
        JSONResult jsonResult = new JSONResult();

        XmTask xmTask = xm0204Service.selectByPrimaryKey(input.getTaskId());
        for(int i = 0; i < input.getUnits().length; i++) {
            int enable;
            if(xmTask.getEnable() == true)
                enable = 1;
            else
                enable = 0;
            xm0204Service.distribTask(
                    xmTask.getProjectId(),
                    xmTask.getName(),
                    xmTask.getType(),
                    xmTask.getBeginAt(),
                    xmTask.getFinishAt(),
                    enable,
                    xmTask.getRemark(),
                    "待下发",
                    xmTask.getDataTemplateId(),
                    input.getOrganizationId(),
                    input.getTaskId(),
                    input.getUnits()[i]);
        }
        xm0204Service.setDistrib(input.getTaskId());

        return jsonResult;
    }

    /**
     * A10: 项目获取（项目内容获取）
     */
    @ApiOperation(value = "项目获取", notes = "项目内容获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A10")
    public JSONResult A10() {
        JSONResult<List<XM0204A10DTO>> jsonResult = new JSONResult<>();
        List<XM0204A10DTO> xm0204A10DTOList = xm0204Service.getAllProject();

        jsonResult.setData(xm0204A10DTOList);
        return jsonResult;
    }

    /**
     * A11: 启动任务（任务状态变为启动）
     */
    @ApiOperation(value = "启动任务", notes = "任务状态变为启动", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A11")
    public JSONResult A11(@Valid @RequestBody XM0204A11InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        List<Integer> distribedTaskIdList = xm0204Service.getDistribedTaskid(input.getTaskId());
        for (int i = 0; i < distribedTaskIdList.size(); i++) {
            xm0204Service.enableLowTask(distribedTaskIdList.get(i));
            //xm0204Service.deleteFileByTaskId(distribedTaskIdList.get(i));
        }
        xm0204Service.enableLowTask(input.getTaskId());
        xm0204Service.enableTask(input.getTaskId());

        return jsonResult;
    }

    /**
     * A12: 数据模板获取（获取数据模板）
     */
    @ApiOperation(value = "数据模板获取", notes = "获取数据模板", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A12")
    public JSONResult A12() {
        JSONResult<List<XM0204A12DTO>> jsonResult = new JSONResult<>();
        List<XM0204A12DTO> xm0204A12DTOList = new ArrayList<>();

        // TODO 业务逻辑: A12: 数据模板获取（获取数据模板）
        jsonResult.setMessage("接口未实现"); // 实现后删除本行

        jsonResult.setData(xm0204A12DTOList);
        return jsonResult;
    }

    /**
     * A13: 年份任务获取（通过年份获取任务列表）
     */
    @ApiOperation(value = "年份任务获取", notes = "通过年份获取任务列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A13")
    public JSONResult A13(@Valid XM0204A13InputDTO input) {
        JSONResult<List<XM0204A13DTO>> jsonResult = new JSONResult<>();
        List<XM0204A13DTO> xm0204A13DTOList = xm0204Service.getCityYearTask(input.getOrganizationId(), input.getYear());
        List<XM0204A13DTO> xm0204A13DTOListSelected = new ArrayList<>();
        if (xm0204A13DTOList.size() > 0) {
            int page = input.getPageNum();
            int pageSize = input.getPageSize();
            for (int i = (page - 1) * pageSize; i < xm0204A13DTOList.size() && i < page * pageSize; i++) {
                double money = 0;
                try {
                    money = xm0204Service.getProjectMoney(xm0204A13DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch (Exception ex) {
                }
                xm0204A13DTOList.get(i).setMoney(money);
                xm0204A13DTOListSelected.add(xm0204A13DTOList.get(i));
            }
        }
        jsonResult.setData(xm0204A13DTOListSelected);
        jsonResult.setTotalCount(xm0204A13DTOList.size());
        return jsonResult;
    }

    /**
     * A14: 取消下发（取消下发）
     */
    @ApiOperation(value = "取消下发", notes = "取消下发", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A14")
    public JSONResult A14(@Valid @RequestBody XM0204A14InputDTO input) {
        List<Integer> areaTask = xm0204Service.getDistribedTaskid(input.getTaskId());
        for (int i = 0; i < areaTask.size(); i++) {
            List<Integer> schoolTask = xm0204Service.getDistribedTaskid(areaTask.get(i));
            for (int j = 0; j < schoolTask.size(); j++) {
                xm0204Service.deleteFileByTaskId(schoolTask.get(j));
                xm0204Service.deleteProgressByTaskId(schoolTask.get(j));
                xm0204Service.deleteProgressReplyByTaskId(schoolTask.get(j));
            }
            xm0204Service.deleteProgressByTaskId(areaTask.get(i));
            xm0204Service.deleteProgressReplyByTaskId(areaTask.get(i));
            xm0204Service.deleteFileByTaskId(areaTask.get(i));
            xm0204Service.cancleDistrib(areaTask.get(i));
        }
        xm0204Service.cancleDistrib(input.getTaskId());
        xm0204Service.setNotDistrib(input.getTaskId());
        //xm0204Service.deleteFileByTaskId(input.getTaskId());
        JSONResult jsonResult = new JSONResult();

        return jsonResult;
    }

    /**
     * A15: 禁用任务（禁用任务）
     */
    @ApiOperation(value = "禁用任务", notes = "禁用任务", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A15")
    public JSONResult A15(@Valid @RequestBody XM0204A15InputDTO input) {
        JSONResult jsonResult = new JSONResult();
        List<Integer> distribedTaskIdList = xm0204Service.getDistribedTaskid(input.getTaskId());
        for (int i = 0; i < distribedTaskIdList.size(); i++) {
            xm0204Service.disableLowTask(distribedTaskIdList.get(i));
            //xm0204Service.deleteFileByTaskId(distribedTaskIdList.get(i));
        }
        xm0204Service.disableLowTask(input.getTaskId());
        xm0204Service.disable(input.getTaskId());

        return jsonResult;
    }
}
