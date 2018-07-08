package org.ec.xm.service;

import org.ec.xm.dto.XM0203.XM0203A09InputDTO;
import org.ec.xm.dto.XM0210.*;

import java.util.List;
/**
 * XM0210: 项目执行 - 资金管理(区县)（资金来源页面(区县)）
 * 作者：
 * 日期：
 */
public interface XM0210Service extends XMBaseService {
    // TODO
    List<XM0210A13DTO>getAllYears(Integer id);
    public List<XM0210A01S01DTO> getListById(String keyword, Integer organazition_id);
    public int addSource(XM0210A05InputDTO input);
    public XM0210A04DTO getAllSource(XM0210A04InputDTO input);

    List<XM0210A16DTO> getAllProjects( XM0210A16InputDTO input);

    List<XM0210A11DTO> getDownTableData(XM0210A11InputDTO xm0210A11InputDTO);

    List<XM0210A13DTO> getAllYearsByOrganization(Integer id);

    List<XM0210A18DTO> getAllFileList( XM0210A18InputDTO input);
}
