package org.ec.xm.dto.XM0208;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0208/A06 文件资料获取(区县): 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0208A06DTO extends ResponseDTO {

    /**
     * 项目文件ID
     */
    private Integer projectFileId;

    /**
     * 附件来源
     */
    private String source;

    /**
     * 附件名称
     */
    private String name;

    /**
     * 附件路径
     */
    private String path;

    /**
     * 附件类型
     */
    private String type;


    /**
     * 获取 项目文件ID
     * @return projectFileId 项目文件ID
     */
    public Integer getProjectFileId() {
        return projectFileId;
    }

    /**
     * 设置 项目文件ID
     * @param projectFileId 项目文件ID
     */
    public void setProjectFileId(Integer projectFileId) {
        this.projectFileId = projectFileId;
    }

    /**
     * 获取 附件来源
     * @return source 附件来源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置 附件来源
     * @param source 附件来源
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 获取 附件名称
     * @return name 附件名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 附件名称
     * @param name 附件名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 附件路径
     * @return path 附件路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置 附件路径
     * @param path 附件路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取 附件类型
     * @return type 附件类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 附件类型
     * @param type 附件类型
     */
    public void setType(String type) {
        this.type = type;
    }
}
