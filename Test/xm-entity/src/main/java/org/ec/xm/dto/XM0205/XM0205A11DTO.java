package org.ec.xm.dto.XM0205;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0205/A11 下级组织获取: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0205A11DTO extends ResponseDTO {

    /**
     * 区县名称
     */
    private String name;

    /**
     * 区县ID
     */
    private Integer organizationId;


    /**
     * 获取 区县名称
     * @return name 区县名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 区县名称
     * @param name 区县名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 区县ID
     * @return organizationId 区县ID
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置 区县ID
     * @param organizationId 区县ID
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
}
