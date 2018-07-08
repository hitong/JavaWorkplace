package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0203/A16 区县下达资金详情: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A16InputDTO extends RequestDTO {

    private Integer pageSize;
    private Integer pageNum;
    /**
     * 区县ID
     */
    @NotNull(message = "区县ID不能为空")
    private Integer organizationId;

    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空")
    private Integer projectId;


    /**
     * 获取 区县ID
     * @return organizationId 区县ID
     */
    @ApiModelProperty(value = "区县ID", name = "organizationId", dataType = "Integer")
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置 区县ID
     * @param organizationId 区县ID
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

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

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
