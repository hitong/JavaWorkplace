package org.ec.xm.dto.XM0210;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0210/A09 文件上传(区县): 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0210A09DTO extends ResponseDTO {

    /**
     * 项目文件Id
     */
    private Integer projectFileId;


    /**
     * 获取 项目文件Id
     * @return projectFileId 项目文件Id
     */
    public Integer getProjectFileId() {
        return projectFileId;
    }

    /**
     * 设置 项目文件Id
     * @param projectFileId 项目文件Id
     */
    public void setProjectFileId(Integer projectFileId) {
        this.projectFileId = projectFileId;
    }
}
