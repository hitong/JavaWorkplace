package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * XM0203/A17 文件编辑: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A17InputDTO extends RequestDTO {

    /**
     * 文件ID
     */
    @NotNull(message = "文件ID不能为空")
    private Integer fileId;

    /**
     * 文件来源
     */
    @NotBlank(message = "文件来源不能为空")
    private String source;

    /**
     * 是否下发
     */
    private Boolean status;


    /**
     * 获取 文件ID
     * @return fileId 文件ID
     */
    @ApiModelProperty(value = "文件ID", name = "fileId", dataType = "Integer")
    public Integer getFileId() {
        return fileId;
    }

    /**
     * 设置 文件ID
     * @param fileId 文件ID
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    /**
     * 获取 文件来源
     * @return source 文件来源
     */
    @ApiModelProperty(value = "文件来源", name = "source", dataType = "String")
    public String getSource() {
        return source;
    }

    /**
     * 设置 文件来源
     * @param source 文件来源
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 获取 是否下发
     * @return status 是否下发
     */
    @ApiModelProperty(value = "是否下发", name = "status", dataType = "Boolean")
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置 是否下发
     * @param status 是否下发
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }
}
