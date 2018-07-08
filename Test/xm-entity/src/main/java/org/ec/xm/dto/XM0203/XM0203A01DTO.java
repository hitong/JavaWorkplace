package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.ResponseDTO;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * XM0203/A01 任务状态查询: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A01DTO extends ResponseDTO {

    /**
     * 任务Id
     */
    private Integer taskId;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdAt;

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
     * 状态
     */
    private String status;


    /**
     * 获取 任务Id
     * @return taskId 任务Id
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * 设置 任务Id
     * @param taskId 任务Id
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

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
     * 获取 状态
     * @return status 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置 状态
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
