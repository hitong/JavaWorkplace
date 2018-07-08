package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0203/A02 项目信息: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A02InputDTO extends RequestDTO {

    /**
     * 项目Id
     */
    @NotNull(message = "项目Id不能为空")
    private Integer projectId;

   private  Integer organizaitonId;
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

    public Integer getOrganizaitonId() {
        return organizaitonId;
    }

    public void setOrganizaitonId(Integer organizaitonId) {
        this.organizaitonId = organizaitonId;
    }
}
