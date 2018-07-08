package org.ec.xm.entity;

import java.util.Date;

public class XmFundingDetail {
    private Integer id;

    private Integer fundingId;

    private Integer organizationId;

    private Double money;

    private Integer projectId;

    private Date createdAt;

    private Date updatedAt;

    public XmFundingDetail(Integer id, Integer fundingId, Integer organizationId, Double money, Integer projectId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.fundingId = fundingId;
        this.organizationId = organizationId;
        this.money = money;
        this.projectId = projectId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public XmFundingDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFundingId() {
        return fundingId;
    }

    public void setFundingId(Integer fundingId) {
        this.fundingId = fundingId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
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
}