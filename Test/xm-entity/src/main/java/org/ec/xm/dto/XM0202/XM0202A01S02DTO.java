package org.ec.xm.dto.XM0202;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0202/A01 项目数据获取+查询框: 项目配置
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0202A01S02DTO extends ResponseDTO {

    /**
     * 模板ID
     */
    private Integer dataTemplateId;

    /**
     * 定时任务-任务类型
     */
    private String timedTaskType;

    /**
     * 项目配置ID
     */
    private Integer projectConfigId;

    private Integer timingTaskId;
    /**
     * 获取 模板ID
     * @return dataTemplateId 模板ID
     */
    public XM0202A01S02DTO(){}
    public Integer getDatatemplateid() {
        return dataTemplateId;
    }

    /**
     * 设置 模板ID
     * @param dataTemplateId 模板ID
     */
    public void setDatatemplateid(Integer dataTemplateId) {
        this.dataTemplateId = dataTemplateId;
    }

    /**
     * 获取 定时任务-任务类型
     * @return timedTaskType 定时任务-任务类型
     */
    public String getTimedtasktype() {
        return timedTaskType;
    }

    /**
     * 设置 定时任务-任务类型
     * @param timedTaskType 定时任务-任务类型
     */
    public void setTimedtasktype(String timedTaskType) {
        this.timedTaskType = timedTaskType;
    }

    /**
     * 获取 项目配置ID
     * @return projectConfigId 项目配置ID
     */
    public Integer getProjectConfigId() {
        return projectConfigId;
    }

    /**
     * 设置 项目配置ID
     * @param projectConfigId 项目配置ID
     */
    public void setProjectConfigId(Integer projectConfigId) {
        this.projectConfigId = projectConfigId;
    }

    public Integer getTimingTaskId() {
        return timingTaskId;
    }

    public void setTimingTaskId(Integer timingTaskId) {
        this.timingTaskId = timingTaskId;
    }
}
