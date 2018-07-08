package org.ec.xm.dto.XM0205;

import org.ec.utils.dto.RequestDTO;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

/**
 * XM0205/A08 动态信息内容获取(分页&查询): 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0205A08InputDTO extends RequestDTO {

    /**
     * 上级任务ID
     */
    private Integer superiorTaskId;

    /**
     * 任务ID
     */
    @NotNull(message = "任务ID不能为空")
    private Integer taskId;

    /**
     * 作者ID
     */
    @NotNull(message = "作者ID不能为空")
    private Integer userId;

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
     * 获取 上级任务ID
     * @return superiorTaskId 上级任务ID
     */
    @ApiModelProperty(value = "上级任务ID", name = "superiorTaskId", dataType = "Integer")
    public Integer getSuperiorTaskId() {
        return superiorTaskId;
    }

    /**
     * 设置 上级任务ID
     * @param superiorTaskId 上级任务ID
     */
    public void setSuperiorTaskId(Integer superiorTaskId) {
        this.superiorTaskId = superiorTaskId;
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

    /**
     * 获取 作者ID
     * @return userId 作者ID
     */
    @ApiModelProperty(value = "作者ID", name = "userId", dataType = "Integer")
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置 作者ID
     * @param userId 作者ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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
}
