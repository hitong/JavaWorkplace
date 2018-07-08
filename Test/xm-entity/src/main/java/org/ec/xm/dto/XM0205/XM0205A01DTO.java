package org.ec.xm.dto.XM0205;

import org.ec.utils.dto.ResponseDTO;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * XM0205/A01 任务信息获取: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0205A01DTO extends ResponseDTO {

    /**
     * 项目名称
     */
    private String name;

    /**
     * 任务类型
     */
    private String type;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务状态
     */
    private String status;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date beginAt;

    /**
     * 截止时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date finishAt;

    /**
     * 数据模板ID
     */
    private Integer dataTemplateId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 项目ID
     */
    private Integer projectId;


    /**
     * 获取 项目名称
     * @return name 项目名称
     */
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
     * 获取 任务类型
     * @return type 任务类型
     */
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
     * 获取 任务名称
     * @return taskName 任务名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * 设置 任务名称
     * @param taskName 任务名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * 获取 任务状态
     * @return status 任务状态
     */
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
     * 获取 开始时间
     * @return beginAt 开始时间
     */
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
     * 获取 数据模板ID
     * @return dataTemplateId 数据模板ID
     */
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
     * 获取 备注
     * @return remark 备注
     */
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
     * 获取 项目ID
     * @return projectId 项目ID
     */
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
}
