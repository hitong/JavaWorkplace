package org.ec.xm.service.impl;

import org.ec.xm.dao.mapper.XmTaskMapper;
import org.ec.xm.dto.XM0206.XM0206A08DTO;
import org.ec.xm.dto.XM0208.*;
import org.ec.xm.entity.XmTask;
import org.ec.xm.service.XM0208Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * XM0208: 项目执行 - 任务管理(区县)（任务管理(区县)页面）
 * 作者：
 * 日期：
 */
@Component
@Transactional
public class XM0208ServiceImpl implements XM0208Service {
    private final XmTaskMapper xmTaskMapper;

    @Autowired
    public XM0208ServiceImpl(XmTaskMapper xmTaskMapper) {
        this.xmTaskMapper = xmTaskMapper;
    }

    @Override
    public java.lang.String getName(int id) {
        return this.xmTaskMapper.getName(id);
    }

    @Override
    public Integer getUpOrganizationId(int id) {
        return this.xmTaskMapper.getUpOrganizationId(id);
    }

    @Override
    public String getChargeManName(int organizationId) {
        return this.xmTaskMapper.getChargeManName(organizationId);
    }

    @Override
    public int distribTask(int projectId, String name, String type, Date beginAt, Date finishAt, int enable,
                           String remark, String status, int dataTemplateId,
                           int superiorOrganizationId, int superTaskId, int organizationId) {
        return this.xmTaskMapper.distribTask(projectId, name, type, beginAt, finishAt, enable,
                                                remark, status, dataTemplateId,
                                                superiorOrganizationId, superTaskId, organizationId);
    }

    @Override
    public XmTask selectByPrimaryKey(Integer id) {
        return this.xmTaskMapper.selectByPrimaryKey(id);
    }

    @Override
    public int setDistrib(int taskId) {
        return this.xmTaskMapper.setDistrib(taskId);
    }

    @Override
    public List<XM0208A01DTO> getAllAreaTask(int organization) {
        return this.xmTaskMapper.getAllAreaTask(organization);
    }

    @Override
    public List<XM0208A07DTO> getAreaSelectTree(int organizationId) {
        return this.xmTaskMapper.getAreaSelectTree(organizationId);
    }

    @Override
    public List<XM0208A08DTO> getAreaProjectTask(int organizationId, int projectId) {
        return this.xmTaskMapper.getAreaProjectTask(organizationId, projectId);
    }

    @Override
    public List<XM0208A09DTO> getAreaYearTask(int organizationId, String year) {
        return this.xmTaskMapper.getAreaYearTask(organizationId, year);
    }

    @Override
    public List<XM0208A03DTO> getAreaLowOrganization(int taskId, int organizationId) {
        return this.xmTaskMapper.getAreaLowOrganization(taskId, organizationId);
    }

    @Override
    public List<XM0208A04DTO> getAreaSearchTask(int organization, String keyWord) {
        return this.xmTaskMapper.getAreaSearchTask(organization, "%" + keyWord + "%");
    }

    @Override
    public Double getProjectMoney(int projectId, int organizationId) {
        return xmTaskMapper.getProjectMoney(projectId, organizationId);
    }

    @Override
    public Double getTaskMoney(int projectId, int organizationId) {
        return xmTaskMapper.getTaskMoney(projectId, organizationId);
    }

    @Override
    public List<XM0208A05DTO> getAreaSuperiorFile(int taskId, int organizationId) {
        return xmTaskMapper.getAreaSuperiorFile(taskId, organizationId);
    }

    @Override
    public List<XM0208A06DTO> getAreaFile(int taskId, int organizationId) {
        return xmTaskMapper.getAreaFile(taskId, organizationId);
    }

    @Override
    public Integer getSuperiorTaskId(int taskId) {
        return xmTaskMapper.getSuperiorTaskId(taskId);
    }

    @Override
    public List<XM0208A05DTO> getAreaFundingFile(int taskId) {
        return xmTaskMapper.getAreaFundingFile(taskId);
    }

    @Override
    public int cancleDistrib(int taskId) {
        return xmTaskMapper.cancleDistrib(taskId);
    }

    @Override
    public List<Integer> getDistribedTaskid(int taskId) {
        return xmTaskMapper.getDistribedTaskid(taskId);
    }

    @Override
    public int deleteFileByTaskId(int taskId) {
        return xmTaskMapper.deleteFileByTaskId(taskId);
    }

    @Override
    public int deleteProgressByTaskId(int taskId) {
        return xmTaskMapper.deleteProgressByTaskId(taskId);
    }

    @Override
    public int deleteProgressReplyByTaskId(int taskId) {
        return xmTaskMapper.deleteProgressReplyByTaskId(taskId);
    }

    @Override
    public int setNotDistrib(int taskId) {
        return xmTaskMapper.setNotDistrib(taskId);
    }

    @Override
    public List<XM0208A10DTO> getAreaReturnTasks(int organizationId) {
        return xmTaskMapper.getAreaReturnTasks(organizationId);
    }

    @Override
    public List<XM0208A10DTO> getAreaUrgedTasks(int organizationId) {
        return xmTaskMapper.getAreaUrgedTasks(organizationId);
    }
}
