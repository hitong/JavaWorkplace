package org.ec.xm.dao.mapper;

import java.util.List;
import org.ec.xm.entity.XmTaskRecord;

public interface XmTaskRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XmTaskRecord record);

    XmTaskRecord selectByPrimaryKey(Integer id);

    List<XmTaskRecord> selectAll();

    int updateByPrimaryKey(XmTaskRecord record);

    Integer deleteFromTaskRecord(Integer id);
}