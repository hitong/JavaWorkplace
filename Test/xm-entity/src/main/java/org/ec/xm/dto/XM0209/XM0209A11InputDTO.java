package org.ec.xm.dto.XM0209;

import org.ec.utils.dto.RequestDTO;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0209/A11 资料上传提交(区县): 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0209A11InputDTO extends RequestDTO {

    /**
     * 文件
     */
    @NotNull(message = "文件不能为空")
    private MultipartFile file;

    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID不能为空")
    private Integer creatorId;

    /**
     * 组织ID
     */
    @NotNull(message = "组织ID不能为空")
    private Integer organizationId;

    /**
     * 任务ID
     */
    @NotNull(message = "任务ID不能为空")
    private Integer taskId;


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
     * 获取 任务ID
     * @return taskId 任务ID
     */
    @ApiModelProperty(value = "任务ID", name = "taskId", dataType = "Integer")
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * 设置 任务ID
     * @param taskId 任务ID
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}
