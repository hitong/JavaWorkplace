package org.ec.xm.service;

import org.ec.xm.dto.XM0205.XM0205A11DTO;
import org.ec.xm.entity.XmProgress;
import org.ec.xm.entity.XmProgressReply;
import org.ec.xm.entity.XmTask;

import java.util.List;
import java.util.Map;

/**
 * XM0205: 项目执行 - 任务详情（基础信息页面）
 * 作者：
 * 日期：
 */
public interface XM0205Service extends XMBaseService {
    //查找任务详情
    XmTask getTaskById(Integer task_id);
    //查找动态信息
    List<Map<String,Object>> getContent(Map map);
    //分页查询所属任务信息
    List<Map<String,Object>>getAllTaskById(Map map);
    //分页的总数量
    int getCounts(Map map);
    //任务所属的下级动态信息的数量
    int getDynamicSubCounts(Map map);
    //新增内容
    int getContentAdd(XmProgress xmProgress);
    //回复内容
    int getContentReply(XmProgressReply xmProgressReply);
    //任务所属的全部动态信息
    List<Map<String,Object>> getContentAll(Map map);
    //任务所属下级的全部动态信息
    List<Map<String,Object>> getContentSubAll(Map map);
   //获取动态信息数量
    int getProgressCounts(Map map);
    //退报
    int updateReturn(XmTask xmTask);
    //修改退回状态
    int updateReturnStatus(XmTask xmTask);

    //催报
    int updateUrge(XmTask xmTask);
    //获取单位名称
    String getOrganization(Integer organization_id);
    //获取用户名
    String getProgressUserName(Integer user_id);
    //获取回复人
    String getProgressReplyUserName(Integer replyman_id);
    //获取项目名称
    String getProjectName(Integer project_id);
    //获取区县名称
    String getOrganizationName(Integer organization_id);
    //获取用户名称
    String getUserName(Integer user_id);
    //获得动态回复数量
    Integer getProgressReplyNum(Integer progress_id);
    //获取动态回复全部详细信息
    List<XmProgressReply> getProgressReply(Map map);
    //获取下级区县名称
    List<XM0205A11DTO> getSubordinateOrganizationName(Integer organization_id);

    //获取某个任务的上级任务id
    Integer getSuperiorTaskId(int taskId);
    //将任务的状态设置为执行中
    int setDistrib(int taskId);
}
