package org.ec.xm.dto.XM0207;

import org.ec.utils.dto.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * XM0207/A04 最新动态回复查看(学校): 请求参数
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0207A04InputDTO extends RequestDTO {

    /**
     * 动态信息ID
     */
    @NotNull(message = "动态信息ID不能为空")
    private Integer progressId;

    /**
     * 当前页
     */
    @NotNull(message = "当前页不能为空")
    private Integer page;

    /**
     * 分页大小
     */
    @NotNull(message = "分页大小不能为空")
    private Integer pageSize;


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
     * 获取 当前页
     * @return page 当前页
     */
    @ApiModelProperty(value = "当前页", name = "page", dataType = "Integer")
    public Integer getPage() {
        return page;
    }

    /**
     * 设置 当前页
     * @param page 当前页
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * 获取 分页大小
     * @return pageSize 分页大小
     */
    @ApiModelProperty(value = "分页大小", name = "pageSize", dataType = "Integer")
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置 分页大小
     * @param pageSize 分页大小
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
