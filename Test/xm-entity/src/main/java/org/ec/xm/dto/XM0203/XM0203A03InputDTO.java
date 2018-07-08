package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0203/A03 资金分配: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A03InputDTO extends RequestDTO {


    /**
     * 项目Id
     */
    @NotNull(message = "项目Id不能为空")
    private Integer projectId;

    /**
     * 组织ID
     */
    private Integer[] organizationId;

    /**
     * 金额
     */
    private Float[] money;

    /**
     * 当前页数
     */
    @NotNull(message = "当前页数不能为空")
    private Integer page;

    /**
     * 当前页面大小
     */
    @NotNull(message = "当前页面大小不能为空")
    private Integer pageSize;

    /**
     * ID
     */
    private Integer id;

    /**
     * 当前组织ID
     */
    @NotNull(message = "当前组织ID不能为空")
    private Integer curOrganizationId;


    /**
     * 获取 项目Id
     * @return projectId 项目Id
     */
    @ApiModelProperty(value = "项目Id", name = "projectId", dataType = "Integer")
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 设置 项目Id
     * @param projectId 项目Id
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取 组织ID
     * @return organizationId 组织ID
     */
    @ApiModelProperty(value = "组织ID", name = "organizationId", dataType = "Integer[]")
    public Integer[] getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置 组织ID
     * @param organizationId 组织ID
     */
    public void setOrganizationId(Integer[] organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取 金额
     * @return money 金额
     */

    public Float[] getMoney() {
        return money;
    }

    /**
     * 设置 金额
     * @param money 金额
     */
    public void setMoney(Float[] money) {
        this.money = money;
    }

    /**
     * 获取 当前页数
     * @return page 当前页数
     */
    @ApiModelProperty(value = "当前页数", name = "page", dataType = "Integer")
    public Integer getPage() {
        return page;
    }

    /**
     * 设置 当前页数
     * @param page 当前页数
     */
    public void setPage(Integer page) {
        this.page = page;
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
     * 获取 ID
     * @return id ID
     */
    @ApiModelProperty(value = "ID", name = "id", dataType = "Integer")
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
     * 获取 当前组织ID
     * @return curOrganizationId 当前组织ID
     */
    @ApiModelProperty(value = "当前组织ID", name = "curOrganizationId", dataType = "Integer")

    public Integer getCurOrganizationId() {
        return curOrganizationId;
    }


}
