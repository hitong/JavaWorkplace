package org.ec.xm.dto.XM0202;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0202/A02 筛选树: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0202A02InputDTO extends RequestDTO {

    /**
     * 组织Id
     */
    @NotNull(message = "组织Id不能为空")
    private Integer organizationId;


    /**
     * 获取 组织Id
     * @return organizationId 组织Id
     */
    @ApiModelProperty(value = "组织Id", name = "organizationId", dataType = "Integer")
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置 组织Id
     * @param organizationId 组织Id
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
}
