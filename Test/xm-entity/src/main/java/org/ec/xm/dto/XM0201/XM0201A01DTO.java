package org.ec.xm.dto.XM0201;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0201/A01 年度任务状态获取: 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0201A01DTO extends ResponseDTO {

    /**
     * 年度
     */
    private String year;

    /**
     * 全部
     */
    private Integer allTask;

    /**
     * 待下发
     */
    private Integer beforeSend;

    /**
     * 执行中
     */
    private Integer execution;

    /**
     * 执行完成
     */
    private Integer finish;

    /**
     * 超时
     */
    private Integer timeout;

    /**
     * 退回
     */
    private Integer returnNum;

    /**
     * 催报
     */
    private Integer urgeNum;


    /**
     * 获取 年度
     * @return year 年度
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置 年度
     * @param year 年度
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取 全部
     * @return allTask 全部
     */
    public Integer getAllTask() {
        return allTask;
    }

    /**
     * 设置 全部
     * @param allTask 全部
     */
    public void setAllTask(Integer allTask) {
        this.allTask = allTask;
    }

    /**
     * 获取 待下发
     * @return beforeSend 待下发
     */
    public Integer getBeforeSend() {
        return beforeSend;
    }

    /**
     * 设置 待下发
     * @param beforeSend 待下发
     */
    public void setBeforeSend(Integer beforeSend) {
        this.beforeSend = beforeSend;
    }

    /**
     * 获取 执行中
     * @return execution 执行中
     */
    public Integer getExecution() {
        return execution;
    }

    /**
     * 设置 执行中
     * @param execution 执行中
     */
    public void setExecution(Integer execution) {
        this.execution = execution;
    }

    /**
     * 获取 执行完成
     * @return finish 执行完成
     */
    public Integer getFinish() {
        return finish;
    }

    /**
     * 设置 执行完成
     * @param finish 执行完成
     */
    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    /**
     * 获取 超时
     * @return timeout 超时
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     * 设置 超时
     * @param timeout 超时
     */
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    /**
     * 获取 退回
     * @return returnNum 退回
     */
    public Integer getReturnNum() {
        return returnNum;
    }

    /**
     * 设置 退回
     * @param returnNum 退回
     */
    public void setReturnNum(Integer returnNum) {
        this.returnNum = returnNum;
    }

    /**
     * 获取 催报
     * @return urgeNum 催报
     */
    public Integer getUrgeNum() {
        return urgeNum;
    }

    /**
     * 设置 催报
     * @param urgeNum 催报
     */
    public void setUrgeNum(Integer urgeNum) {
        this.urgeNum = urgeNum;
    }
}
