package org.ec.xm.entity;

import java.util.Date;

public class XmProgress {
    private Integer id;

    private Integer organizationId;

    private Integer userId;

    private Integer taskId;

    private Date createdAt;

    private Date updatedAt;

    private String content;

    public XmProgress(Integer id, Integer organizationId, Integer userId, Integer taskId, Date createdAt, Date updatedAt, String content) {
        this.id = id;
        this.organizationId = organizationId;
        this.userId = userId;
        this.taskId = taskId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.content = content;
    }

    public XmProgress() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}