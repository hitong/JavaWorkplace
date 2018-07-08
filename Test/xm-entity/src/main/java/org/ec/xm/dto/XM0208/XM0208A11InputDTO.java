package org.ec.xm.dto.XM0208;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0208/A11 取消下发(区县): 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0208A11InputDTO extends RequestDTO {

    /**
     * 任务ID
     */
    @NotNull(message = "任务ID不能为空")
    private Integer taskId;


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
