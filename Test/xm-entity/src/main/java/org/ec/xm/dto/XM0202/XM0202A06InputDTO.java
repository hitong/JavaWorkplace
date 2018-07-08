package org.ec.xm.dto.XM0202;

import org.ec.utils.dto.RequestDTO;
import org.hibernate.validator.constraints.NotBlank;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

/**
 * XM0202/A06 项目编辑提交: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0202A06InputDTO extends RequestDTO {
    private String [] sourceArray;
    /**
     * 项目名称
     */
    @NotBlank(message = "项目名称不能为空")
    private String name;

    /**
     * 项目编码
     */
    @NotBlank(message = "项目编码不能为空")
    private String code;

    /**
     * 来源
     */
    private String source;

    /**
     * 项目年度
     */
    @NotBlank(message = "项目年度不能为空")
    private String year;

    /**
     * 教育阶段
     */
    private String educationStage;

    /**
     * 备注
     */
    private String remark;

    /**
     * 定时任务-任务类型
     */
    private String[] timedTaskType;

    /**
     * 模板ID
     */
    private Integer[] dataTemplateId;

    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空")
    private Integer projectId;

    /**
     * 定时任务ID
     */
    private Integer[] timingTaskId;

    /**
     * 项目配置ID
     */
    private Integer[] projectConfigId;


    /**
     * 获取 项目名称
     * @return name 项目名称
     */
    @ApiModelProperty(value = "项目名称", name = "name", dataType = "String")
    public String getName() {
        return name;
    }

    /**
     * 设置 项目名称
     * @param name 项目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 项目编码
     * @return code 项目编码
     */
    @ApiModelProperty(value = "项目编码", name = "code", dataType = "String")
    public String getCode() {
        return code;
    }

    /**
     * 设置 项目编码
     * @param code 项目编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取 来源
     * @return source 来源
     */
    @ApiModelProperty(value = "来源", name = "source", dataType = "String")
    public String getSource() {
        return source;
    }

    /**
     * 设置 来源
     * @param source 来源
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 获取 项目年度
     * @return year 项目年度
     */
    @ApiModelProperty(value = "项目年度", name = "year", dataType = "String")
    public String getYear() {
        return year;
    }

    /**
     * 设置 项目年度
     * @param year 项目年度
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取 教育阶段
     * @return educationStage 教育阶段
     */
    @ApiModelProperty(value = "教育阶段", name = "educationStage", dataType = "String")
    public String getEducationStage() {
        return educationStage;
    }

    /**
     * 设置 教育阶段
     * @param educationStage 教育阶段
     */
    public void setEducationStage(String educationStage) {
        this.educationStage = educationStage;
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

    /**
     * 获取 定时任务-任务类型
     * @return timedTaskType 定时任务-任务类型
     */
    @ApiModelProperty(value = "定时任务-任务类型", name = "timedTaskType", dataType = "String[]")
    public String[] getTimedTaskType() {
        return timedTaskType;
    }

    /**
     * 设置 定时任务-任务类型
     * @param timedTaskType 定时任务-任务类型
     */
    public void setTimedTaskType(String[] timedTaskType) {
        this.timedTaskType = timedTaskType;
    }

    /**
     * 获取 模板ID
     * @return dataTemplateId 模板ID
     */
    @ApiModelProperty(value = "模板ID", name = "dataTemplateId", dataType = "Integer[]")
    public Integer[] getDataTemplateId() {
        return dataTemplateId;
    }

    /**
     * 设置 模板ID
     * @param dataTemplateId 模板ID
     */
    public void setDataTemplateId(Integer[] dataTemplateId) {
        this.dataTemplateId = dataTemplateId;
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
     * 获取 定时任务ID
     * @return timingTaskId 定时任务ID
     */
    @ApiModelProperty(value = "定时任务ID", name = "timingTaskId", dataType = "Integer[]")
    public Integer[] getTimingTaskId() {
        return timingTaskId;
    }

    /**
     * 设置 定时任务ID
     * @param timingTaskId 定时任务ID
     */
    public void setTimingTaskId(Integer[] timingTaskId) {
        this.timingTaskId = timingTaskId;
    }

    /**
     * 获取 项目配置ID
     * @return projectConfigId 项目配置ID
     */
    @ApiModelProperty(value = "项目配置ID", name = "projectConfigId", dataType = "Integer[]")
    public Integer[] getProjectConfigId() {
        return projectConfigId;
    }

    /**
     * 设置 项目配置ID
     * @param projectConfigId 项目配置ID
     */
    public void setProjectConfigId(Integer[] projectConfigId) {
        this.projectConfigId = projectConfigId;
    }

    public String[] getSourceArray() {
        return sourceArray;
    }

    public void setSourceArray(String[] sourceArray) {
        this.sourceArray = sourceArray;
    }
}
