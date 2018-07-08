package org.ec.xm.dto.XM0202;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0202/A05 查看文件: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0202A05DTO extends ResponseDTO {

    /**
     * 来源
     */
    private String source;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件id
     */
    private Integer id;

    /**
     * 文件地址
     */
    private String path;

    /**
     * 文件类型
     */
    private String type;


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
     * 获取 文件id
     * @return id 文件id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 文件id
     * @param id 文件id
     */
    public void setId(Integer id) {
        this.id = id;
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

    /**
     * 获取 文件类型
     * @return type 文件类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 文件类型
     * @param type 文件类型
     */
    public void setType(String type) {
        this.type = type;
    }
}
