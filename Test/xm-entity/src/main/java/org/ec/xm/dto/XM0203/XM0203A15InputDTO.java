package org.ec.xm.dto.XM0203;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0203/A15 区县下达筛选树获取: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0203A15InputDTO extends RequestDTO {

    /**
     * 项目ID
     */
    @NotNull(message = "项目ID不能为空")
    private Integer projectId;


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
}
