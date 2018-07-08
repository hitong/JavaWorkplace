package org.ec.xm.dao.mapper;

import java.util.List;

import org.ec.xm.dto.XM0203.XM0203A06DTO;
import org.ec.xm.dto.XM0203.XM0203A06InputDTO;
import org.ec.xm.dto.XM0203.XM0203A16DTO;
import org.ec.xm.dto.XM0203.XM0203A16InputDTO;
import org.ec.xm.dto.XM0210.XM0210A13DTO;
import org.ec.xm.dto.XM0210.XM0210A16DTO;
import org.ec.xm.dto.XM0210.XM0210A16InputDTO;
import org.ec.xm.entity.XmFundingDetail;

public interface XmFundingDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XmFundingDetail record);

    XmFundingDetail selectByPrimaryKey(Integer id);

    List<XmFundingDetail> selectAll();

    int updateByPrimaryKey(XmFundingDetail record);

    Integer deleteFromFundingDetail(Integer id);

    public List<XM0203A06DTO> getDownList(XM0203A06InputDTO input);

    public int changeDownDetail(Integer fundingId,Integer organizationId,Double money);

     public List<XM0210A16DTO> getAllProjects(XM0210A16InputDTO input);

    public List<XM0203A16DTO> getSchoolDeatail(XM0203A16InputDTO input);

    List<XM0210A13DTO> getAllYearsByOrganization(Integer id);

    Object getTotalMoneyByFundingId(Integer id);


    int deleteFundingDetatilById(Integer id,Integer id1);

    Integer[] selectAllIdByFundingId(Integer id);
}