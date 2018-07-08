package org.ec.xm.dto.XM0210;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0210/A18 资金下达文件列表获取: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0210A18InputDTO extends RequestDTO {

     private Integer projectId;
    /**
     * 资金下达ID
     */
    @NotNull(message = "资金下达ID不能为空")
    private Integer organizationId;


    /**
     * 获取 资金下达ID
     * @return organizationId 资金下达ID
     */
    @ApiModelProperty(value = "资金下达ID", name = "organizationId", dataType = "Integer")
    public Integer getorganizationId() {
        return organizationId;
    }

    /**
     * 设置 资金下达ID
     * @param organizationId 资金下达ID
     */
    public void setorganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
