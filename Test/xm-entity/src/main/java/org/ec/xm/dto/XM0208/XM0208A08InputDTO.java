package org.ec.xm.dto.XM0208;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0208/A08 项目任务获取(区县): 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0208A08InputDTO extends RequestDTO {

    /**
     * 目标页
     */
    @NotNull(message = "目标页不能为空")
    private Integer pageNum;

    /**
     * 当前页面大小
     */
    @NotNull(message = "当前页面大小不能为空")
    private Integer pageSize;

    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空")
    private Integer projectId;

    /**
     * 组织ID
     */
    @NotNull(message = "组织ID不能为空")
    private Integer organizationId;


    /**
     * 获取 目标页
     * @return pageNum 目标页
     */
    @ApiModelProperty(value = "目标页", name = "pageNum", dataType = "Integer")
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * 设置 目标页
     * @param pageNum 目标页
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * 获取 当前页面大小
     * @return pageSize 当前页面大小
     */
    @ApiModelProperty(value = "当前页面大小", name = "pageSize", dataType = "Integer")
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置 当前页面大小
     * @param pageSize 当前页面大小
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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
