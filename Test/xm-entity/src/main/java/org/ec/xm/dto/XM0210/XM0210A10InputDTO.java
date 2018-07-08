package org.ec.xm.dto.XM0210;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0210/A10 文件删除(区县): 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0210A10InputDTO extends RequestDTO {

    /**
     * 附件ID
     */
    @NotNull(message = "附件ID不能为空")
    private Integer projectFileId;


    /**
     * 获取 附件ID
     * @return projectFileId 附件ID
     */
    @ApiModelProperty(value = "附件ID", name = "projectFileId", dataType = "Integer")
    public Integer getProjectFileId() {
        return projectFileId;
    }

    /**
     * 设置 附件ID
     * @param projectFileId 附件ID
     */
    public void setProjectFileId(Integer projectFileId) {
        this.projectFileId = projectFileId;
    }
}
