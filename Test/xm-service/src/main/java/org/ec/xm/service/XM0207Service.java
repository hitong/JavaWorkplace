package org.ec.xm.service;

import org.ec.xm.entity.XmProgress;
import org.ec.xm.entity.XmProgressReply;
import org.ec.xm.entity.XmProjectFile;
import org.ec.xm.entity.XmTask;

import java.util.List;
import java.util.Map;

/**
 * XM0207: 项目执行 - 任务详情(学校)（资料上传页面）
 * 作者：
 * 日期：
 */
public interface XM0207Service extends XMBaseService {
    //查找任务详情
    XmTask getTaskById(Integer task_id);
    //查找动态信息
    List<Map<String,Object>> getContent(Map map);
    //任务所属的全部动态信息
    List<Map<String,Object>> getContentAll(Map map);
    int getDynamicCounts(Map map);
    //新增内容
    int getContentAdd(XmProgress xmProgress);
    //获得动态回复数量
    Integer getProgressReplyNum(Integer progress_id);
    //获取动态回复全部详细信息
    List<XmProgressReply> getProgressReply(Map map);
    //获取单位名称
    String getOrganization(Integer organization_id);
    //获取用户名
    String getProgressUserName(Integer user_id);
    //获取回复人
    String getProgressReplyUserName(Integer replyman_id);
    //获取项目名称
    String getProjectName(Integer project_id);
    //回复内容
    int getContentReply(XmProgressReply xmProgressReply);
    //文件上传
    int fileAddApiByTask(XmProjectFile xmProjectFile);
    //文件列表获取
    List<XmProjectFile>  getFileListByTaskId(Integer taskId,Integer organizationId);
    //文件删除
    int deleteFileByFileId(Integer fileId);

    //任务状态为已完成
    int setFinishTask(Integer task_id);
    //已完成后退回人催报人置空
    int setFinishNULL(Integer task_id);
}
