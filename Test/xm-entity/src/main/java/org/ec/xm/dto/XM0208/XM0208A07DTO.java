package org.ec.xm.dto.XM0208;

import org.ec.utils.dto.ResponseDTO;
import java.util.List;

/**
 * XM0208/A07 任务筛选树获取(区县): 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0208A07DTO extends ResponseDTO {

    /**
     * 项目年度
     */
    private String year;

    /**
     * 项目名称
     */
    private List<XM0208A07S01DTO> children;


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
     * 获取 项目名称
     * @return children 项目名称
     */
    public List<XM0208A07S01DTO> getChildren() {
        return children;
    }

    /**
     * 设置 项目名称
     * @param children 项目名称
     */
    public void setChildren(List<XM0208A07S01DTO> children) {
        this.children = children;
    }
}
