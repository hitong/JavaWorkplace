package org.ec.xm.dao.mapper;

import java.util.List;
import java.util.Map;

import org.ec.xm.dto.XM0205.XM0205A11DTO;
import org.ec.xm.dto.XM0209.XM0209A14DTO;
import org.ec.xm.entity.XmProgress;

public interface XmProgressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XmProgress record);

    XmProgress selectByPrimaryKey(Integer id);

    List<XmProgress> selectAll();

    int updateByPrimaryKey(XmProgress record);

    XmProgress selectTaskId(Integer task_id);

    List<Map<String,Object>> selectProgressByTaskId(Map map);

    //获取动态全部内容
    List<Map<String,Object>> selectAllByTaskId(Map map);

    //获取动态全部内容 上级和下级
    List<Map<String,Object>> selectTaskAllDynamic(Map map);
    List<Map<String,Object>> selectTaskDynamicLimit5(Map map);
    //获取动态全部内容 上级和下级数量
    int selectTaskAllDynamicCounts(Map map);

    //获取动态全部内容 市级、区县、学校
    List<Map<String,Object>> selectDistinctTaskAllDynamic(Map map);
    List<Map<String,Object>> selectDistinctTaskDynamicLimit5(Map map);
    //获取动态全部内容 市级、区县、学校
    int selectDistinctTaskAllDynamicCounts(Map map);





    //获取下级内容
    List<Map<String,Object>> selectSubTaskDynamic(Map map);
    //获取下级数量
    int selectSubTaskDynamicCounts(Map map);



    //获取下级组织的动态全部内容
    List<Map<String,Object>> selectSubAllByTaskId(Map map);

    //获取相应组织下的内容
    List<Map<String,Object>> selectAllByOrganizationTaskId(Map map);
    //获取动态信息数量
    int getDynamicCounts(Map map);
    //获取动态信息数量
    int getDynamicSubCounts(Integer task_id);

    //获取单位名称
    String getOrganization(Integer organization_id);
    //获取用户名称
    String getProgressUserName(Integer user_id);

    Integer delteFromProgress(Integer id);

    //获取下级区县名称
    List<XM0205A11DTO> getSubordinateName(Integer organization_id);
    //获取下级学校名称
    List<XM0209A14DTO> getSubordinateSchoolName(Integer organization_id);
}