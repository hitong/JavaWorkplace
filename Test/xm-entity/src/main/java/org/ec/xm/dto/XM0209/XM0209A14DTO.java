package org.ec.xm.dto.XM0209;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0209/A14 下级组织获取(区县): 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0209A14DTO extends ResponseDTO {

    /**
     * 学校名称
     */
    private String name;

    /**
     * 学校ID
     */
    private Integer organizationId;


    /**
     * 获取 学校名称
     * @return name 学校名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 学校名称
     * @param name 学校名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 学校ID
     * @return organizationId 学校ID
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置 学校ID
     * @param organizationId 学校ID
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
}
