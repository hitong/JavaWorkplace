package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0203/A14 文件列表获取: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A14InputDTO extends RequestDTO {

    /**
     * 资金下达ID
     */
    @NotNull(message = "资金下达ID不能为空")
    private Integer fundingId;


    /**
     * 获取 资金下达ID
     * @return fundingId 资金下达ID
     */
    @ApiModelProperty(value = "资金下达ID", name = "fundingId", dataType = "Integer")
    public Integer getFundingId() {
        return fundingId;
    }

    /**
     * 设置 资金下达ID
     * @param fundingId 资金下达ID
     */
    public void setFundingId(Integer fundingId) {
        this.fundingId = fundingId;
    }
}
