package org.ec.xm.dto.XM0210;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0210/A03 查看文件(区县): 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0210A03DTO extends ResponseDTO {

    /**
     * 来源
     */
    private String source;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 项目文件id
     */
    private Integer projectFileId;

    /**
     * 文件地址
     */
    private String path;


    /**
     * 获取 来源
     * @return source 来源
     */
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
     * 获取 文件名称
     * @return name 文件名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 文件名称
     * @param name 文件名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 项目文件id
     * @return projectFileId 项目文件id
     */
    public Integer getProjectFileId() {
        return projectFileId;
    }

    /**
     * 设置 项目文件id
     * @param projectFileId 项目文件id
     */
    public void setProjectFileId(Integer projectFileId) {
        this.projectFileId = projectFileId;
    }

    /**
     * 获取 文件地址
     * @return path 文件地址
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置 文件地址
     * @param path 文件地址
     */
    public void setPath(String path) {
        this.path = path;
    }
}
