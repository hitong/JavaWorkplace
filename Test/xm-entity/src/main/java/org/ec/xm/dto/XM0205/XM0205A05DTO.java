package org.ec.xm.dto.XM0205;

import org.ec.utils.dto.ResponseDTO;
import java.util.List;

/**
 * XM0205/A05 任务详情获取(分页&查询): 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0205A05DTO extends ResponseDTO {

    /**
     * 任务信息
     */
    private List<XM0205A05S01DTO> petitionLetters;


    /**
     * 获取 任务信息
     * @return petitionLetters 任务信息
     */
    public List<XM0205A05S01DTO> getPetitionLetters() {
        return petitionLetters;
    }

    /**
     * 设置 任务信息
     * @param petitionLetters 任务信息
     */
    public void setPetitionLetters(List<XM0205A05S01DTO> petitionLetters) {
        this.petitionLetters = petitionLetters;
    }
}
