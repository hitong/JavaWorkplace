package org.ec.xm.dto.XM0205;

import org.ec.utils.dto.ResponseDTO;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * XM0205/A05 任务详情获取(分页&查询): 任务信息
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0205A05S01DTO extends ResponseDTO {

    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务类型
     */
    private String type;

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
     * 任务状态
     */
    private String status;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdAt;

    /**
     * 任务ID
     */
    private Integer taskId;

    /**
     * 区县名称
     */
    private String organizationName;

    /**
     * 退回人姓名
     */
    private String returnmanName;

    /**
     * 催报人姓名
     */
    private String urgemanName;


    /**
     * 获取 任务名称
     * @return name 任务名称
     */
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
     * 获取 创建时间
     * @return createdAt 创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置 创建时间
     * @param createdAt 创建时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取 任务ID
     * @return taskId 任务ID
     */
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
     * 获取 区县名称
     * @return organizationName 区县名称
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * 设置 区县名称
     * @param organizationName 区县名称
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    /**
     * 获取 退回人姓名
     * @return returnmanName 退回人姓名
     */
    public String getReturnmanName() {
        return returnmanName;
    }

    /**
     * 设置 退回人姓名
     * @param returnmanName 退回人姓名
     */
    public void setReturnmanName(String returnmanName) {
        this.returnmanName = returnmanName;
    }

    /**
     * 获取 催报人姓名
     * @return urgemanName 催报人姓名
     */
    public String getUrgemanName() {
        return urgemanName;
    }

    /**
     * 设置 催报人姓名
     * @param urgemanName 催报人姓名
     */
    public void setUrgemanName(String urgemanName) {
        this.urgemanName = urgemanName;
    }
}
