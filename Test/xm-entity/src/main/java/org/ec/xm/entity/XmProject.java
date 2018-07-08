package org.ec.xm.entity;

import java.util.Date;

public class XmProject {
    private Integer id;

    private String code;

    private String name;

    private String source;

    private String year;

    private String educationStage;

    private Byte status;

    private Integer organizationId;

    private Integer creatorId;

    private Date createdAt;

    private Date updatedAt;

    private String remark;

    public XmProject(Integer id, String code, String name, String source, String year, String educationStage, Byte status, Integer organizationId, Integer creatorId, Date createdAt, Date updatedAt, String remark) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.source = source;
        this.year = year;
        this.educationStage = educationStage;
        this.status = status;
        this.organizationId = organizationId;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.remark = remark;
    }

    public XmProject() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getEducationStage() {
        return educationStage;
    }

    public void setEducationStage(String educationStage) {
        this.educationStage = educationStage == null ? null : educationStage.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
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