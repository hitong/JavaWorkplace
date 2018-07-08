package org.ec.xm.entity;

import java.util.Date;

public class XmMoneySource {
    private Integer id;

    private Integer projectId;

    private Integer creatorId;

    private String source;

    private Double money;

    private Integer organizationId;

    private Date createdAt;

    private Date updatedAt;

    public XmMoneySource(Integer id, Integer projectId, Integer creatorId, String source, Double money, Integer organizationId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.projectId = projectId;
        this.creatorId = creatorId;
        this.source = source;
        this.money = money;
        this.organizationId = organizationId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public XmMoneySource() {
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
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