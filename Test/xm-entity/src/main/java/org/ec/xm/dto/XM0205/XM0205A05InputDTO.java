package org.ec.xm.dto.XM0205;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * XM0205/A05 任务详情获取(分页&查询): 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0205A05InputDTO extends RequestDTO {

    /**
     * 当前页
     */
    @NotNull(message = "当前页不能为空")
    private Integer page;

    /**
     * 分页大小
     */
    @NotNull(message = "分页大小不能为空")
    private Integer pageSize;

    /**
     * 任务状态
     */
    @NotBlank(message = "任务状态不能为空")
    private String status;

    /**
     * 任务ID
     */
    @NotNull(message = "任务ID不能为空")
    private Integer taskId;


    /**
     * 获取 当前页
     * @return page 当前页
     */
    @ApiModelProperty(value = "当前页", name = "page", dataType = "Integer")
    public Integer getPage() {
        return page;
    }

    /**
     * 设置 当前页
     * @param page 当前页
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * 获取 分页大小
     * @return pageSize 分页大小
     */
    @ApiModelProperty(value = "分页大小", name = "pageSize", dataType = "Integer")
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置 分页大小
     * @param pageSize 分页大小
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

    /**
     * 获取 任务ID
     * @return taskId 任务ID
     */
    @ApiModelProperty(value = "任务ID", name = "taskId", dataType = "Integer")
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * 设置 任务ID
     * @param taskId 任务ID
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}
