package org.ec.xm.api.controller;

import io.swagger.annotations.*;
import org.ec.utils.BeanMapper;
import org.ec.xm.entity.XmProject;
import org.ec.xm.entity.XmTask;
import org.ec.xm.service.XM0208Service;
import org.ec.utils.JSONResult;
import org.ec.xm.dto.XM0208.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.validation.Valid;

/**
 * XM0208: 项目执行 - 任务管理(区县)（任务管理(区县)页面）
 * 作者：
 * 日期：
 */
@RestController
@CrossOrigin
@Api("XM0208: 项目执行 - 任务管理(区县)（任务管理(区县)页面）")
@RequestMapping("/XM0208")
public class XM0208Controller extends BaseController {

    /**
     * XM0208Service
     */
    private final XM0208Service xm0208Service;

    @Autowired
    public XM0208Controller(XM0208Service xm0208Service) {
        this.xm0208Service = xm0208Service;
    }

    /**
     * A01: 任务列表获取(区县)（获取任务列表）
     */
    @ApiOperation(value = "任务列表获取(区县)", notes = "获取任务列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01(@Valid XM0208A01InputDTO input) {
        JSONResult<List<XM0208A01DTO>> jsonResult = new JSONResult<>();
        List<XM0208A01DTO> xm0208A01DTOList = xm0208Service.getAllAreaTask(input.getOrganizationId());
        List<XM0208A01DTO> xm0208A01DTOListSelected = new ArrayList<>();
        if (xm0208A01DTOList.size() > 0) {
            int page = input.getPageNum();
            int pageSize = input.getPageSize();
            for (int i = (page - 1) * pageSize; i < xm0208A01DTOList.size() && i < page * pageSize; i++) {
                double projectMoney = 0;
                double taskMonty = 0;
                double money = 0;
                try {
                    projectMoney = xm0208Service.getProjectMoney(xm0208A01DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch (Exception ex) {
                }

                try {
                    taskMonty = xm0208Service.getTaskMoney(xm0208A01DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch (Exception ex) {
                }
                try {
                    NumberFormat nf = NumberFormat.getNumberInstance();
                    nf.setMaximumFractionDigits(2);

                    money = projectMoney + taskMonty;
                    money = Double.parseDouble(nf.format(money));

                }catch (Exception ex) {
                }
                xm0208A01DTOList.get(i).setMoney(money);
                xm0208A01DTOListSelected.add(xm0208A01DTOList.get(i));
            }
        }
        jsonResult.setData(xm0208A01DTOListSelected);
        jsonResult.setTotalCount(xm0208A01DTOList.size());
        return jsonResult;
    }

    /**
     * A02: 任务下发(区县)（任务下发）
     */
    @ApiOperation(value = "任务下发(区县)", notes = "任务下发", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A02")
    public JSONResult A02(@Valid @RequestBody XM0208A02InputDTO input) {
        JSONResult jsonResult = new JSONResult();

        XmTask xmTask = xm0208Service.selectByPrimaryKey(input.getTaskId());
        for(int i = 0; i < input.getUnits().length; i++) {
            int enable;
            if(xmTask.getEnable() == true)
                enable = 1;
            else
                enable = 0;
            xm0208Service.distribTask(
                    xmTask.getProjectId(),
                    xmTask.getName(),
                    xmTask.getType(),
                    xmTask.getBeginAt(),
                    xmTask.getFinishAt(),
                    enable,
                    xmTask.getRemark(),
                    "执行中",
                    xmTask.getDataTemplateId(),
                    xmTask.getOrganizationId(),
                    input.getTaskId(),
                    input.getUnits()[i]);
        }
        xm0208Service.setDistrib(input.getTaskId());

        return jsonResult;
    }

    /**
     * A03: 组织信息获取(区县)（获取组织列表）
     */
    @ApiOperation(value = "组织信息获取(区县)", notes = "获取组织列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A03")
    public JSONResult A03(@Valid XM0208A03InputDTO input) {
        JSONResult<List<XM0208A03DTO>> jsonResult = new JSONResult<>();
        List<XM0208A03DTO> xm0208A03DTOList = xm0208Service.getAreaLowOrganization(input.getTaskId(), input.getOrganizationId());
        jsonResult.setTotalCount(xm0208A03DTOList.size());
        jsonResult.setData(xm0208A03DTOList);
        return jsonResult;
    }

    /**
     * A04: 任务查询获取(区县)（获取任务查询结果列表）
     */
    @ApiOperation(value = "任务查询获取(区县)", notes = "获取任务查询结果列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A04")
    public JSONResult A04(@Valid XM0208A04InputDTO input) {
        JSONResult<List<XM0208A04DTO>> jsonResult = new JSONResult<>();
        List<XM0208A04DTO> xm0208A04DTOList = xm0208Service.getAreaSearchTask(input.getOrganizationId(), input.getKeyWord());
        List<XM0208A04DTO> xm0208A04DTOListSelected = new ArrayList<>();
        if (xm0208A04DTOList.size() > 0) {
            int page = input.getPageNum();
            int pageSize = input.getPageSize();
            for (int i = (page - 1) * pageSize; i < xm0208A04DTOList.size() && i < page * pageSize; i++) {
                double projectMoney = 0;
                double taskMonty = 0;
                double money = 0;
                try {
                    projectMoney = xm0208Service.getProjectMoney(xm0208A04DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch (Exception ex) {
                }

                try {
                    taskMonty = xm0208Service.getTaskMoney(xm0208A04DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch (Exception ex) {
                }
                try {
                    NumberFormat nf = NumberFormat.getNumberInstance();
                    nf.setMaximumFractionDigits(2);

                    money = projectMoney + taskMonty;
                    money = Double.parseDouble(nf.format(money));
                }catch (Exception ex) {
                }
                xm0208A04DTOList.get(i).setMoney(money);
                xm0208A04DTOListSelected.add(xm0208A04DTOList.get(i));
            }
        }
        jsonResult.setData(xm0208A04DTOListSelected);
        jsonResult.setTotalCount(xm0208A04DTOList.size());
        return jsonResult;
    }

    /**
     * A05: 上级文件获取(区县)（上级文件获取）
     */
    @ApiOperation(value = "上级文件获取(区县)", notes = "上级文件获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A05")
    public JSONResult A05(@Valid XM0208A05InputDTO input) {
        JSONResult<List<XM0208A05DTO>> jsonResult = new JSONResult<>();
        List<XM0208A05DTO> fundingFiles = xm0208Service.getAreaFundingFile(input.getTaskId());
        List<XM0208A05DTO> xm0208A05DTOList = xm0208Service.getAreaSuperiorFile(xm0208Service.getSuperiorTaskId(input.getTaskId()), xm0208Service.getUpOrganizationId(input.getTaskId()));
        for (int i = 0; i < fundingFiles.size(); i++)
            xm0208A05DTOList.add(fundingFiles.get(i));
        jsonResult.setData(xm0208A05DTOList);
        return jsonResult;
    }
    /**
     * A06: 文件资料获取(区县)（文件资料获取）
     */
    @ApiOperation(value = "文件资料获取(区县)", notes = "文件资料获取", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A06")
    public JSONResult A06(@Valid XM0208A06InputDTO input) {
        JSONResult<List<XM0208A06DTO>> jsonResult = new JSONResult<>();
        List<XM0208A06DTO> xm0208A06DTOList = xm0208Service.getAreaFile(input.getTaskId(), input.getGeOrganizationId());

        // TODO 业务逻辑: A06: 文件资料获取(区县)（文件资料获取）

        jsonResult.setData(xm0208A06DTOList);
        return jsonResult;
    }

    /**
     * A07: 任务筛选树获取(区县)（获取任务筛选树）
     */
    @ApiOperation(value = "任务筛选树获取(区县)", notes = "获取任务筛选树", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A07")
    public JSONResult A07(@Valid XM0208A07InputDTO input) {
        JSONResult<List<XM0208A07DTO>> jsonResult = new JSONResult<>();
        List<XM0208A07DTO> xm0208A07DTOList = xm0208Service.getAreaSelectTree(input.getOrganizationId());
        jsonResult.setData(xm0208A07DTOList);
        return jsonResult;
    }

    /**
     * A08: 项目任务获取(区县)（获取任务列表）
     */
    @ApiOperation(value = "项目任务获取(区县)", notes = "获取任务列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A08")
    public JSONResult A08(@Valid XM0208A08InputDTO input) {
        JSONResult<List<XM0208A08DTO>> jsonResult = new JSONResult<>();
        List<XM0208A08DTO> xm0208A08DTOList = xm0208Service.getAreaProjectTask(input.getOrganizationId(), input.getProjectId());
        List<XM0208A08DTO> xm0208A08DTOListSelected = new ArrayList<>();

        if (xm0208A08DTOList.size() > 0) {
            int page = input.getPageNum();
            int pageSize = input.getPageSize();
            for (int i = (page - 1) * pageSize; i < xm0208A08DTOList.size() && i < page * pageSize; i++) {
                double projectMoney = 0;
                double taskMonty = 0;
                double money = 0;
                try {
                    projectMoney = xm0208Service.getProjectMoney(xm0208A08DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch (Exception ex) {
                }

                try {
                    taskMonty = xm0208Service.getTaskMoney(xm0208A08DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch (Exception ex) {
                }
                try {
                    NumberFormat nf = NumberFormat.getNumberInstance();
                    nf.setMaximumFractionDigits(2);

                    money = projectMoney + taskMonty;
                    money = Double.parseDouble(nf.format(money));
                }catch (Exception ex) {
                }
                xm0208A08DTOList.get(i).setMoney(money);
                xm0208A08DTOListSelected.add(xm0208A08DTOList.get(i));
            }
        }
        jsonResult.setData(xm0208A08DTOListSelected);
        jsonResult.setTotalCount(xm0208A08DTOList.size());
        return jsonResult;
    }

    /**
     * A09: 年份任务获取（通过年份获取任务列表）
     */
    @ApiOperation(value = "年份任务获取", notes = "通过年份获取任务列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A09")
    public JSONResult A09(@Valid XM0208A09InputDTO input) {
        JSONResult<List<XM0208A09DTO>> jsonResult = new JSONResult<>();
        List<XM0208A09DTO> xm0208A09DTOList = xm0208Service.getAreaYearTask(input.getOrganizationId(), input.getYear());
        List<XM0208A09DTO> xm0208A09DTOListSelected = new ArrayList<>();
        if (xm0208A09DTOList.size() > 0) {
            int page = input.getPageNum();
            int pageSize = input.getPageSize();
            for (int i = (page - 1) * pageSize; i < xm0208A09DTOList.size() && i < page * pageSize; i++) {
                double projectMoney = 0;
                double taskMonty = 0;
                double money = 0;
                try {
                    projectMoney = xm0208Service.getProjectMoney(xm0208A09DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch (Exception ex) {
                }

                try {
                    taskMonty = xm0208Service.getTaskMoney(xm0208A09DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch (Exception ex) {
                }
                try {
                    NumberFormat nf = NumberFormat.getNumberInstance();
                    nf.setMaximumFractionDigits(2);

                    money = projectMoney + taskMonty;
                    money = Double.parseDouble(nf.format(money));
                }catch (Exception ex) {
                }
                xm0208A09DTOList.get(i).setMoney(money);
                xm0208A09DTOListSelected.add(xm0208A09DTOList.get(i));
            }
        }
        jsonResult.setData(xm0208A09DTOListSelected);
        jsonResult.setTotalCount(xm0208A09DTOList.size());
        return jsonResult;
    }

    /**
     * A10: 退回或催报任务获取(区县)（获取退回）
     */
    @ApiOperation(value = "退回或催报任务获取(区县)", notes = "获取退回", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A10")
    public JSONResult A10(@Valid XM0208A10InputDTO input) {
        JSONResult<List<XM0208A10DTO>> jsonResult = new JSONResult<>();
        List<XM0208A10DTO> xm0208A10DTOList = new ArrayList<>();
        if(input.getType().equals("return"))
            xm0208A10DTOList = xm0208Service.getAreaReturnTasks(input.getOrganizationId());
        if(input.getType().equals("urge"))
            xm0208A10DTOList = xm0208Service.getAreaUrgedTasks(input.getOrganizationId());
        List<XM0208A10DTO> xm0208A10DTOListSelected = new ArrayList<>();
        if (xm0208A10DTOList.size() > 0) {
            int page = input.getPageNum();
            int pageSize = input.getPageSize();
            for (int i = (page - 1) * pageSize; i < xm0208A10DTOList.size() && i < page * pageSize; i++) {
                double money = 0;
                try {
                    money = xm0208Service.getTaskMoney(xm0208A10DTOList.get(i).getProjectId(), input.getOrganizationId());
                } catch(Exception ex) {
                }
                xm0208A10DTOList.get(i).setMoney(money);
                xm0208A10DTOListSelected.add(xm0208A10DTOList.get(i));
            }
        }
        jsonResult.setData(xm0208A10DTOListSelected);
        jsonResult.setTotalCount(xm0208A10DTOList.size());
        return jsonResult;
    }

    /**
     * A11: 取消下发(区县)（区县取消下发）
     */
    @ApiOperation(value = "取消下发(区县)", notes = "区县取消下发", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.POST, value = "/A11")
    public JSONResult A11(@Valid @RequestBody XM0208A11InputDTO input) {
        List<Integer> schoolTask = xm0208Service.getDistribedTaskid(input.getTaskId());
        for (int i = 0; i < schoolTask.size(); i++) {
            xm0208Service.deleteProgressByTaskId(schoolTask.get(i));
            xm0208Service.deleteProgressReplyByTaskId(schoolTask.get(i));
            xm0208Service.deleteFileByTaskId(schoolTask.get(i));
        }
        xm0208Service.cancleDistrib(input.getTaskId());
        xm0208Service.setNotDistrib(input.getTaskId());
        //xm0208Service.deleteFileByTaskId(input.getTaskId());
        JSONResult jsonResult = new JSONResult();

        return jsonResult;
    }
}
