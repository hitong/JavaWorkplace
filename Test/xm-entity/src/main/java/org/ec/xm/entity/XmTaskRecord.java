package org.ec.xm.entity;

import java.util.Date;

public class XmTaskRecord {
    private Integer id;

    private Integer taskId;

    private Integer organizationId;

    private Date returnedAt;

    private Date urgedAt;

    private Integer recordmanId;

    private Date createdAt;

    private Date updatedAt;

    public XmTaskRecord(Integer id, Integer taskId, Integer organizationId, Date returnedAt, Date urgedAt, Integer recordmanId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.taskId = taskId;
        this.organizationId = organizationId;
        this.returnedAt = returnedAt;
        this.urgedAt = urgedAt;
        this.recordmanId = recordmanId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public XmTaskRecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Date getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(Date returnedAt) {
        this.returnedAt = returnedAt;
    }

    public Date getUrgedAt() {
        return urgedAt;
    }

    public void setUrgedAt(Date urgedAt) {
        this.urgedAt = urgedAt;
    }

    public Integer getRecordmanId() {
        return recordmanId;
    }

    public void setRecordmanId(Integer recordmanId) {
        this.recordmanId = recordmanId;
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
}