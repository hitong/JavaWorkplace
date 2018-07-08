package org.ec.xm.service;

import org.ec.xm.dto.XM0203.*;
import org.ec.xm.entity.XmProjectFile;

import java.util.List;

/**
 * XM0203: 项目执行 - 项目详情（资金来源页面）
 * 作者：
 * 日期：
 */
public interface XM0203Service extends XMBaseService {
    // TODO
   public  XM0203A02DTO getProjectDetailById(Integer id,Integer organizationId);
   public List<XM0203A01DTO> getTaskList(XM0203A01InputDTO input);
   public int addSource(XM0203A09InputDTO input);
   public XM0203A08DTO getAllSource(XM0203A08InputDTO input);
   public List<XM0203A12DTO> getAllOrganization(Integer id);
   public   int  addMoney(XM0203A03InputDTO xm0203A03InputDTO) throws Exception;
    public int fileUpLoad(XmProjectFile xmProjectFile);

    public  List<XM0203A06DTO> getDownList(XM0203A06InputDTO input);
    public  List<XM0203A07DTO> getDownDetail(XM0203A07InputDTO input);
     public int changeDownDetail(XM0203A13InputDTO input) throws Exception;

    //文件列表获取
    public List<XmProjectFile> getFileList(Integer fundindId);

    //文件删除
    public int deleteFile(Integer fileId);

    public int changeFileById(XmProjectFile xmProjectFile);

    List<XM0203A16DTO> getSchoolDeatail(XM0203A16InputDTO input);
     double[] getRemainMoney(Integer organizationId,Integer projectId);
}
