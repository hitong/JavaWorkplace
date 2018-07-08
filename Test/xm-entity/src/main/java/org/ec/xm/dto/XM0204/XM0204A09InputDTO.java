package org.ec.xm.dto.XM0204;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0204/A09 任务下发: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0204A09InputDTO extends RequestDTO {

    /**
     * 任务ID
     */
    @NotNull(message = "任务ID不能为空")
    private Integer taskId;

    /**
     * 组织ID
     */
    @NotNull(message = "组织ID不能为空")
    private Integer organizationId;

    /**
     * 下发单位
     */
    private Integer[] units;


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

    /**
     * 获取 下发单位
     * @return units 下发单位
     */
    @ApiModelProperty(value = "下发单位", name = "units", dataType = "Integer[]")
    public Integer[] getUnits() {
        return units;
    }

    /**
     * 设置 下发单位
     * @param units 下发单位
     */
    public void setUnits(Integer[] units) {
        this.units = units;
    }
}
