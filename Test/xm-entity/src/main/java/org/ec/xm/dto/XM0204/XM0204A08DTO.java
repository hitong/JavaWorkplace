package org.ec.xm.dto.XM0204;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0204/A08 组织信息获取: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0204A08DTO extends ResponseDTO {

    /**
     * 组织ID
     */
    private Integer organizationId;

    /**
     * 组织编码
     */
    private String code;

    /**
     * 组织名称
     */
    private String name;

    /**
     * 负责人
     */
    private String leader;


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
     * 获取 组织编码
     * @return code 组织编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置 组织编码
     * @param code 组织编码
     */
    public void setCode(String code) {
        this.code = code;
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

    /**
     * 获取 负责人
     * @return leader 负责人
     */
    public String getLeader() {
        return leader;
    }

    /**
     * 设置 负责人
     * @param leader 负责人
     */
    public void setLeader(String leader) {
        this.leader = leader;
    }
}
