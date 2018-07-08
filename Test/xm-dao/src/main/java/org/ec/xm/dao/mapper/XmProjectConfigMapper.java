package org.ec.xm.dao.mapper;

import java.util.List;

import org.ec.xm.dto.XM0203.XM0203A12DTO;
import org.ec.xm.entity.XmProjectConfig;

public interface XmProjectConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XmProjectConfig record);

    XmProjectConfig selectByPrimaryKey(Integer id);

    List<XmProjectConfig> selectAll();

    int updateByPrimaryKey(XmProjectConfig record);

    Integer deleteFromProjectConfig(Integer id);

    List<XM0203A12DTO> getAllOrganization(Integer id);

    List<XM0203A12DTO> getAllOrganization1(Integer id);

    Object getParentId(Integer id);

    Integer[] getAllTimingTaskId(Integer id);
}