package org.ec.xm.dto.XM0202;

import org.ec.utils.dto.RequestDTO;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * XM0202/A01 项目数据获取+查询框: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0202A01InputDTO extends RequestDTO {

    /**
     * 当前页
     */

    private Integer page;

    /**
     * 分页大小
     */
    private Integer pageSize;

    /**
     * 项目编码或名称
     */
    @NotBlank(message = "项目编码或名称不能为空")
    private String keyWord;

    /**
     * 组织ID
     */
    @NotNull(message = "组织ID不能为空")
    private Integer organizationId;


    /**
     * 获取 当前页
     * @return page 当前页
     */
    @ApiModelProperty(value = "当前页", name = "page", dataType = "Integer")
    public Integer getPage() {
        return page;
    }

    /**
     * 设置 当前页
     * @param page 当前页
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * 获取 分页大小
     * @return pageSize 分页大小
     */
    @ApiModelProperty(value = "分页大小", name = "pageSize", dataType = "Integer")
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置 分页大小
     * @param pageSize 分页大小
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取 项目编码或名称
     * @return keyWord 项目编码或名称
     */
    @ApiModelProperty(value = "项目编码或名称", name = "keyWord", dataType = "String")
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * 设置 项目编码或名称
     * @param keyWord 项目编码或名称
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
