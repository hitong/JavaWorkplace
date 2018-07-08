package org.ec.xm.dto.XM0204;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0204/A12 数据模板获取: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0204A12DTO extends ResponseDTO {

    /**
     * 数据模板ID
     */
    private Integer templateId;

    /**
     * 数据模板名称
     */
    private String templateName;


    /**
     * 获取 数据模板ID
     * @return templateId 数据模板ID
     */
    public Integer getTemplateId() {
        return templateId;
    }

    /**
     * 设置 数据模板ID
     * @param templateId 数据模板ID
     */
    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    /**
     * 获取 数据模板名称
     * @return templateName 数据模板名称
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 设置 数据模板名称
     * @param templateName 数据模板名称
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
