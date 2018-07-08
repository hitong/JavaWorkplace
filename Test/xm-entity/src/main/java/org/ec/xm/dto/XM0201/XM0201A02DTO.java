package org.ec.xm.dto.XM0201;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0201/A02 退回任务或催报任务获取: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0201A02DTO extends ResponseDTO {

    /**
     * 任务ID
     */
    private Integer taskId;

    /**
     * 任务名称
     */
    private String name;


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
}
