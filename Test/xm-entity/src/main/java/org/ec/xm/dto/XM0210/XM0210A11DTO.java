package org.ec.xm.dto.XM0210;

import org.ec.utils.dto.ResponseDTO;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * XM0210/A11 资金下达展示(区县): 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0210A11DTO extends ResponseDTO {
    private Integer id;
    /**
     * 项目编码
     */
    private String code;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 来源
     */
    private String source;

    /**
     * 金额
     */
    private Double money;

    /**
     * 年度
     */
    private String year;

    /**
     * 教育阶段
     */
    private String educationStage;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdAt;

    /**
     * 总页数
     */
    private Integer totalCount;

    /**
     * 当前页面
     */
    private Integer page;

    /**
     * 当前页面大小
     */
    private Integer pageSize;

    /**
     * 资金分配ID
     */
    private Integer fundingId;


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
     * 获取 来源
     * @return source 来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置 来源
     * @param source 来源
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 获取 金额
     * @return money 金额
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 设置 金额
     * @param money 金额
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * 获取 年度
     * @return year 年度
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置 年度
     * @param year 年度
     */
    public void setYear(String year) {
        this.year = year;
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
     * 获取 总页数
     * @return totalCount 总页数
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * 设置 总页数
     * @param totalCount 总页数
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取 当前页面
     * @return page 当前页面
     */
    public Integer getPage() {
        return page;
    }

    /**
     * 设置 当前页面
     * @param page 当前页面
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * 获取 当前页面大小
     * @return pageSize 当前页面大小
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置 当前页面大小
     * @param pageSize 当前页面大小
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取 资金分配ID
     * @return fundingId 资金分配ID
     */
    public Integer getFundingId() {
        return fundingId;
    }

    /**
     * 设置 资金分配ID
     * @param fundingId 资金分配ID
     */
    public void setFundingId(Integer fundingId) {
        this.fundingId = fundingId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
