package org.ec.xm.dto.XM0204;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * XM0204/A05 任务查询获取: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0204A05InputDTO extends RequestDTO {

    /**
     * 目标页
     */
    @NotNull(message = "目标页不能为空")
    private Integer pageNum;

    /**
     * 当前页面大小
     */
    @NotNull(message = "当前页面大小不能为空")
    private Integer pageSize;

    /**
     * 关键字
     */
    @NotBlank(message = "关键字不能为空")
    private String keyWord;

    /**
     * 组织ID
     */
    @NotNull(message = "组织ID不能为空")
    private Integer organizationId;


    /**
     * 获取 目标页
     * @return pageNum 目标页
     */
    @ApiModelProperty(value = "目标页", name = "pageNum", dataType = "Integer")
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * 设置 目标页
     * @param pageNum 目标页
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * 获取 当前页面大小
     * @return pageSize 当前页面大小
     */
    @ApiModelProperty(value = "当前页面大小", name = "pageSize", dataType = "Integer")
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置 当前页面大小
     * @param pageSize 当前页面大小
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取 关键字
     * @return keyWord 关键字
     */
    @ApiModelProperty(value = "关键字", name = "keyWord", dataType = "String")
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * 设置 关键字
     * @param keyWord 关键字
     */
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    /**
     * 获取 组织ID
     * @return organizationId 组织ID
     */
    @ApiModelProperty(value = "组织ID", name = "organizationId", dataType = "Integer")
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置 组织ID
     * @param organizationId 组织ID
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
}
