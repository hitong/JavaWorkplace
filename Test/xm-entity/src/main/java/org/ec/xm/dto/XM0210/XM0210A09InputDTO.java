package org.ec.xm.dto.XM0210;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * XM0210/A09 文件上传(区县): 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0210A09InputDTO extends RequestDTO {

    /**
     * 项目Id
     */
    @NotNull(message = "项目Id不能为空")
    private Integer projectId;

    /**
     * 来源
     */
    @NotBlank(message = "来源不能为空")
    private String source;

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    private String fileName;

    /**
     * 类型
     */
    @NotBlank(message = "类型不能为空")
    private String fileType;

    /**
     * 是否下发
     */
    @NotNull(message = "是否下发不能为空")
    private Integer status;


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

    /**
     * 获取 名称
     * @return fileName 名称
     */
    @ApiModelProperty(value = "名称", name = "fileName", dataType = "String")
    public String getFilename() {
        return fileName;
    }

    /**
     * 设置 名称
     * @param fileName 名称
     */
    public void setFilename(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取 类型
     * @return fileType 类型
     */
    @ApiModelProperty(value = "类型", name = "fileType", dataType = "String")
    public String getFiletype() {
        return fileType;
    }

    /**
     * 设置 类型
     * @param fileType 类型
     */
    public void setFiletype(String fileType) {
        this.fileType = fileType;
    }

    /**
     * 获取 是否下发
     * @return status 是否下发
     */
    @ApiModelProperty(value = "是否下发", name = "status", dataType = "Integer")
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置 是否下发
     * @param status 是否下发
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
