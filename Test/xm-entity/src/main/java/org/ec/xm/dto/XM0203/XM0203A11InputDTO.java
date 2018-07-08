package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0203/A11 资金来源删除: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A11InputDTO extends RequestDTO {

    /**
     * 资金来源ID
     */
    @NotNull(message = "资金来源ID不能为空")
    private Integer moneySourceId;


    /**
     * 获取 资金来源ID
     * @return moneySourceId 资金来源ID
     */
    @ApiModelProperty(value = "资金来源ID", name = "moneySourceId", dataType = "Integer")
    public Integer getMoneySourceId() {
        return moneySourceId;
    }

    /**
     * 设置 资金来源ID
     * @param moneySourceId 资金来源ID
     */
    public void setMoneySourceId(Integer moneySourceId) {
        this.moneySourceId = moneySourceId;
    }
}
