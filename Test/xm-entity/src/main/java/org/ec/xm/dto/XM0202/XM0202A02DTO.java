package org.ec.xm.dto.XM0202;

import org.ec.utils.dto.ResponseDTO;
import org.ec.xm.dto.XM0203.XM0203A02DTO;

import java.util.List;

/**
 * XM0202/A02 筛选树: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0202A02DTO extends ResponseDTO {
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
    private List<XM0202A02S01DTO> children;
    public XM0202A02DTO(){

    }
   public XM0202A02DTO(String year){
    this.year=year;
     }
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
    public List<XM0202A02S01DTO> getChildren() {
        return children;
    }

    /**
     * 设置 项目名称
     * @param children 项目名称
     */
    public void setChildren(List<XM0202A02S01DTO> children) {
        this.children = children;
    }
}
