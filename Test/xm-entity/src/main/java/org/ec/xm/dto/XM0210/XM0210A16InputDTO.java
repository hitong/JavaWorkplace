package org.ec.xm.dto.XM0210;

import org.ec.utils.dto.RequestDTO;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0210/A16 资金下达项目获取: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0210A16InputDTO extends RequestDTO {

    /**
     * 组织ID
     */
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
