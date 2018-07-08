package org.ec.xm.service.impl;

import org.ec.xm.dao.mapper.XmProgressMapper;
import org.ec.xm.dao.mapper.XmProgressReplyMapper;
import org.ec.xm.dao.mapper.XmProjectMapper;
import org.ec.xm.dao.mapper.XmTaskMapper;
import org.ec.xm.dto.XM0205.XM0205A11DTO;
import org.ec.xm.entity.XmProgress;
import org.ec.xm.entity.XmProgressReply;
import org.ec.xm.entity.XmProject;
import org.ec.xm.entity.XmTask;
import org.ec.xm.service.XM0205Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * XM0205: 项目执行 - 任务详情（基础信息页面）
 * 作者：
 * 日期：
 */
@Component
@Transactional
public class XM0205ServiceImpl implements XM0205Service {
    private XmTaskMapper xmTaskMapper;
    private XmProgressMapper xmProgressMapper;
    private XmProgressReplyMapper xmProgressReplyMapper;
    private XmProjectMapper xmProjectMapper;

    public XM0205ServiceImpl(XmTaskMapper xmTaskMapper,XmProgressMapper xmProgressMapper,XmProgressReplyMapper xmProgressReplyMapper,XmProjectMapper xmProjectMapper){
        this.xmTaskMapper=xmTaskMapper;
        this.xmProgressMapper=xmProgressMapper;
        this.xmProgressReplyMapper=xmProgressReplyMapper;
        this.xmProjectMapper=xmProjectMapper;
    }

    @Override
    public XmTask getTaskById(Integer task_id) {
        return xmTaskMapper.selectByPrimaryKey(task_id);
    }

    @Override
    public List<Map<String,Object>> getContent(Map map) {
        return this.xmProgressMapper.selectTaskDynamicLimit5(map);
    }

    @Override
    public List<Map<String, Object>> getAllTaskById(Map map) {
        return this.xmTaskMapper.selectOrganizationTaskByMap(map);
    }

    @Override
    public int getCounts(Map map) {
        return this.xmTaskMapper.getAllCounts(map);
    }

    @Override
    public int getDynamicSubCounts(Map map) {
        return this.xmProgressMapper.selectSubTaskDynamicCounts(map);
    }


    @Override
    public int getContentAdd(XmProgress xmProgress) {
        return this.xmProgressMapper.insert(xmProgress);
    }

    @Override
    public int getContentReply(XmProgressReply xmProgressReply) { return this.xmProgressReplyMapper.insertReply(xmProgressReply); }

    @Override
    public List<Map<String,Object>> getContentAll(Map map) {
        return this.xmProgressMapper.selectTaskAllDynamic(map);
    }

    @Override
    public List<Map<String, Object>> getContentSubAll(Map map) {
        return this.xmProgressMapper.selectSubTaskDynamic(map);
    }

    @Override
    public int getProgressCounts(Map map) {
        return this.xmProgressMapper.selectTaskAllDynamicCounts(map);
    }

    @Override
    public int updateReturn(XmTask xmTask) {
        return this.xmTaskMapper.updateReturn(xmTask);
    }

    @Override
    public int updateReturnStatus(XmTask xmTask) {
        return this.xmTaskMapper.updateReturnStatus(xmTask);
    }

    @Override
    public int updateUrge(XmTask xmTask) {
        return this.xmTaskMapper.updateUrge(xmTask);
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
    public String getOrganizationName(Integer organization_id) {
        return this.xmTaskMapper.getOrganizationName(organization_id);
    }

    @Override
    public String getUserName(Integer user_id) {
        return this.xmTaskMapper.getUserName(user_id);
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
    public List<XM0205A11DTO> getSubordinateOrganizationName(Integer organization_id) {
        return this.xmProgressMapper.getSubordinateName(organization_id);
    }

    @Override
    public Integer getSuperiorTaskId(int taskId) {
        return this.xmTaskMapper.getSuperiorTaskId(taskId);
    }

    @Override
    public int setDistrib(int taskId) {
        return this.xmTaskMapper.setDistrib(taskId);
    }
}
