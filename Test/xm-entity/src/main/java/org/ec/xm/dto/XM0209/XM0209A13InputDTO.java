package org.ec.xm.dto.XM0209;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0209/A13 文件下发状态改变: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0209A13InputDTO extends RequestDTO {

    /**
     * 文件ID
     */
    @NotNull(message = "文件ID不能为空")
    private Integer fileId;

    /**
     * 状态
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
     * 获取 状态
     * @return status 状态
     */
    @ApiModelProperty(value = "状态", name = "status", dataType = "Boolean")
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置 状态
     * @param status 状态
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }
}
