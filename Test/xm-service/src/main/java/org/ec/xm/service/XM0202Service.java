package org.ec.xm.service;

import org.ec.xm.dto.XM0202.*;

import java.util.List;
/**
 * XM0202: 项目执行 - 项目管理（项目管理页面）
 * 作者：
 * 日期：
 */
public interface XM0202Service extends XMBaseService {
    // TODO
    public int addProject(XM0202A03InputDTO input) throws Exception;
    public List<XM0202A01S01DTO> getListById(String keyword, Integer organazition_id);
    List<XM0202A02DTO>getAllYears(Integer id);
    int updateProjectById(XM0202A06InputDTO input);
    int sureProject(Integer id);
    int deleteProject(Integer id);
    List<XM0202A04DTO> getDownDetail(XM0202A04InputDTO input);
    List<XM0202A05DTO> getFileList(XM0202A05InputDTO input);
}