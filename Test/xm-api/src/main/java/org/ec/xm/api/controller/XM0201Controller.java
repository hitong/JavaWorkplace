package org.ec.xm.api.controller;

import io.swagger.annotations.*;
import org.ec.utils.LoggerFormatter;
import org.ec.xm.service.XM0201Service;
import org.ec.utils.JSONResult;
import org.ec.xm.dto.XM0201.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import javax.validation.Valid;

/**
 * XM0201: 项目执行 - 项目管理（首页）
 * 作者：
 * 日期：
 */
@RestController
@CrossOrigin
@Api("XM0201: 项目执行 - 项目管理（首页）")
@RequestMapping("/XM0201")
public class XM0201Controller extends BaseController {

    /**
     * XM0201Service
     */
    private final XM0201Service xm0201Service;

    @Autowired
    public XM0201Controller(XM0201Service xm0201Service) {
        this.xm0201Service = xm0201Service;
    }

    /**
     * A01: 年度任务状态获取（根据组织ID获取任务的状态）
     */
    @ApiOperation(value = "年度任务状态获取", notes = "根据组织ID获取任务的状态", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A01")
    public JSONResult A01(@Valid XM0201A01InputDTO input) {
        JSONResult<List<XM0201A01DTO>> jsonResult = new JSONResult<>();
        List<XM0201A01DTO> xm0201A01DTOList = xm0201Service.getTasksInfo(input.getOrganizationId());

        jsonResult.setData(xm0201A01DTOList);
        return jsonResult;
    }

    /**
     * A02: 退回任务或催报任务获取（获取退回或催报任务5条）
     */
    @ApiOperation(value = "退回任务或催报任务获取", notes = "获取退回或催报任务5条", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(method = RequestMethod.GET, value = "/A02")
    public JSONResult A02(@Valid XM0201A02InputDTO input) {
        JSONResult<List<XM0201A02DTO>> jsonResult = new JSONResult<>();
        List<XM0201A02DTO> xm0201A02DTOList = new ArrayList<>();
        List<XM0201A02DTO> result = new ArrayList<>();
        if(input.getType().equals("return")) {
            xm0201A02DTOList = xm0201Service.getReturnTask(input.getOrganizationId());
            if (xm0201A02DTOList.size() > 5) {
                for (int i = 0; i < 5; i++) {
                    result.add(xm0201A02DTOList.get(i));
                }
                jsonResult.setData(result);
            }
            else
                jsonResult.setData(xm0201A02DTOList);
        }
        if(input.getType().equals("urge")) {
            xm0201A02DTOList = xm0201Service.getUrgeTask(input.getOrganizationId());
            if (xm0201A02DTOList.size() > 5) {
                for (int i = 0; i < 5; i++) {
                    result.add(xm0201A02DTOList.get(i));
                }
                jsonResult.setData(result);
            }
            else
                jsonResult.setData(xm0201A02DTOList);
        }
        return jsonResult;
    }
}
