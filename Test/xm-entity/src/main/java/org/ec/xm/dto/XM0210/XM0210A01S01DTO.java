package org.ec.xm.dto.XM0210;

import org.ec.utils.dto.ResponseDTO;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * XM0210/A01 项目数据获取+查询框(区县): 项目
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0210A01S01DTO extends ResponseDTO {
     private  double totalMoney;
     private  double provinceMoney;
     private  Integer fundingId;
    /**
     * 项目年度
     */
    private String year;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目ID
     */
    private Integer projectId;

    /**
     * 项目编码
     */
    private String code;

    /**
     * 项目来源
     */
    private String source;

    /**
     * 项目经费
     */
    private Double money;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdAt;

    /**
     * 教育阶段
     */
    private String educationStage;

    /**
     * 状态
     */
    private Integer status;


    /**
     * 获取 项目年度
     * @return year 项目年度
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置 项目年度
     * @param year 项目年度
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取 项目名称
     * @return name 项目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 项目名称
     * @param name 项目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 项目ID
     * @return projectId 项目ID
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 设置 项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取 项目编码
     * @return code 项目编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置 项目编码
     * @param code 项目编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取 项目来源
     * @return source 项目来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置 项目来源
     * @param source 项目来源
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 获取 项目经费
     * @return money 项目经费
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 设置 项目经费
     * @param money 项目经费
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * 获取 创建时间
     * @return createdAt 创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置 创建时间
     * @param createdAt 创建时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取 教育阶段
     * @return educationStage 教育阶段
     */
    public String getEducationStage() {
        return educationStage;
    }

    /**
     * 设置 教育阶段
     * @param educationStage 教育阶段
     */
    public void setEducationStage(String educationStage) {
        this.educationStage = educationStage;
    }

    /**
     * 获取 状态
     * @return status 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置 状态
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFundingId() {
        return fundingId;
    }

    public void setFundingId(Integer fundingId) {
        this.fundingId = fundingId;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getProvinceMoney() {
        return provinceMoney;
    }

    public void setProvinceMoney(double provinceMoney) {
        this.provinceMoney = provinceMoney;
    }
}
