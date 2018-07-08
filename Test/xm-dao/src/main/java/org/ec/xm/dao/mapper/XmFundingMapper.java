package org.ec.xm.dao.mapper;

import java.util.List;
import java.util.Map;

import org.ec.xm.dto.XM0202.XM0202A04DTO;
import org.ec.xm.dto.XM0202.XM0202A04InputDTO;
import org.ec.xm.dto.XM0203.XM0203A03InputDTO;
import org.ec.xm.dto.XM0203.XM0203A07DTO;
import org.ec.xm.dto.XM0203.XM0203A07InputDTO;
import org.ec.xm.dto.XM0210.XM0210A11DTO;
import org.ec.xm.dto.XM0210.XM0210A11InputDTO;
import org.ec.xm.entity.XmFunding;

public interface XmFundingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XmFunding record);

    XmFunding selectByPrimaryKey(Integer id);

    List<XmFunding> selectAll();

    int updateByPrimaryKey(XmFunding record);

    Integer deleteFromFunding(Integer id);

    int addMoney(XM0203A03InputDTO xm0203A03InputDTO);

  int addMoneyDetail(Integer funding_id,Integer organization_id,Integer project_id,Double money);

    List<XM0203A07DTO> getDownDetail(XM0203A07InputDTO input);

    List<XM0210A11DTO> getDownTableData(XM0210A11InputDTO xm0210A11InputDTO);

    List<XM0202A04DTO> getTotalMoney(XM0202A04InputDTO input);

    List<Map> projectMap(Integer id);

    Object getProjectTotalMoney(Integer projectId,Integer organizationId);

    Object getProjectHavingMoney(Integer projectId,Integer organizationId);

    int getOrganizationType(Integer id);
}