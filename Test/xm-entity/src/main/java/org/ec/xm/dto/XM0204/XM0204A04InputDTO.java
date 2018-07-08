package org.ec.xm.dto.XM0204;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * XM0204/A04 任务编辑提交: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0204A04InputDTO extends RequestDTO {

    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空")
    private Integer projectId;

    /**
     * 任务ID
     */
    @NotNull(message = "任务ID不能为空")
    private Integer taskId;

    /**
     * 任务名称
     */
    @NotBlank(message = "任务名称不能为空")
    private String name;

    /**
     * 任务类型
     */
    @NotBlank(message = "任务类型不能为空")
    private String type;

    /**
     * 数据模板ID
     */
    @NotNull(message = "数据模板ID不能为空")
    private Integer dataTemplateId;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginAt;

    /**
     * 截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishAt;

    /**
     * 备注
     */
    private String remark;


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
     * 获取 任务名称
     * @return name 任务名称
     */
    @ApiModelProperty(value = "任务名称", name = "name", dataType = "String")
    public String getName() {
        return name;
    }

    /**
     * 设置 任务名称
     * @param name 任务名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 任务类型
     * @return type 任务类型
     */
    @ApiModelProperty(value = "任务类型", name = "type", dataType = "String")
    public String getType() {
        return type;
    }

    /**
     * 设置 任务类型
     * @param type 任务类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取 数据模板ID
     * @return dataTemplateId 数据模板ID
     */
    @ApiModelProperty(value = "数据模板ID", name = "dataTemplateId", dataType = "Integer")
    public Integer getDataTemplateId() {
        return dataTemplateId;
    }

    /**
     * 设置 数据模板ID
     * @param dataTemplateId 数据模板ID
     */
    public void setDataTemplateId(Integer dataTemplateId) {
        this.dataTemplateId = dataTemplateId;
    }

    /**
     * 获取 开始时间
     * @return beginAt 开始时间
     */
    @ApiModelProperty(value = "开始时间", name = "beginAt", dataType = "Date")
    public Date getBeginAt() {
        return beginAt;
    }

    /**
     * 设置 开始时间
     * @param beginAt 开始时间
     */
    public void setBeginAt(Date beginAt) {
        this.beginAt = beginAt;
    }

    /**
     * 获取 截止时间
     * @return finishAt 截止时间
     */
    @ApiModelProperty(value = "截止时间", name = "finishAt", dataType = "Date")
    public Date getFinishAt() {
        return finishAt;
    }

    /**
     * 设置 截止时间
     * @param finishAt 截止时间
     */
    public void setFinishAt(Date finishAt) {
        this.finishAt = finishAt;
    }

    /**
     * 获取 备注
     * @return remark 备注
     */
    @ApiModelProperty(value = "备注", name = "remark", dataType = "String")
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
