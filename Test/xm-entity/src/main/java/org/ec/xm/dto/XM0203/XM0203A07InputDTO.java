package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0203/A07 资金下达详情: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A07InputDTO extends RequestDTO {
   private Integer page;
   private Integer pageSize;
   private Integer orgType;
    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空")
    private Integer projectId;

    /**
     * 资金分配ID
     */
    @NotNull(message = "资金分配ID不能为空")
    private Integer fundingId;

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
     * 获取 资金分配ID
     * @return fundingId 资金分配ID
     */
    @ApiModelProperty(value = "资金分配ID", name = "fundingId", dataType = "Integer")
    public Integer getFundingId() {
        return fundingId;
    }

    /**
     * 设置 资金分配ID
     * @param fundingId 资金分配ID
     */
    public void setFundingId(Integer fundingId) {
        this.fundingId = fundingId;
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

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }
}
