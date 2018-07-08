package org.ec.xm.dto.XM0208;

import org.ec.utils.dto.ResponseDTO;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * XM0208/A04 任务查询获取(区县): 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0208A04DTO extends ResponseDTO {

    /**
     * 任务ID
     */
    private Integer taskId;

    /**
     * 项目ID
     */
    private Integer projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务类型
     */
    private String type;

    /**
     * 经费
     */
    private Double money;

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
     * 任务状态
     */
    private String status;


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

    /**
     * 获取 项目名称
     * @return projectName 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置 项目名称
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
     * 获取 经费
     * @return money 经费
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 设置 经费
     * @param money 经费
     */
    public void setMoney(Double money) {
        this.money = money;
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
}
