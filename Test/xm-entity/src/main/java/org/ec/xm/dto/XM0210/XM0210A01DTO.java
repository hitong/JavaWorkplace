package org.ec.xm.dto.XM0210;

import org.ec.utils.dto.ResponseDTO;
import java.util.List;

/**
 * XM0210/A01 项目数据获取+查询框(区县): 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0210A01DTO extends ResponseDTO {

    /**
     * 项目
     */
    private List<XM0210A01S01DTO> project;


    /**
     * 获取 项目
     * @return project 项目
     */
    public List<XM0210A01S01DTO> getProject() {
        return project;
    }

    /**
     * 设置 项目
     * @param project 项目
     */
    public void setProject(List<XM0210A01S01DTO> project) {
        this.project = project;
    }
}
