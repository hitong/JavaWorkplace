package org.ec.xm.dto.XM0204;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0204/A06 任务筛选树获取: 项目名称
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0204A06S01DTO extends ResponseDTO {

    /**
     * 项目ID
     */
    private Integer projectId;

    /**
     * 项目名称
     */
    private String name;


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
}
