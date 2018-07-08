package org.ec.xm.dto.XM0207;

import org.ec.utils.dto.ResponseDTO;
import java.util.List;

/**
 * XM0207/A05 动态信息内容获取(分页&查询)(学校): 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0207A05DTO extends ResponseDTO {

    /**
     * 内容信息
     */
    private List<XM0207A05S01DTO> contentLetters;


    /**
     * 获取 内容信息
     * @return contentLetters 内容信息
     */
    public List<XM0207A05S01DTO> getContentLetters() {
        return contentLetters;
    }

    /**
     * 设置 内容信息
     * @param contentLetters 内容信息
     */
    public void setContentLetters(List<XM0207A05S01DTO> contentLetters) {
        this.contentLetters = contentLetters;
    }
}
