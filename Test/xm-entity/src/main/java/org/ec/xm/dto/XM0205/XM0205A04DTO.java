package org.ec.xm.dto.XM0205;

import org.ec.utils.dto.ResponseDTO;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * XM0205/A04 最新动态回复查看: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0205A04DTO extends ResponseDTO {

    /**
     * 单位
     */
    private String organizationName;

    /**
     * 内容
     */
    private String content;

    /**
     * 作者
     */
    private String name;

    /**
     * 时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdAt;


    /**
     * 获取 单位
     * @return organizationName 单位
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * 设置 单位
     * @param organizationName 单位
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
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
     * 获取 作者
     * @return name 作者
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 作者
     * @param name 作者
     */
    public void setName(String name) {
        this.name = name;
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
