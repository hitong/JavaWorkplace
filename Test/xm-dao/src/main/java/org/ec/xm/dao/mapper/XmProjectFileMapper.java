package org.ec.xm.dao.mapper;

import java.util.List;

import org.ec.xm.dto.XM0202.XM0202A05DTO;
import org.ec.xm.dto.XM0202.XM0202A05InputDTO;
import org.ec.xm.dto.XM0210.XM0210A18DTO;
import org.ec.xm.dto.XM0210.XM0210A18InputDTO;
import org.ec.xm.entity.XmProjectFile;

public interface XmProjectFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XmProjectFile record);

    XmProjectFile selectByPrimaryKey(Integer id);

    List<XmProjectFile> selectAll();

    int updateByPrimaryKey(XmProjectFile record);

    Integer deleteFromProjectFile(Integer id);

    int fileUpLoad(XmProjectFile xmProjectFile);


    List<XmProjectFile> getFileList(Integer fundingId);

    int fileAddApiByTask(XmProjectFile xmProjectFile);

    List<XmProjectFile> getFileListByTaskId(Integer taskId,Integer organizationId);

    int upLoadFile(XmProjectFile xmProjectFile);

    List<XmProjectFile> getFileListAndStatus(Integer taskId,Integer organizationId);

    int changeStatus(XmProjectFile xmProjectFile);

    int changeFileById(XmProjectFile xmProjectFile);

    List<XM0202A05DTO> getMoneyDownFile(XM0202A05InputDTO xm0202A05InputDTO);

    public List<XM0210A18DTO> getAllFileList(XM0210A18InputDTO input);

    public List<XM0210A18DTO> getPriovincFileList(XM0210A18InputDTO input);

    Integer [] getAllProjectFundingId(Integer id);
    Integer deleteFilebByFundingId(Integer id);
}