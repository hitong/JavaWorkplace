package org.ec.xm.service;

import org.ec.xm.dto.XM0206.XM0206A08DTO;
import org.ec.xm.dto.XM0208.*;
import org.ec.xm.entity.XmProject;
import org.ec.xm.entity.XmTask;

import java.util.Date;
import java.util.List;

/**
 * XM0208: 项目执行 - 任务管理(区县)（任务管理(区县)页面）
 * 作者：
 * 日期：
 */
public interface XM0208Service extends XMBaseService {

    //根据任务id获取项目名称
    java.lang.String getName(int id);

    //根据任务id获取上级组织id
    Integer getUpOrganizationId(int id);

    //获取组织负责人姓名
    String getChargeManName (int organizationId);

    //将任务下发给组织
    int distribTask(int projectId, String name, String type, Date beginAt, Date finishAt, int enable, String remark,
                    String status, int dataTemplateId, int superiorOrganizationId, int superTaskId, int organizationId);

    //通过任务ID查询任务
    XmTask selectByPrimaryKey(Integer id);

    //将任务的状态设置为已下发
    int setDistrib(int taskId);

    //获取区县任务
    List<XM0208A01DTO> getAllAreaTask(int organization);

    //获取区县教委任务筛选树
    List<XM0208A07DTO> getAreaSelectTree(int organizationId);

    //获取区县教委项目的任务
    List<XM0208A08DTO> getAreaProjectTask(int organizationId, int projectId);

    //获取区县教委年份任务
    List<XM0208A09DTO> getAreaYearTask(int organizationId, String year);

    //获取区县教委下级组织
    List<XM0208A03DTO> getAreaLowOrganization(int taskId, int organizationId);

    //获取区县教委查询任务结果
    List<XM0208A04DTO> getAreaSearchTask(int organization, String keyWord);

    //获取项目资金
    Double getProjectMoney(int projectId, int organizationId);

    //获取任务资金
    Double getTaskMoney(int projectId, int organizationId);

    //获取区县上级文件信息
    List<XM0208A05DTO> getAreaSuperiorFile(int taskId, int organizationId);

    //获取区县文件信息
    List<XM0208A06DTO> getAreaFile(int taskId, int organizationId);

    //获取某个任务的上级任务id
    Integer getSuperiorTaskId(int taskId);

    //获取区县资金下发文件
    List<XM0208A05DTO> getAreaFundingFile(int taskId);

    //取消下发
    int cancleDistrib(int taskId);

    //获取某个任务下发产生的任务的任务id
    List<Integer> getDistribedTaskid(int taskId);

    //删除某个任务所上传的文件
    int deleteFileByTaskId(int taskId);

    //删除某个任务的进度
    int deleteProgressByTaskId(int taskId);

    //删除某个回复
    int deleteProgressReplyByTaskId(int taskId);

    //将任务状态设置为待下发
    int setNotDistrib(int taskId);

    //获取区级被退回的任务
    List<XM0208A10DTO> getAreaReturnTasks(int organizationId);

    //获取区级被催报的任务
    List<XM0208A10DTO> getAreaUrgedTasks(int organizationId);
}
