package org.ec.xm.dto.XM0204;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0204/A10 项目获取: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0204A10DTO extends ResponseDTO {

    /**
     * 项目ID
     */
    private Integer projectId;

    /**
     * 项目名称
     */
    private String projectName;


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
}
