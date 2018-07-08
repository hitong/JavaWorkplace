package org.ec.xm.service;

import org.ec.xm.dto.XM0209.XM0209A14DTO;
import org.ec.xm.entity.XmProgress;
import org.ec.xm.entity.XmProgressReply;
import org.ec.xm.entity.XmProjectFile;
import org.ec.xm.entity.XmTask;

import java.util.List;
import java.util.Map;

/**
 * XM0209: 项目执行 - 任务详情(区县)（资料上传页面）
 * 作者：
 * 日期：
 */
public interface XM0209Service extends XMBaseService {
    //查找任务详情
    XmTask getTaskById(Integer task_id);
    //查找动态信息
    List<Map<String,Object>> getContent(Map map);
    //分页查询所属任务信息
    List<Map<String,Object>> getAllTaskById(Map map);
    //分页的总数量
    int getCounts(Map map);
    //任务所属的全部动态信息
    List<Map<String,Object>> getContentAll(Map map);
    //任务所属下级的全部动态信息
    List<Map<String,Object>> getContentSubAll(Map map);
    //任务所属的所有动态信息的数量
    int getDynamicCounts(Map map);
    //任务所属的下级动态信息的数量
    int getDynamicSubCounts(Map map);
    //新增内容
    int getContentAdd(XmProgress xmProgress);
    //退报
    int updateReturn(XmTask xmTask);
    //修改退回状态
    int updateReturnStatus(XmTask xmTask);
    //催报
    int updateUrge(XmTask xmTask);
    //回复内容
    int getContentReply(XmProgressReply xmProgressReply);
    //获取单位名称
    String getOrganization(Integer organization_id);
    //获取项目名称
    String getProjectName(Integer project_id);
    //获取学校名称
    String getSchoolName(Integer school_id);
    //获取用户名称
    String getUserName(Integer user_id);
    //获取用户名
    String getProgressUserName(Integer user_id);
    //获取回复人
    String getProgressReplyUserName(Integer replyman_id);
    //获得动态回复数量
    Integer getProgressReplyNum(Integer progress_id);
    //获取动态回复全部详细信息
    List<XmProgressReply> getProgressReply(Map map);
    //新增附件
    int upLoadFile(XmProjectFile xmProjectFile);
    //获取文件列表和状态
    List<XmProjectFile> getFileListAndStatus(Integer taskId,Integer organizationId);
    //删除文件
    int deleteFile(Integer fileId);

    //修改文件状态
    int changeStatus(XmProjectFile xmProjectFile);
    //获取下级区县名称
    List<XM0209A14DTO> getSubordinateOrganizationName(Integer organization_id);

    //任务状态为已完成
    int setFinishTask(Integer task_id);
    //已完成后退回人催报人置空
    int setFinishNULL(Integer task_id);

   /* //将区县上级组织市委任务设置为已完成
    int setOrganizationFinishTask(int taskId);*/

    //获取该任务同级的所有区县数量
    int distinctsAllNum(Integer task_id);

    //获取该任务同级的所有区县执行完成数量
    int distinctsAllFinishNum(Integer task_id);

    //获取某个任务的上级任务id
    Integer getSuperiorTaskId(int taskId);
}
