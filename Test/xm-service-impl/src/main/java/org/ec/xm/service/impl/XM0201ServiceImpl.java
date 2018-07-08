package org.ec.xm.service.impl;

import org.ec.xm.dao.mapper.XmTaskMapper;
import org.ec.xm.dto.XM0201.XM0201A01DTO;
import org.ec.xm.dto.XM0201.XM0201A02DTO;
import org.ec.xm.service.XM0201Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * XM0201: 项目执行 - 项目管理（首页）
 * 作者：
 * 日期：
 */
@Component
@Transactional
public class XM0201ServiceImpl implements XM0201Service {

    private final XmTaskMapper xmTaskMapper;

    @Autowired
    public XM0201ServiceImpl(XmTaskMapper xmTaskMapper) {
        this.xmTaskMapper = xmTaskMapper;
    }

    @Override
    public List<XM0201A01DTO> getTasksInfo(Integer organizationId) {
        return this.xmTaskMapper.getTasksInfo(organizationId);
    }

    @Override
    public List<XM0201A02DTO> getReturnTask(Integer organizationId) {
        return this.xmTaskMapper.getReturnTask(organizationId);
    }

    @Override
    public List<XM0201A02DTO> getUrgeTask(Integer organizationId) {
        return this.xmTaskMapper.getUrgeTask(organizationId);
    }
}
