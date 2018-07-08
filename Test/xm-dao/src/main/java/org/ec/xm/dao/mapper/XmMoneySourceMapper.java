package org.ec.xm.dao.mapper;

import java.util.List;

import org.ec.xm.dto.XM0203.XM0203A08DTO;
import org.ec.xm.dto.XM0203.XM0203A08InputDTO;
import org.ec.xm.dto.XM0203.XM0203A09InputDTO;
import org.ec.xm.dto.XM0210.XM0210A04DTO;
import org.ec.xm.dto.XM0210.XM0210A04InputDTO;
import org.ec.xm.dto.XM0210.XM0210A05InputDTO;
import org.ec.xm.entity.XmMoneySource;

public interface XmMoneySourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XmMoneySource record);

    XmMoneySource selectByPrimaryKey(Integer id);

    List<XmMoneySource> selectAll();

    int updateByPrimaryKey(XmMoneySource record);


    Integer deleteFromMoneySource(Integer id);

    Integer addSource(XM0203A09InputDTO input);

    XM0203A08DTO getAllSource(XM0203A08InputDTO input);

    Integer addSource1(XM0210A05InputDTO input);

    XM0210A04DTO getAllSource1(XM0210A04InputDTO input);

      Object   getTotalFromMoneysource(XM0210A04InputDTO input);
      Object   getTotalFromMoneydown(XM0210A04InputDTO input);
}