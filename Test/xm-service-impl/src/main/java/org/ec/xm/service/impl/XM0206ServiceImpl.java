package org.ec.xm.service.impl;

import org.ec.xm.dao.mapper.XmTaskMapper;
import org.ec.xm.dto.XM0206.*;
import org.ec.xm.service.XM0206Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * XM0206: 项目执行 - 任务管理(学校)（任务管理(学校)页面）
 * 作者：
 * 日期：
 */
@Component
@Transactional
public class XM0206ServiceImpl implements XM0206Service {

    private final XmTaskMapper xmTaskMapper;

    @Autowired
    public XM0206ServiceImpl(XmTaskMapper xmTaskMapper) {
        this.xmTaskMapper = xmTaskMapper;
    }

    @Override
    public String getName(int id) {
        return this.xmTaskMapper.getName(id);
    }

    @Override
    public Integer getUpOrganizationId(int id) {
        return this.xmTaskMapper.getUpOrganizationId(id);
    }

    @Override
    public List<XM0206A03DTO> getFileSchool(int taskId, int organizationId) {
        return this.xmTaskMapper.getFileSchool(taskId, organizationId);
    }

    @Override
    public List<XM0206A01DTO> getAllSchoolTask(int organization) {
        return this.xmTaskMapper.getAllSchoolTask(organization);
    }

    @Override
    public List<XM0206A05DTO> getSchoolSelectTree(int organizationId) {
        return this.xmTaskMapper.getSchoolSelectTree(organizationId);
    }

    @Override
    public List<XM0206A06DTO> getSchoolProjectTask(int organizationId, int projectId) {
        return this.xmTaskMapper.getSchoolProjectTask(organizationId, projectId);
    }

    @Override
    public List<XM0206A07DTO> getSchoolYearTask(int organizationId, String year) {
        return this.xmTaskMapper.getSchoolYearTask(organizationId, year);
    }

    @Override
    public List<XM0206A02DTO> getSchoolSearchTask(int organization, String keyWord) {
        return this.xmTaskMapper.getSchoolSearchTask(organization, "%" + keyWord + "%");
    }

    @Override
    public Double getTaskMoney(int projectId, int organizationId) {
        return this.xmTaskMapper.getTaskMoney(projectId, organizationId);
    }

    @Override
    public List<XM0206A04DTO> getSchoolSuperiorFile(int taskId, int organizationId) {
        return this.xmTaskMapper.getSchoolSuperiorFile(taskId, organizationId);
    }

    @Override
    public List<XM0206A03DTO> getSchoolFile(int taskId, int organizitionId) {
        return this.xmTaskMapper.getSchoolFile(taskId, organizitionId);
    }

    @Override
    public List<XM0206A04DTO> getSchoolFundingFile(int taskId) {
        return xmTaskMapper.getSchoolFundingFile(taskId);
    }

    @Override
    public Integer getSuperiorTaskId(int taskId) {
        return this.xmTaskMapper.getSuperiorTaskId(taskId);
    }

    @Override
    public List<XM0206A08DTO> getSchoolReturnTasks(int organizationId) {
        return this.xmTaskMapper.getSchoolReturnTasks(organizationId);
    }

    @Override
    public List<XM0206A08DTO> getSchoolUrgedTasks(int organizationId) {
        return this.xmTaskMapper.getSchoolUrgedTasks(organizationId);
    }
}
