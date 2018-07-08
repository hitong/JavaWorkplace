package org.ec.xm.service;

import org.ec.xm.dto.XM0203.XM0203A06DTO;
import org.ec.xm.dto.XM0206.*;
import org.ec.xm.dto.XM0208.XM0208A05DTO;
import org.ec.xm.entity.XmTask;

import java.util.List;

/**
 * XM0206: 项目执行 - 任务管理(学校)（任务管理(学校)页面）
 * 作者：
 * 日期：
 */
public interface XM0206Service extends XMBaseService {

    //根据任务id获取项目名称
    java.lang.String getName(int id);

    //根据任务id获取上级组织id
    Integer getUpOrganizationId(int id);

    //根据组织id和任务id获取文件信息
    List<XM0206A03DTO> getFileSchool(int taskId, int organizationId);

    //获取学校任务
    List<XM0206A01DTO> getAllSchoolTask(int organization);

    //获取学校筛选树
    List<XM0206A05DTO> getSchoolSelectTree(int organizationId);

    //获取学校一个项目的任务
    List<XM0206A06DTO> getSchoolProjectTask(int organizationId, int projectId);

    //获取学校年份任务
    List<XM0206A07DTO> getSchoolYearTask(int organizationId, String year);

    //获取学校查询任务结果
    List<XM0206A02DTO> getSchoolSearchTask(int organization, String keyWord);

    //获取任务资金
    Double getTaskMoney(int projectId, int organizationId);

    //获取学校上级文件信息
    List<XM0206A04DTO> getSchoolSuperiorFile(int taskId, int organizationId);

    //获取学校文件信息
    List<XM0206A03DTO> getSchoolFile(int taskId,int organizitionId);

    //获取学校的资金下达文件信息
    List<XM0206A04DTO> getSchoolFundingFile(int taskId);

    //获取某个任务的上级任务id
    Integer getSuperiorTaskId(int taskId);

    //获取学校被退回的任务
    List<XM0206A08DTO> getSchoolReturnTasks(int organizationId);

    //获取学校被催报的任务
    List<XM0206A08DTO> getSchoolUrgedTasks(int organizationId);
}
