package org.ec.xm.dto.XM0205;

import org.ec.utils.dto.ResponseDTO;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * XM0205/A08 动态信息内容获取(分页&查询): 内容信息
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0205A08S01DTO extends ResponseDTO {

    /**
     * 动态信息ID
     */
    private Integer processId;

    /**
     * 内容
     */
    private String content;

    /**
     * 单位
     */
    private String company;

    /**
     * 回复条数
     */
    private Integer replyNum;

    /**
     * 作者名
     */
    private String name;

    /**
     * 组织ID
     */
    private Integer organizationId;

    /**
     * 时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdAt;


    /**
     * 获取 动态信息ID
     * @return processId 动态信息ID
     */
    public Integer getProcessId() {
        return processId;
    }

    /**
     * 设置 动态信息ID
     * @param processId 动态信息ID
     */
    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    /**
     * 获取 内容
     * @return content 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置 内容
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取 单位
     * @return company 单位
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置 单位
     * @param company 单位
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取 回复条数
     * @return replyNum 回复条数
     */
    public Integer getReplyNum() {
        return replyNum;
    }

    /**
     * 设置 回复条数
     * @param replyNum 回复条数
     */
    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    /**
     * 获取 作者名
     * @return name 作者名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 作者名
     * @param name 作者名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 组织ID
     * @return organizationId 组织ID
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置 组织ID
     * @param organizationId 组织ID
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取 时间
     * @return createdAt 时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置 时间
     * @param createdAt 时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
