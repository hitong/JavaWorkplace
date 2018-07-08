package org.ec.xm.dao.mapper;

import java.util.List;
import java.util.Map;
import java.util.Date;

import io.swagger.models.auth.In;
import org.ec.xm.dto.XM0201.XM0201A01DTO;
import org.ec.xm.dto.XM0201.XM0201A02DTO;
import org.ec.xm.dto.XM0204.*;
import org.ec.xm.dto.XM0203.XM0203A01DTO;
import org.ec.xm.dto.XM0203.XM0203A01InputDTO;
import org.ec.xm.dto.XM0206.*;
import org.ec.xm.dto.XM0208.*;
import org.ec.xm.entity.XmProject;

import org.ec.xm.entity.XmTask;

public interface XmTaskMapper {

    //获取任务管理情况
    List<XM0201A01DTO> getTasksInfo(Integer organizationId);

    //获取五条退回任务
    List<XM0201A02DTO> getReturnTask(Integer organizationId);

    //获取五条催报任务
    List<XM0201A02DTO> getUrgeTask(Integer organizationId);

    //通过项目id获取项目名称
    String getName(int id);

    //根据任务id获取上级组织id
    Integer getUpOrganizationId(int id);

    //获取组织负责人姓名
    String getChargeManName(int organizationId);

    //将任务下发给组织
    int distribTask(int projectId, String name, String type, Date beginAt, Date finishAt, int enable, String remark,
                    String status, int dataTemplateId, int superiorOrganizationId, int superTaskId, int organizationId);

    //将任务的状态设置为执行中
    int setDistrib(int taskId);

    //将任务状态设置为待下发
    int setNotDistrib(int taskId);

    //删除任务
    int deleteByPrimaryKey(Integer id);

    //增加任务
    int insert(XmTask record);

    //通过任务ID查询任务
    XmTask selectByPrimaryKey(Integer id);

    //返回所有任务
    List<XmTask> selectAll();

    //更新任务
    int updateByPrimaryKey(XmTask record);

    //修改任务
    int editTask(XmTask xmTask);

    List<Map<String, Object>> selectSchoolTaskByMap(Map map);

    List<Map<String, Object>> selectOrganizationTaskByMap(Map map);

    int getAllCounts(Map map);


    //查询学校的任务
    XmTask selectsubTasktByTaskId(Integer task_id);

    //更新退回
    int updateReturn(XmTask xmTask);

    //更新退回状态
    int updateReturnStatus(XmTask xmTask);

    //更新催报
    int updateUrge(XmTask xmTask);

    //根据组织id和任务id获取文件信息--学校
    List<XM0206A03DTO> getFileSchool(int taskId, int organizationId);

    //获取所有任务
    List<XM0204A10DTO> getAllProject();

    //启用任务
    int enableTask(int taskId);

    //启用下级任务
    int enableLowTask(int taskId);

    //取消下发
    int cancleDistrib(int taskId);

    //禁用任务
    int disable(int taskId);

    //禁用下级任务
    int disableLowTask(int taskId);

    //获取市级教委任务
    List<XM0204A01DTO> getAllCityTask(int organization);

    //获取区县教委任务
    List<XM0208A01DTO> getAllAreaTask(int organization);

    //获取学校任务
    List<XM0206A01DTO> getAllSchoolTask(int organization);

    //获取市级教委查询任务结果
    List<XM0204A05DTO> getCitySearchTask(int organization, String keyWord);

    //获取区县教委查询任务结果
    List<XM0208A04DTO> getAreaSearchTask(int organization, String keyWord);

    //获取学校查询任务结果
    List<XM0206A02DTO> getSchoolSearchTask(int organization, String keyWord);

    //获取市级教委筛选树
    List<XM0204A06DTO> getCitySelectTree(int orgnizationId);

    //获取区县教委筛选树
    List<XM0208A07DTO> getAreaSelectTree(int organizationId);

    //获取学校筛选树
    List<XM0206A05DTO> getSchoolSelectTree(int organizationId);

    //获取市级教委一个项目的任务
    List<XM0204A07DTO> getCityProjectTask(int organizationId, int projectId,String keyword);

    //获取区县教委一个项目的任务
    List<XM0208A08DTO> getAreaProjectTask(int organizationId, int projectId);

    //获取学校一个项目的任务
    List<XM0206A06DTO> getSchoolProjectTask(int organizationId, int projectId);

    //获取市级教委年份任务
    List<XM0204A13DTO> getCityYearTask(int organizationId, String year);

    //获取区县教委年份任务
    List<XM0208A09DTO> getAreaYearTask(int organizationId, String year);

    //获取学校年份任务
    List<XM0206A07DTO> getSchoolYearTask(int organizationId, String year);

    //获取区级被退回的任务
    List<XM0208A10DTO> getAreaReturnTasks(int organizationId);

    //获取学校被退回的任务
    List<XM0206A08DTO> getSchoolReturnTasks(int organizationId);

    //获取区级被催报的任务
    List<XM0208A10DTO> getAreaUrgedTasks(int organizationId);

    //获取学校被催报的任务
    List<XM0206A08DTO> getSchoolUrgedTasks(int organizationId);

    //获取市级教委下级组织
    List<XM0204A08DTO> getCityLowOrganization(int taskId, int organizationId);

    //获取区县教委下级组织
    List<XM0208A03DTO> getAreaLowOrganization(int taskId, int organizationId);

    //获取区县上级文件信息
    List<XM0208A05DTO> getAreaSuperiorFile(int taskId, int organizationId);

    //获取区县资金下发文件
    List<XM0208A05DTO> getAreaFundingFile(int taskId);

    //获取区县文件信息
    List<XM0208A06DTO> getAreaFile(int taskId, int organizationId);

    //获取学校上级文件信息
    List<XM0206A04DTO> getSchoolSuperiorFile(int taskId, int organizationId);

    //获取学校的资金下达文件信息
    List<XM0206A04DTO> getSchoolFundingFile(int taskId);

    //获取学校文件信息
    List<XM0206A03DTO> getSchoolFile(int taskId,int organizitionId);

    //获取项目资金
    Double getProjectMoney(int projectId, int organizationId);

    //获取任务资金
    Double getTaskMoney(int projectId, int organizationId);

    //获取某个任务下发产生的任务的任务id
    List<Integer> getDistribedTaskid(int taskId);

    //获取某个任务的上级任务id
    Integer getSuperiorTaskId(int taskId);

    //删除某个任务所上传的文件
    int deleteFileByTaskId(int taskId);

    //删除某个任务的进度
    int deleteProgressByTaskId(int taskId);

    //删除某个回复
    int deleteProgressReplyByTaskId(int taskId);

    List<XM0203A01DTO> getTaskListXX(XM0203A01InputDTO input);

    Integer[] getAllTaskId(Integer id);

    Integer deleteFromTask(Integer id);

    //获取组织名称
    String getOrganizationName(Integer school_id);

    //获取用户名称
    String getUserName(Integer school_id);

    //将任务设置为已完成
    int setFinishTask(int taskId);
    //已完成将退回人催报人置空
    int setFinishNULL(int taskId);


    /*//将区县上级组织市委任务设置为已完成
    int setOrganizationFinishTask(int taskId);*/

    //获取下级组织ID
    Integer[] getAllOrganizationId();

    //获取该任务同级的所有区县数量
    int distinctsAllNum(int taskId);

    //获取该任务同级的所有区县执行完成数量
    int distinctsAllFinishNum(int taskId);


}