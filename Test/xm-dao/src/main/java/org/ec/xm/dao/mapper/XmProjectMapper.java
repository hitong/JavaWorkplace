package org.ec.xm.dao.mapper;

import java.util.List;

import java.util.Map;

import org.ec.xm.dto.XM0202.*;
import org.ec.xm.dto.XM0203.XM0203A01DTO;
import org.ec.xm.dto.XM0203.XM0203A01InputDTO;
import org.ec.xm.dto.XM0203.XM0203A02DTO;
import org.ec.xm.dto.XM0210.XM0210A01S01DTO;
import org.ec.xm.dto.XM0210.XM0210A13DTO;
import org.ec.xm.entity.XmProject;

public interface XmProjectMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(XmProject record);
    XmProject selectByPrimaryKey(Integer id);
    List<XmProject> selectAll();
    int updateByPrimaryKey(XmProject record);
    int addProject(XM0202A03InputDTO xm0202A03InputDTO);
    int addConfig(String timedTaskType,Integer dataTemplateId,Integer projectId,Integer timingTaskId);
    List<XM0202A01S01DTO> selectAllById(String keyword,Integer organaziton_id);
    List<XM0202A02DTO> getAllYears(Integer id);
    List<XM0202A02S01DTO> getProjectNameByYear(String year);
    XM0203A02DTO getProjectDetailById(Integer id);
    List<XM0210A13DTO> getAllYears1(Integer id);
    List<XM0210A01S01DTO> selectAllById1(String keyword, Integer organaziton_id);
    int updataByProjectId(XM0202A06InputDTO input);
    int updateConfigById(XM0202A01S02DTO input);
    int deleteByProjectId(Integer id);
    int sureProject(Integer id);
    Integer deleteFromProject(Integer id);
    //获取项目名称
    String getProjectName(Integer organization_id);
    int updateProjectConfigById(XM0202A01S02DTO input);
    Integer[] selectAllConfigIdByProjectId(Integer id);
}