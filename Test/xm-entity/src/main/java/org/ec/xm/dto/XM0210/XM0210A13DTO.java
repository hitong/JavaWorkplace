package org.ec.xm.dto.XM0210;

import io.swagger.models.auth.In;
import org.ec.utils.dto.ResponseDTO;
import java.util.List;

/**
 * XM0210/A13 资金下达筛选树(区县): 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0210A13DTO extends ResponseDTO {

    /**
     * 项目年度
     */
    private String year;

    /**
     * ID
     */
    private Integer id;

    /**
     * 项目名称
     */
    private List<XM0210A13S01DTO> children;


    /**
     * 获取 项目年度
     * @return year 项目年度
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置 项目年度
     * @param year 项目年度
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取 ID
     * @return id ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 ID
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 项目名称
     * @return children 项目名称
     */
    public List<XM0210A13S01DTO> getChildren() {
        return children;
    }

    /**
     * 设置 项目名称
     * @param children 项目名称
     */
    public void setChildren(List<XM0210A13S01DTO> children) {
        this.children = children;
    }
}
