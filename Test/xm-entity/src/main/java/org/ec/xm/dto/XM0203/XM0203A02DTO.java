package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0203/A02 项目信息: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A02DTO extends ResponseDTO {

    /**
     * 项目编码
     */
    private String code;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 来源
     */
    private String source;

    /**
     * 金额
     */
    private Double money;

    /**
     * 年度
     */
    private String year;

    /**
     * 教育阶段
     */
    private String educationStage;

    /**
     * 备注
     */
    private String remark;


    /**
     * 获取 项目编码
     * @return code 项目编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置 项目编码
     * @param code 项目编码
     */
    public void setCode(String code) {
        this.code = code;
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
     * 获取 金额
     * @return money 金额
     */
    public Double getMoney() {
        return money;
    }

    /**
     * 设置 金额
     * @param money 金额
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * 获取 年度
     * @return year 年度
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置 年度
     * @param year 年度
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取 教育阶段
     * @return educationStage 教育阶段
     */
    public String getEducationStage() {
        return educationStage;
    }

    /**
     * 设置 教育阶段
     * @param educationStage 教育阶段
     */
    public void setEducationStage(String educationStage) {
        this.educationStage = educationStage;
    }

    /**
     * 获取 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
