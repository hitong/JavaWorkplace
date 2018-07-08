package org.ec.xm.entity;

import java.util.Date;

public class XmTask {
    private Integer id;

    private Integer projectId;

    private String name;

    private String type;

    private Date beginAt;

    private Date finishAt;

    private Boolean enable;

    private Integer projectConfigId;

    private String status;

    private Integer dataTemplateId;

    private Integer createdOrganizationId;

    private Integer superiorOrganizationId;

    private Integer organizationId;

    private Integer returnmanId;

    private Date returnedAt;

    private Integer urgemanId;

    private Date urgedAt;

    private String taskMode;

    private Integer superiorTaskId;

    private Date createdAt;

    private Date updatedAt;

    private String remark;

    public XmTask(Integer id, Integer projectId, String name, String type, Date beginAt, Date finishAt, Boolean enable, Integer projectConfigId, String status, Integer dataTemplateId, Integer createdOrganizationId, Integer superiorOrganizationId, Integer organizationId, Integer returnmanId, Date returnedAt, Integer urgemanId, Date urgedAt, String taskMode, Integer superiorTaskId, Date createdAt, Date updatedAt, String remark) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.type = type;
        this.beginAt = beginAt;
        this.finishAt = finishAt;
        this.enable = enable;
        this.projectConfigId = projectConfigId;
        this.status = status;
        this.dataTemplateId = dataTemplateId;
        this.createdOrganizationId = createdOrganizationId;
        this.superiorOrganizationId = superiorOrganizationId;
        this.organizationId = organizationId;
        this.returnmanId = returnmanId;
        this.returnedAt = returnedAt;
        this.urgemanId = urgemanId;
        this.urgedAt = urgedAt;
        this.taskMode = taskMode;
        this.superiorTaskId = superiorTaskId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.remark = remark;
    }

    public XmTask() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getBeginAt() {
        return beginAt;
    }

    public void setBeginAt(Date beginAt) {
        this.beginAt = beginAt;
    }

    public Date getFinishAt() {
        return finishAt;
    }

    public void setFinishAt(Date finishAt) {
        this.finishAt = finishAt;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Integer getProjectConfigId() {
        return projectConfigId;
    }

    public void setProjectConfigId(Integer projectConfigId) {
        this.projectConfigId = projectConfigId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getDataTemplateId() {
        return dataTemplateId;
    }

    public void setDataTemplateId(Integer dataTemplateId) {
        this.dataTemplateId = dataTemplateId;
    }

    public Integer getCreatedOrganizationId() {
        return createdOrganizationId;
    }

    public void setCreatedOrganizationId(Integer createdOrganizationId) {
        this.createdOrganizationId = createdOrganizationId;
    }

    public Integer getSuperiorOrganizationId() {
        return superiorOrganizationId;
    }

    public void setSuperiorOrganizationId(Integer superiorOrganizationId) {
        this.superiorOrganizationId = superiorOrganizationId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getReturnmanId() {
        return returnmanId;
    }

    public void setReturnmanId(Integer returnmanId) {
        this.returnmanId = returnmanId;
    }

    public Date getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(Date returnedAt) {
        this.returnedAt = returnedAt;
    }

    public Integer getUrgemanId() {
        return urgemanId;
    }

    public void setUrgemanId(Integer urgemanId) {
        this.urgemanId = urgemanId;
    }

    public Date getUrgedAt() {
        return urgedAt;
    }

    public void setUrgedAt(Date urgedAt) {
        this.urgedAt = urgedAt;
    }

    public String getTaskMode() {
        return taskMode;
    }

    public void setTaskMode(String taskMode) {
        this.taskMode = taskMode == null ? null : taskMode.trim();
    }

    public Integer getSuperiorTaskId() {
        return superiorTaskId;
    }

    public void setSuperiorTaskId(Integer superiorTaskId) {
        this.superiorTaskId = superiorTaskId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}