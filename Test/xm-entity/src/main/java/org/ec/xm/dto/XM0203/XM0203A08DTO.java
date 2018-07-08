package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.ResponseDTO;
import java.util.List;

/**
 * XM0203/A08 资金信息获取: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A08DTO extends ResponseDTO {

    /**
     * 总资金
     */
    private Double totalMoney;

    /**
     * 下达资金
     */
    private Double fundingMoney;

    /**
     * 资金来源
     */
    private List<XM0203A08S01DTO> moneySource;


    /**
     * 获取 总资金
     * @return totalMoney 总资金
     */
    public Double getTotalMoney() {
        return totalMoney;
    }

    /**
     * 设置 总资金
     * @param totalMoney 总资金
     */
    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
     * 获取 下达资金
     * @return fundingMoney 下达资金
     */
    public Double getFundingMoney() {
        return fundingMoney;
    }

    /**
     * 设置 下达资金
     * @param fundingMoney 下达资金
     */
    public void setFundingMoney(Double fundingMoney) {
        this.fundingMoney = fundingMoney;
    }

    /**
     * 获取 资金来源
     * @return moneySource 资金来源
     */
    public List<XM0203A08S01DTO> getMoneySource() {
        return moneySource;
    }

    /**
     * 设置 资金来源
     * @param moneySource 资金来源
     */
    public void setMoneySource(List<XM0203A08S01DTO> moneySource) {
        this.moneySource = moneySource;
    }
}
