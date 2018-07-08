package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * XM0203/A01 任务状态查询: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A01InputDTO extends RequestDTO {

    /**
     * 项目Id
     */
    @NotNull(message = "项目Id不能为空")
    private Integer projectId;

    /**
     * 当前页数
     */
    private Integer page;

    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 任务状态
     */
    @NotBlank(message = "任务状态不能为空")
    private String status;


    /**
     * 获取 项目Id
     * @return projectId 项目Id
     */
    @ApiModelProperty(value = "项目Id", name = "projectId", dataType = "Integer")
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 设置 项目Id
     * @param projectId 项目Id
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取 当前页数
     * @return page 当前页数
     */
    @ApiModelProperty(value = "当前页数", name = "page", dataType = "Integer")
    public Integer getPage() {
        return page;
    }

    /**
     * 设置 当前页数
     * @param page 当前页数
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * 获取 页面大小
     * @return pageSize 页面大小
     */
    @ApiModelProperty(value = "页面大小", name = "pageSize", dataType = "Integer")
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置 页面大小
     * @param pageSize 页面大小
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取 任务状态
     * @return status 任务状态
     */
    @ApiModelProperty(value = "任务状态", name = "status", dataType = "String")
    public String getStatus() {
        return status;
    }

    /**
     * 设置 任务状态
     * @param status 任务状态
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
