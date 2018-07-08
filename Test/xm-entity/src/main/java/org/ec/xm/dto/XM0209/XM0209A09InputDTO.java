package org.ec.xm.dto.XM0209;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.hibernate.validator.constraints.NotBlank;

/**
 * XM0209/A09 动态信息内容回复(区县): 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0209A09InputDTO extends RequestDTO {

    /**
     * 任务ID
     */
    @NotNull(message = "任务ID不能为空")
    private Integer taskId;

    /**
     * 组织ID
     */
    @NotNull(message = "组织ID不能为空")
    private Integer organizationId;

    /**
     * 动态信息ID
     */
    @NotNull(message = "动态信息ID不能为空")
    private Integer progressId;

    /**
     * 回复人ID
     */
    @NotNull(message = "回复人ID不能为空")
    private Integer replymanId;

    /**
     * 时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空")
    private String content;


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
     * 获取 动态信息ID
     * @return progressId 动态信息ID
     */
    @ApiModelProperty(value = "动态信息ID", name = "progressId", dataType = "Integer")
    public Integer getProgressId() {
        return progressId;
    }

    /**
     * 设置 动态信息ID
     * @param progressId 动态信息ID
     */
    public void setProgressId(Integer progressId) {
        this.progressId = progressId;
    }

    /**
     * 获取 回复人ID
     * @return replymanId 回复人ID
     */
    @ApiModelProperty(value = "回复人ID", name = "replymanId", dataType = "Integer")
    public Integer getReplymanId() {
        return replymanId;
    }

    /**
     * 设置 回复人ID
     * @param replymanId 回复人ID
     */
    public void setReplymanId(Integer replymanId) {
        this.replymanId = replymanId;
    }

    /**
     * 获取 时间
     * @return createdAt 时间
     */
    @ApiModelProperty(value = "时间", name = "createdAt", dataType = "Date")
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置 时间
     * @param createdAt 时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取 内容
     * @return content 内容
     */
    @ApiModelProperty(value = "内容", name = "content", dataType = "String")
    public String getContent() {
        return content;
    }

    /**
     * 设置 内容
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}
