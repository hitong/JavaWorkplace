package org.ec.xm.entity;

import java.util.Date;

public class XmProgressReply {
    private Integer id;

    private Integer organizationId;

    private Integer replymanId;

    private Integer progressId;

    private Integer taskId;

    private Date createdAt;

    private Date updatedAt;

    private String content;

    public XmProgressReply(Integer id, Integer organizationId, Integer replymanId, Integer progressId, Integer taskId, Date createdAt, Date updatedAt, String content) {
        this.id = id;
        this.organizationId = organizationId;
        this.replymanId = replymanId;
        this.progressId = progressId;
        this.taskId = taskId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.content = content;
    }

    public XmProgressReply() {
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

    public Integer getReplymanId() {
        return replymanId;
    }

    public void setReplymanId(Integer replymanId) {
        this.replymanId = replymanId;
    }

    public Integer getProgressId() {
        return progressId;
    }

    public void setProgressId(Integer progressId) {
        this.progressId = progressId;
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