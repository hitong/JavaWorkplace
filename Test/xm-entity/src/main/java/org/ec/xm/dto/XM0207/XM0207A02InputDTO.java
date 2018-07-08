package org.ec.xm.dto.XM0207;

import org.ec.utils.dto.RequestDTO;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

/**
 * XM0207/A02 最新动态获取(学校): 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0207A02InputDTO extends RequestDTO {

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
}
