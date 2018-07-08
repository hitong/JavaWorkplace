package org.ec.xm.entity;

import java.util.Date;

public class XmProjectConfig {
    private Integer id;

    private String timedTaskType;

    private Integer dataTemplateId;

    private Integer projectId;

    private Date createdAt;

    private Date updatedAt;

    private Integer timingTaskId;

    public XmProjectConfig(Integer id, String timedTaskType, Integer dataTemplateId, Integer projectId, Date createdAt, Date updatedAt, Integer timingTaskId) {
        this.id = id;
        this.timedTaskType = timedTaskType;
        this.dataTemplateId = dataTemplateId;
        this.projectId = projectId;
        this.createdAt = createdAt;

        this.updatedAt = updatedAt;
        this.timingTaskId = timingTaskId;
    }

    public XmProjectConfig() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimedTaskType() {
        return timedTaskType;
    }

    public void setTimedTaskType(String timedTaskType) {
        this.timedTaskType = timedTaskType == null ? null : timedTaskType.trim();
    }

    public Integer getDataTemplateId() {
        return dataTemplateId;
    }

    public void setDataTemplateId(Integer dataTemplateId) {
        this.dataTemplateId = dataTemplateId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getTimingTaskId() {
        return timingTaskId;
    }

    public void setTimingTaskId(Integer timingTaskId) {
        this.timingTaskId = timingTaskId;
    }
}