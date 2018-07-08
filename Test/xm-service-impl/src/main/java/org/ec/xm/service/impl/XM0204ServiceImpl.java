package org.ec.xm.service.impl;

import org.ec.xm.dao.mapper.XmTaskMapper;
import org.ec.xm.dto.XM0204.*;
import org.ec.xm.entity.XmTask;
import org.ec.xm.service.XM0204Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * XM0204: 项目执行 - 任务管理（任务管理页面）
 * 作者：
 * 日期：
 */
@Component
@Transactional
public class XM0204ServiceImpl implements XM0204Service {
    private final XmTaskMapper xmTaskMapper;

    @Autowired
    public XM0204ServiceImpl(XmTaskMapper xmTaskMapper) {
        this.xmTaskMapper = xmTaskMapper;
    }

    @Override
    public String getName(int id) {
        return xmTaskMapper.getName(id);
    }

    @Override
    public List<XM0204A08DTO> getCityLowOrganization(int taskId, int organizationId) {
        return xmTaskMapper.getCityLowOrganization(taskId, organizationId);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return xmTaskMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<XM0204A10DTO> getAllProject() {
        return xmTaskMapper.getAllProject();
    }

    @Override
    public int insert(XmTask record) {
        return xmTaskMapper.insert(record);
    }

    @Override
    public int enableTask(int taskId) {
        return xmTaskMapper.enableTask(taskId);
    }

    @Override
    public int editTask(XmTask xmTask) {
        return xmTaskMapper.editTask(xmTask);
    }

    @Override
    public int cancleDistrib(int taskId) {
        return xmTaskMapper.cancleDistrib(taskId);
    }

    @Override
    public int disable(int taskId) {
        return xmTaskMapper.disable(taskId);
    }

    @Override
    public int setDistrib(int taskId) {
        return xmTaskMapper.setDistrib(taskId);
    }

    @Override
    public int setNotDistrib(int taskId) {
        return xmTaskMapper.setNotDistrib(taskId);
    }

    @Override
    public XmTask selectByPrimaryKey(Integer id) {
        return xmTaskMapper.selectByPrimaryKey(id);
    }

    @Override
    public int distribTask(int projectId, String name, String type, Date beginAt, Date finishAt, int enable, String remark, String status, int dataTemplateId, int superiorOrganizationId, int superTaskId, int organizationId) {
        return xmTaskMapper.distribTask(projectId, name, type, beginAt, finishAt, enable,
                                          remark, status, dataTemplateId,
                                          superiorOrganizationId, superTaskId, organizationId);
    }

    @Override
    public List<XM0204A01DTO> getAllCityTask(int organization) {
        return xmTaskMapper.getAllCityTask(organization);
    }

    @Override
    public List<XM0204A06DTO> getCitySelectTree(int orgnizationId) {
        return xmTaskMapper.getCitySelectTree(orgnizationId);
    }

    @Override
    public List<XM0204A07DTO> getCityProjectTask(int organizationId, int projectId, String keyword) {
        return xmTaskMapper.getCityProjectTask(organizationId, projectId,keyword);
    }

    @Override
    public List<XM0204A13DTO> getCityYearTask(int organizationId, String year) {
        return xmTaskMapper.getCityYearTask(organizationId, year);
    }

    @Override
    public List<XM0204A05DTO> getCitySearchTask(int organization, String keyWord) {
        return xmTaskMapper.getCitySearchTask(organization, "%" + keyWord + "%");
    }

    @Override
    public Double getProjectMoney(int projectId, int organizationId) {
        return xmTaskMapper.getProjectMoney(projectId, organizationId);
    }

    @Override
    public List<Integer> getDistribedTaskid(int organizationId) {
        return xmTaskMapper.getDistribedTaskid(organizationId);
    }

    @Override
    public int disableLowTask(int taskId) {
        return xmTaskMapper.disableLowTask(taskId);
    }

    @Override
    public int deleteFileByTaskId(int taskId) {
        return xmTaskMapper.deleteFileByTaskId(taskId);
    }

    @Override
    public int enableLowTask(int taskId) {
        return xmTaskMapper.enableLowTask(taskId);
    }

    @Override
    public Integer[] getAllOrganizationId() {
        return xmTaskMapper.getAllOrganizationId();
    }

    @Override
    public int deleteProgressByTaskId(int taskId) {
        return this.xmTaskMapper.deleteProgressByTaskId(taskId);
    }

    @Override
    public int deleteProgressReplyByTaskId(int taskId) {
        return this.xmTaskMapper.deleteProgressReplyByTaskId(taskId);
    }
}
