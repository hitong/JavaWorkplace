package org.ec.xm.dto.XM0201;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * XM0201/A02 退回任务或催报任务获取: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0201A02InputDTO extends RequestDTO {

    /**
     * 组织ID
     */
    @NotNull(message = "组织ID不能为空")
    private Integer organizationId;

    /**
     * 类型
     */
    @NotBlank(message = "类型不能为空")
    private String type;


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

    /**
     * 获取 类型
     * @return type 类型
     */
    @ApiModelProperty(value = "类型", name = "type", dataType = "String")
    public String getType() {
        return type;
    }

    /**
     * 设置 类型
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }
}
