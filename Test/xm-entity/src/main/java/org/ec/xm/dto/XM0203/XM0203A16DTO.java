package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0203/A16 区县下达资金详情: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A16DTO extends ResponseDTO {

    /**
     * 学校名称
     */
    private String name;

    /**
     * 金额
     */
    private Double money;


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
}
