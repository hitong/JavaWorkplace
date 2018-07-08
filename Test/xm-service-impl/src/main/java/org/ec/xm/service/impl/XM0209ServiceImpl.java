package org.ec.xm.service.impl;

import org.ec.xm.dao.mapper.*;
import org.ec.xm.dto.XM0209.XM0209A14DTO;
import org.ec.xm.entity.XmProgress;
import org.ec.xm.entity.XmProgressReply;
import org.ec.xm.entity.XmProjectFile;
import org.ec.xm.entity.XmTask;
import org.ec.xm.service.XM0209Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * XM0209: 项目执行 - 任务详情(区县)（资料上传页面）
 * 作者：
 * 日期：
 */
@Component
@Transactional
public class XM0209ServiceImpl implements XM0209Service {
    private XmTaskMapper xmTaskMapper;
    private XmProgressMapper xmProgressMapper;
    private XmProgressReplyMapper xmProgressReplyMapper;
    private XmProjectFileMapper xmProjectFileMapper;
    private XmProjectMapper xmProjectMapper;

    public XM0209ServiceImpl(XmTaskMapper xmTaskMapper,XmProgressMapper xmProgressMapper,XmProgressReplyMapper xmProgressReplyMapper,
                             XmProjectFileMapper xmProjectFileMapper,XmProjectMapper xmProjectMapper){
        this.xmTaskMapper=xmTaskMapper;
        this.xmProgressMapper=xmProgressMapper;
        this.xmProgressReplyMapper=xmProgressReplyMapper;
        this.xmProjectFileMapper=xmProjectFileMapper;
        this.xmProjectMapper=xmProjectMapper;
    }
    @Override
    public XmTask getTaskById(Integer task_id) {
       // return this.xmTaskMapper.selectByTaskId(task_id);
        return  this.xmTaskMapper.selectByPrimaryKey(task_id);
    }

    @Override
    public List<Map<String,Object>> getContent(Map map) {
        return this.xmProgressMapper.selectDistinctTaskDynamicLimit5(map);
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
    public List<Map<String, Object>> getContentAll(Map map) {
        return this.xmProgressMapper.selectDistinctTaskAllDynamic(map);
    }

    @Override
    public List<Map<String, Object>> getContentSubAll(Map map) {
        return this.xmProgressMapper.selectSubTaskDynamic(map);
    }

    @Override
    public int getDynamicCounts(Map map) {
        return this.xmProgressMapper.selectDistinctTaskAllDynamicCounts(map);
    }

    @Override
    public int getDynamicSubCounts(Map map) {
        return this.xmProgressMapper.selectSubTaskDynamicCounts(map);
    }

    @Override
    public int getContentAdd(XmProgress xmProgress) {
        return  this.xmProgressMapper.insert(xmProgress);
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
    public int getContentReply(XmProgressReply xmProgressReply) {
        return this.xmProgressReplyMapper.insertReply(xmProgressReply);
    }

    @Override
    public String getOrganization(Integer organization_id) {
        return this.xmProgressMapper.getOrganization(organization_id);
    }

    @Override
    public String getProjectName(Integer project_id) {
        return this.xmProjectMapper.getProjectName(project_id);
    }

    @Override
    public String getSchoolName(Integer school_id) {
        return this.xmTaskMapper.getOrganizationName(school_id);
    }

    @Override
    public String getUserName(Integer user_id) {
        return this.xmTaskMapper.getUserName(user_id);
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
    public Integer getProgressReplyNum(Integer progress_id) {
        return this.xmProgressReplyMapper.getProgressReplyNum(progress_id);
    }

    @Override
    public List<XmProgressReply> getProgressReply(Map map) {
        return this.xmProgressReplyMapper.getProgressReply(map);
    }

    @Override
    public int upLoadFile(XmProjectFile xmProjectFile) {
        return this.xmProjectFileMapper.upLoadFile(xmProjectFile);
    }

    @Override
    public List<XmProjectFile> getFileListAndStatus(Integer taskId,Integer organizationId) {
        return this.xmProjectFileMapper.getFileListAndStatus(taskId,organizationId);
    }

    @Override
    public int deleteFile(Integer fileId) {
        return this.xmProjectFileMapper.deleteByPrimaryKey(fileId);
    }


    @Override
    public int changeStatus(XmProjectFile xmProjectFile) {
        return this.xmProjectFileMapper.changeStatus(xmProjectFile);
    }

    @Override
    public List<XM0209A14DTO> getSubordinateOrganizationName(Integer organization_id) {
        return this.xmProgressMapper.getSubordinateSchoolName(organization_id);
    }

    @Override
    public int setFinishTask(Integer task_id) {
        return this.xmTaskMapper.setFinishTask(task_id);
    }

    @Override
    public int setFinishNULL(Integer task_id) {
        return this.xmTaskMapper.setFinishNULL(task_id);
    }


    @Override
    public int distinctsAllNum(Integer task_id) {
        return this.xmTaskMapper.distinctsAllNum(task_id);
    }

    @Override
    public int distinctsAllFinishNum(Integer task_id) {
        return this.xmTaskMapper.distinctsAllFinishNum(task_id);
    }

    @Override
    public Integer getSuperiorTaskId(int taskId) {
        return this.xmTaskMapper.getSuperiorTaskId(taskId);
    }

}
