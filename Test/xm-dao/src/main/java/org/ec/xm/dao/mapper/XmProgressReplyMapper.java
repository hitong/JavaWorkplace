package org.ec.xm.dao.mapper;

import java.util.List;
import java.util.Map;

import org.ec.xm.entity.XmProgressReply;

public interface XmProgressReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(XmProgressReply record);

    XmProgressReply selectByPrimaryKey(Integer id);

    List<XmProgressReply> selectAll();

    int updateByPrimaryKey(XmProgressReply record);

    int insertReply(XmProgressReply record);

    //获取回复数量
    Integer getProgressReplyNum(Integer progress_id);
    //查看所有相关回复信息
    List<XmProgressReply> getProgressReply(Map map);
    //获取用户名称
    String getProgressReplyUserName(Integer replyman_id);

    Integer deleteFromProgressReply(Integer id);
}