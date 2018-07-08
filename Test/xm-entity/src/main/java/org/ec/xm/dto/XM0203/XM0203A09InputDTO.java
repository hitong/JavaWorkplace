package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * XM0203/A09 资金来源新增: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A09InputDTO extends RequestDTO {

    /**
     * 金额
     */
    @NotNull(message = "金额不能为空")
    private Double money;

    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空")
    private Integer projectId;

    /**
     * 创建人ID
     */
    private Integer creatorId;

    /**
     * 所属组织ID
     */
    @NotNull(message = "所属组织ID不能为空")
    private Integer organizationId;

    /**
     * 来源
     */
    @NotBlank(message = "来源不能为空")
    private String source;


    /**
     * 获取 金额
     * @return money 金额
     */
    @ApiModelProperty(value = "金额", name = "money", dataType = "Double")
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
     * 获取 项目ID
     * @return projectId 项目ID
     */
    @ApiModelProperty(value = "项目ID", name = "projectId", dataType = "Integer")
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 设置 项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取 创建人ID
     * @return creatorId 创建人ID
     */
    @ApiModelProperty(value = "创建人ID", name = "creatorId", dataType = "Integer")
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * 设置 创建人ID
     * @param creatorId 创建人ID
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取 所属组织ID
     * @return organizationId 所属组织ID
     */
    @ApiModelProperty(value = "所属组织ID", name = "organizationId", dataType = "Integer")
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置 所属组织ID
     * @param organizationId 所属组织ID
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取 来源
     * @return source 来源
     */
    @ApiModelProperty(value = "来源", name = "source", dataType = "String")
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
}
