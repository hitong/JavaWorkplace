package org.ec.xm.dto.XM0207;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0207/A09 资料删除(学校): 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0207A09InputDTO extends RequestDTO {

    /**
     * 附件ID
     */
    @NotNull(message = "附件ID不能为空")
    private Integer fileId;


    /**
     * 获取 附件ID
     * @return fileId 附件ID
     */
    @ApiModelProperty(value = "附件ID", name = "fileId", dataType = "Integer")
    public Integer getFileId() {
        return fileId;
    }

    /**
     * 设置 附件ID
     * @param fileId 附件ID
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
}
