package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

/**
 * XM0203/A04 文件上传: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A04InputDTO extends RequestDTO {

    /**
     * 创建者Id
     */
    @NotNull(message = "创建者Id不能为空")
    private Integer creatorId;

    /**
     * 组织ID
     */
    @NotNull(message = "组织ID不能为空")
    private Integer organizationId;

    /**
     * 资金来源ID
     */
    @NotNull(message = "资金来源ID不能为空")
    private Integer fundingId;

    /**
     * 文件
     */
    @NotNull(message = "文件不能为空")
    private MultipartFile file;

    /**
     * 下发
     */
    private Boolean status;

    /**
     * 来源
     */
    private String source;


    /**
     * 获取 创建者Id
     * @return creatorId 创建者Id
     */
    @ApiModelProperty(value = "创建者Id", name = "creatorId", dataType = "Integer")
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * 设置 创建者Id
     * @param creatorId 创建者Id
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
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

    /**
     * 获取 资金来源ID
     * @return fundingId 资金来源ID
     */
    @ApiModelProperty(value = "资金来源ID", name = "fundingId", dataType = "Integer")
    public Integer getFundingId() {
        return fundingId;
    }

    /**
     * 设置 资金来源ID
     * @param fundingId 资金来源ID
     */
    public void setFundingId(Integer fundingId) {
        this.fundingId = fundingId;
    }

    /**
     * 获取 文件
     * @return file 文件
     */
    @ApiModelProperty(value = "文件", name = "file", dataType = "MultipartFile")
    public MultipartFile getFile() {
        return file;
    }

    /**
     * 设置 文件
     * @param file 文件
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * 获取 下发
     * @return status 下发
     */
    @ApiModelProperty(value = "下发", name = "status", dataType = "Boolean")
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置 下发
     * @param status 下发
     */
    public void setStatus(Boolean status) {
        this.status = status;
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
