package org.ec.xm.dto.XM0207;

import org.ec.utils.dto.ResponseDTO;

/**
 * XM0207/A03 资料列表获取(学校): 返回结果
 * 设计者:   李科
 * 更新日期: 2018/4/26
 */
public class XM0207A03DTO extends ResponseDTO {

    /**
     * 文件ID
     */
    private Integer fileId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件大小
     */
    private Integer fileSize;

    /**
     * 文件路径
     */
    private String filePath;


    /**
     * 获取 文件ID
     * @return fileId 文件ID
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     * 设置 文件ID
     * @param fileId 文件ID
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    /**
     * 获取 文件名称
     * @return fileName 文件名称
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置 文件名称
     * @param fileName 文件名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取 文件类型
     * @return fileType 文件类型
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 设置 文件类型
     * @param fileType 文件类型
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * 获取 文件大小
     * @return fileSize 文件大小
     */
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     * 设置 文件大小
     * @param fileSize 文件大小
     */
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * 获取 文件路径
     * @return filePath 文件路径
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 设置 文件路径
     * @param filePath 文件路径
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
