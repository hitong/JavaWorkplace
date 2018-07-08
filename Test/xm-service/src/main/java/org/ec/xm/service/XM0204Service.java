package org.ec.xm.service;

import org.ec.xm.dto.XM0204.*;
import org.ec.xm.entity.XmTask;

import java.util.Date;
import java.util.List;

/**
 * XM0204: 项目执行 - 任务管理（任务管理页面）
 * 作者：李红
 * 日期：2018-5-20
 */
public interface XM0204Service extends XMBaseService {

    //根据任务id获取项目名称
    java.lang.String getName(int id);

    //获取市级下级组织
    List<XM0204A08DTO> getCityLowOrganization(int taskId, int organizationId);

    //删除任务
    int deleteByPrimaryKey(Integer id);

    //获取所有任务
    List<XM0204A10DTO> getAllProject();

    //增加任务
    int insert(XmTask record);

    //启用任务
    int enableTask(int taskId);

    //修改任务
    int editTask(XmTask xmTask);

    //取消下发
    int cancleDistrib(int taskId);

    //禁用任务
    int disable(int taskId);

    //将任务的状态设置为已下发
    int setDistrib(int taskId);

    //将任务状态设置为待下发
    int setNotDistrib(int taskId);

    //通过任务ID查询任务
    XmTask selectByPrimaryKey(Integer id);

    //将任务下发给组织
    int distribTask(int projectId, String name, String type, Date beginAt, Date finishAt, int enable, String remark,
                    String status, int dataTemplateId, int superiorOrganizationId, int superTaskId, int organizationId);

    //获取教委任务
    List<XM0204A01DTO> getAllCityTask(int organization);

    //获取筛选树
    List<XM0204A06DTO> getCitySelectTree(int orgnizationId);

    //获取市级项目任务
    List<XM0204A07DTO> getCityProjectTask(int organizationId, int projectId, String keyword);

    //获取市级年份任务
    List<XM0204A13DTO> getCityYearTask(int organizationId, String year);

    //获取市级教委查询任务结果
    List<XM0204A05DTO> getCitySearchTask (int organization, String keyWord);

    //获取项目资金
    Double getProjectMoney(int projectId, int organizationId);

    //获取已经被下发了某个任务的组织id
    List<Integer> getDistribedTaskid(int organizationId);

    //禁用下级任务
    int disableLowTask(int taskId);

    //删除某个任务所上传的文件
    int deleteFileByTaskId(int taskId);

    //启用下级任务
    int enableLowTask(int taskId);

    //获取下级组织
    Integer[] getAllOrganizationId();

    //删除某个任务的进度
    int deleteProgressByTaskId(int taskId);

    //删除某个回复
    int deleteProgressReplyByTaskId(int taskId);

}
