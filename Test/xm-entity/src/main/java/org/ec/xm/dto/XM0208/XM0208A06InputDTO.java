package org.ec.xm.dto.XM0208;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0208/A06 文件资料获取(区县): 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0208A06InputDTO extends RequestDTO {

    /**
     * 任务ID
     */
    @NotNull(message = "任务ID不能为空")
    private Integer taskId;

    /**
     * 组织ID
     */
    @NotNull(message = "组织ID不能为空")
    private Integer geOrganizationId;


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
     * 获取 组织ID
     * @return geOrganizationId 组织ID
     */
    @ApiModelProperty(value = "组织ID", name = "geOrganizationId", dataType = "Integer")
    public Integer getGeOrganizationId() {
        return geOrganizationId;
    }

    /**
     * 设置 组织ID
     * @param geOrganizationId 组织ID
     */
    public void setGeOrganizationId(Integer geOrganizationId) {
        this.geOrganizationId = geOrganizationId;
    }
}
