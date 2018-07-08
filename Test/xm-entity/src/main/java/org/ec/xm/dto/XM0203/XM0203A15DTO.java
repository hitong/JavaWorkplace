package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0203/A15 区县下达筛选树获取: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A15DTO extends ResponseDTO {

    /**
     * 组织ID
     */
    private Integer organizationId;

    /**
     * 组织名称
     */
    private String name;


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
     * 获取 组织名称
     * @return name 组织名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 组织名称
     * @param name 组织名称
     */
    public void setName(String name) {
        this.name = name;
    }
}
