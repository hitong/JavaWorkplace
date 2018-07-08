package org.ec.xm.dto.XM0202;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0202/A04 资金下达表: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0202A04InputDTO extends RequestDTO {

    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空")
    private Integer projectId;

    /**
     * 组织Id
     */
    @NotNull(message = "组织Id不能为空")
    private Integer organizationId;


    /**
     * 获取 项目ID
     * @return projectId 项目ID
     */
    @ApiModelProperty(value = "项目ID", name = "projectId", dataType = "Integer")
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 设置 项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

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
