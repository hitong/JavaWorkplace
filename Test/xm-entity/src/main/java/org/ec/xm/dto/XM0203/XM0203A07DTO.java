package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0203/A07 资金下达详情: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A07DTO extends ResponseDTO {
    private Integer organizationId;
    /**
     * 区县
     */
    private String name;

    /**
     * 金额
     */
    private Double money;


    /**
     * 获取 区县
     * @return name 区县
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 区县
     * @param name 区县
     */
    public void setName(String name) {
        this.name = name;
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

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
}
