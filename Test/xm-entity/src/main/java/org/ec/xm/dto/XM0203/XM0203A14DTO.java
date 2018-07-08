package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0203/A14 文件列表获取: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A14DTO extends ResponseDTO {

    /**
     * 文件ID
     */
    private Integer fileId;

    /**
     * 来源
     */
    private String source;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 大小
     */
    private String size;

    /**
     * 是否下发
     */
    private Boolean status;

    /**
     * 路径
     */
    private String path;


    /**
     * 获取 文件ID
     * @return fileId 文件ID
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     * 设置 文件ID
     * @param fileId 文件ID
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

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
     * 获取 名称
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 类型
     * @return type 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 类型
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取 大小
     * @return size 大小
     */
    public String getSize() {
        return size;
    }

    /**
     * 设置 大小
     * @param size 大小
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * 获取 是否下发
     * @return status 是否下发
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置 是否下发
     * @param status 是否下发
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取 路径
     * @return path 路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置 路径
     * @param path 路径
     */
    public void setPath(String path) {
        this.path = path;
    }
}
