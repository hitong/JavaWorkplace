package org.ec.xm.service;

import org.ec.xm.dto.XM0201.XM0201A01DTO;
import org.ec.xm.dto.XM0201.XM0201A02DTO;

import java.util.List;

/**
 * XM0201: 项目执行 - 项目管理（首页）
 * 作者：
 * 日期：
 */
public interface XM0201Service extends XMBaseService {
    //获取任务管理情况
    List<XM0201A01DTO> getTasksInfo(Integer organizationId);

    //获取五条退回任务
    List<XM0201A02DTO> getReturnTask(Integer organizationId);

    //获取五条催报任务
    List<XM0201A02DTO> getUrgeTask(Integer organizationId);
}
