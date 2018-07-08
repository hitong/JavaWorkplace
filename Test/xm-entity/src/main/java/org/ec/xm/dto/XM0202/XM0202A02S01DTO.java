package org.ec.xm.dto.XM0202;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0202/A02 筛选树: 项目名称
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0202A02S01DTO extends ResponseDTO {

    /**
     * 项目编码
     */
    private String code;

    /**
     * 项目名称
     */
    private String name;
public XM0202A02S01DTO(String code,String name){
this.code=code;
this.name=name;
}

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
}
