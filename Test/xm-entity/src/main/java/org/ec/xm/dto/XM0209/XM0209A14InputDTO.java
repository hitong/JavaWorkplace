package org.ec.xm.dto.XM0209;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0209/A14 下级组织获取(区县): 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0209A14InputDTO extends RequestDTO {

    /**
     * 组织ID
     */
    @NotNull(message = "组织ID不能为空")
    private Integer organizationId;


    /**
     * 获取 组织ID
     * @return organizationId 组织ID
     */
    @ApiModelProperty(value = "组织ID", name = "organizationId", dataType = "Integer")
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
}