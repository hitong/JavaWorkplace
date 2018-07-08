package org.ec.xm.dto.XM0209;

import org.ec.utils.dto.RequestDTO;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;

/**
 * XM0209/A07 任务详情退回(区县): 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0209A07InputDTO extends RequestDTO {

    /**
     * 组织ID
     */
    private Integer[] organizationId;

    /**
     * 退回时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date returnedAt;

    /**
     * 退回人ID
     */
    @NotNull(message = "退回人ID不能为空")
    private Integer returnedmanId;


    /**
     * 获取 组织ID
     * @return organizationId 组织ID
     */
    @ApiModelProperty(value = "组织ID", name = "organizationId", dataType = "Integer[]")
    public Integer[] getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置 组织ID
     * @param organizationId 组织ID
     */
    public void setOrganizationId(Integer[] organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取 退回时间
     * @return returnedAt 退回时间
     */
    @ApiModelProperty(value = "退回时间", name = "returnedAt", dataType = "Date")
    public Date getReturnedAt() {
        return returnedAt;
    }

    /**
     * 设置 退回时间
     * @param returnedAt 退回时间
     */
    public void setReturnedAt(Date returnedAt) {
        this.returnedAt = returnedAt;
    }

    /**
     * 获取 退回人ID
     * @return returnedmanId 退回人ID
     */
    @ApiModelProperty(value = "退回人ID", name = "returnedmanId", dataType = "Integer")
    public Integer getReturnedmanId() {
        return returnedmanId;
    }

    /**
     * 设置 退回人ID
     * @param returnedmanId 退回人ID
     */
    public void setReturnedmanId(Integer returnedmanId) {
        this.returnedmanId = returnedmanId;
    }
}
