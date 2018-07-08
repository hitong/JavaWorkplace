package org.ec.xm.entity;

import java.util.Date;

public class XmProjectFile {
    private Integer id;

    private Integer size;

    private String name;

    private String type;

    private String path;

    private Integer organizationId;

    private Integer taskId;

    private Byte status;

    private String source;

    private Integer creatorId;

    private Integer fundingId;

    private Date createdAt;

    private Date updatedAt;

    public XmProjectFile(Integer id, Integer size, String name, String type, String path, Integer organizationId, Integer taskId, Byte status, String source, Integer creatorId, Integer fundingId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.size = size;
        this.name = name;
        this.type = type;
        this.path = path;
        this.organizationId = organizationId;
        this.taskId = taskId;
        this.status = status;
        this.source = source;
        this.creatorId = creatorId;
        this.fundingId = fundingId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public XmProjectFile() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getFundingId() {
        return fundingId;
    }

    public void setFundingId(Integer fundingId) {
        this.fundingId = fundingId;
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