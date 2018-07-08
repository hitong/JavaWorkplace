package org.ec.xm.service.impl;

import io.swagger.models.auth.In;
import org.ec.xm.dao.mapper.*;
import org.ec.xm.entity.XmProgress;
import org.ec.xm.entity.XmProgressReply;
import org.ec.xm.entity.XmProjectFile;
import org.ec.xm.entity.XmTask;
import org.ec.xm.service.XM0207Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * XM0207: 项目执行 - 任务详情(学校)（资料上传页面）
 * 作者：
 * 日期：
 */
@Component
@Transactional
public class XM0207ServiceImpl implements XM0207Service {
    private XmTaskMapper xmTaskMapper;
    private XmProgressMapper xmProgressMapper;
    private XmProgressReplyMapper xmProgressReplyMapper;
    private XmProjectFileMapper xmProjectFileMapper;
    private XmProjectMapper xmProjectMapper;

    public XM0207ServiceImpl(XmTaskMapper xmTaskMapper, XmProgressMapper xmProgressMapper, XmProgressReplyMapper xmProgressReplyMapper,
                             XmProjectFileMapper xmProjectFileMapper, XmProjectMapper xmProjectMapper){
        this.xmTaskMapper=xmTaskMapper;
        this.xmProgressMapper=xmProgressMapper;
        this.xmProgressReplyMapper=xmProgressReplyMapper;
        this.xmProjectFileMapper = xmProjectFileMapper;
        this.xmProjectMapper=xmProjectMapper;
    }
    @Override
    public XmTask getTaskById(Integer task_id) {
        return this.xmTaskMapper.selectsubTasktByTaskId(task_id);
    }

    @Override
    public List<Map<String,Object>> getContent(Map map) {
        return this.xmProgressMapper.selectProgressByTaskId(map);
    }

    @Override
    public List<Map<String, Object>> getContentAll(Map map) {
        return this.xmProgressMapper.selectAllByTaskId(map);
    }

    @Override
    public int getDynamicCounts(Map map) {
        return this.xmProgressMapper.getDynamicCounts(map);
    }

    @Override
    public int getContentAdd(XmProgress xmProgress) {
        return this.xmProgressMapper.insert(xmProgress);
    }

    @Override
    public Integer getProgressReplyNum(Integer progress_id) {
        return this.xmProgressReplyMapper.getProgressReplyNum(progress_id);
    }

    @Override
    public List<XmProgressReply> getProgressReply(Map map) {
        return this.xmProgressReplyMapper.getProgressReply(map);
    }

    @Override
    public String getOrganization(Integer organization_id) {
        return this.xmProgressMapper.getOrganization(organization_id);
    }

    @Override
    public String getProgressUserName(Integer user_id) {
        return this.xmProgressMapper.getProgressUserName(user_id);
    }

    @Override
    public String getProgressReplyUserName(Integer replyman_id) {
        return this.xmProgressReplyMapper.getProgressReplyUserName(replyman_id);
    }

    @Override
    public String getProjectName(Integer project_id) {
        return this.xmProjectMapper.getProjectName(project_id);
    }

    @Override
    public int getContentReply(XmProgressReply xmProgressReply) {
        return this.xmProgressReplyMapper.insertReply(xmProgressReply);
    }

    @Override
    public int fileAddApiByTask(XmProjectFile xmProjectFile) {
        return this.xmProjectFileMapper.fileAddApiByTask(xmProjectFile);
    }

    @Override
    public List<XmProjectFile> getFileListByTaskId(Integer taskId,Integer organizationId) {
        return this.xmProjectFileMapper.getFileListByTaskId(taskId,organizationId);
    }

    @Override
    public int deleteFileByFileId(Integer fileId) {
        return this.xmProjectFileMapper.deleteByPrimaryKey(fileId);
    }

    @Override
    public int setFinishTask(Integer task_id) {
        return this.xmTaskMapper.setFinishTask(task_id);
    }

    @Override
    public int setFinishNULL(Integer task_id) {
        return this.xmTaskMapper.setFinishNULL(task_id);
    }
}
