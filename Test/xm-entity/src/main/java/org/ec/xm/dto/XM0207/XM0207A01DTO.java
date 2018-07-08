package org.ec.xm.dto.XM0207;

import org.ec.utils.dto.ResponseDTO;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * XM0207/A01 任务信息获取(学校): 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0207A01DTO extends ResponseDTO {

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
     * 上级组织ID
     */
    private Integer superiorOrganizationId;

    /**
     * 组织ID
     */
    private Integer organizationId;

    /**
     * 上级任务ID
     */
    private Integer superiorTaskId;


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
     * 获取 上级组织ID
     * @return superiorOrganizationId 上级组织ID
     */
    public Integer getSuperiorOrganizationId() {
        return superiorOrganizationId;
    }

    /**
     * 设置 上级组织ID
     * @param superiorOrganizationId 上级组织ID
     */
    public void setSuperiorOrganizationId(Integer superiorOrganizationId) {
        this.superiorOrganizationId = superiorOrganizationId;
    }

    /**
     * 获取 组织ID
     * @return organizationId 组织ID
     */
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
     * 获取 上级任务ID
     * @return superiorTaskId 上级任务ID
     */
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
}
