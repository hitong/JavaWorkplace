package org.ec.xm.entity;

import java.util.Date;

public class XmFunding {
    private Integer id;

    private Integer projectId;

    private Integer creatorId;

    private Integer organizationId;

    private Date createdAt;

    private Date updatedAt;

    public XmFunding(Integer id, Integer projectId, Integer creatorId, Integer organizationId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.projectId = projectId;
        this.creatorId = creatorId;
        this.organizationId = organizationId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public XmFunding() {
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

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
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