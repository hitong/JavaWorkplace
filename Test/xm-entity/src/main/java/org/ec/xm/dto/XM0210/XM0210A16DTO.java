package org.ec.xm.dto.XM0210;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0210/A16 资金下达项目获取: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0210A16DTO extends ResponseDTO {

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
