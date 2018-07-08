package org.ec.xm.dto.XM0205;

import org.ec.utils.dto.RequestDTO;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;

/**
 * XM0205/A06 任务详情催报: 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0205A06InputDTO extends RequestDTO {

    /**
     * 组织ID
     */
    private Integer[] organizationId;

    /**
     * 催报时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date urgedAt;

    /**
     * 催报人ID
     */
    @NotNull(message = "催报人ID不能为空")
    private Integer urgemanId;


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
     * 获取 催报时间
     * @return urgedAt 催报时间
     */
    @ApiModelProperty(value = "催报时间", name = "urgedAt", dataType = "Date")
    public Date getUrgedAt() {
        return urgedAt;
    }

    /**
     * 设置 催报时间
     * @param urgedAt 催报时间
     */
    public void setUrgedAt(Date urgedAt) {
        this.urgedAt = urgedAt;
    }

    /**
     * 获取 催报人ID
     * @return urgemanId 催报人ID
     */
    @ApiModelProperty(value = "催报人ID", name = "urgemanId", dataType = "Integer")
    public Integer getUrgemanId() {
        return urgemanId;
    }

    /**
     * 设置 催报人ID
     * @param urgemanId 催报人ID
     */
    public void setUrgemanId(Integer urgemanId) {
        this.urgemanId = urgemanId;
    }
}
