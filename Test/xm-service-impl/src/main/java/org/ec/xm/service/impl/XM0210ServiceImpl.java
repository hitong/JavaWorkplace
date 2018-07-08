package org.ec.xm.service.impl;

import org.ec.xm.dao.mapper.*;
import org.ec.xm.dto.XM0210.*;
import org.ec.xm.service.XM0210Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * XM0210: 项目执行 - 资金管理(区县)（资金来源页面(区县)）
 * 作者：
 * 日期：
 */
@Component
@Transactional
public class XM0210ServiceImpl implements XM0210Service {
    private final XmProjectMapper xmProjectMapper;
    private  final XmMoneySourceMapper xmMoneySourceMapper;
    private final XmFundingDetailMapper xmFundingDetailMapper;
    private final XmFundingMapper xmFundingMapper;
   private final XmProjectFileMapper xmProjectFileMapper;
    public XM0210ServiceImpl(XmProjectMapper xmProjectMapper, XmMoneySourceMapper xmMoneySourceMapper, XmFundingDetailMapper xmFundingDetailMapper, XmFundingMapper xmFundingMapper, XmProjectFileMapper xmProjectFileMapper) {
        this.xmProjectMapper = xmProjectMapper;
        this.xmMoneySourceMapper = xmMoneySourceMapper;
        this.xmFundingDetailMapper = xmFundingDetailMapper;
        this.xmFundingMapper = xmFundingMapper;
        this.xmProjectFileMapper = xmProjectFileMapper;
    }

    @Override
    public List<XM0210A13DTO> getAllYears(Integer id) {
        List<XM0210A13DTO> xm0210A13DTOList=xmProjectMapper.getAllYears1(id);
        return  xm0210A13DTOList;
    }

    @Override
    public List<XM0210A01S01DTO> getListById(String keyword, Integer organazition_id) {
        List<XM0210A01S01DTO> list =new   ArrayList<XM0210A01S01DTO>();
        list=xmProjectMapper.selectAllById1(keyword,organazition_id);
        for(int i=0;i<list.size();i++){
            XM0210A04InputDTO input=new XM0210A04InputDTO();
            input.setProjectId(list.get(i).getProjectId());
            input.setOrganizationId(organazition_id);
            Object totalMoney1=xmMoneySourceMapper.getTotalFromMoneydown(input);
            Object totalMoney2=xmMoneySourceMapper.getTotalFromMoneysource(input);
            double totalMoney=0;
            double provinceMoney=0;
            if(totalMoney1!=null){
                totalMoney+=(double)totalMoney1;
            }
            if(totalMoney2!=null){
                totalMoney+=(double)totalMoney2;
                provinceMoney=(double)totalMoney2;
            }
            list.get(i).setTotalMoney(totalMoney);
            list.get(i).setProvinceMoney(provinceMoney);
        }
        return  list;
    }

    @Override
    public int addSource(XM0210A05InputDTO input) {
        return xmMoneySourceMapper.addSource1(input);
    }

    @Override
    public XM0210A04DTO getAllSource(XM0210A04InputDTO input) {

                 Object totalMoney1=xmMoneySourceMapper.getTotalFromMoneydown(input);
                 Object totalMoney2=xmMoneySourceMapper.getTotalFromMoneysource(input);
                 double totalMoney=0;
                 double superMoney=0;
                 double provinceMoney=0;
           if(totalMoney1!=null){
               totalMoney+=(double)totalMoney1;
               superMoney=(double)totalMoney1;
           }
            if(totalMoney2!=null){
             totalMoney+=(double)totalMoney2;
                provinceMoney=(double)totalMoney2;
            }
        XM0210A04DTO xm0210A04DTO= xmMoneySourceMapper.getAllSource1(input);
         xm0210A04DTO.setTotalMoney(totalMoney);
         xm0210A04DTO.setSuperMoney(superMoney);
         xm0210A04DTO.setProvinceMoney(provinceMoney);
        return xmMoneySourceMapper.getAllSource1(input);
    }

    @Override
    public List<XM0210A16DTO> getAllProjects(XM0210A16InputDTO input) {
        return xmFundingDetailMapper.getAllProjects(input);
    }

    @Override
    public List<XM0210A11DTO> getDownTableData(XM0210A11InputDTO xm0210A11InputDTO) {
        return xmFundingMapper.getDownTableData(xm0210A11InputDTO);
    }

    @Override
    public List<XM0210A13DTO> getAllYearsByOrganization(Integer id) {
        return xmFundingDetailMapper.getAllYearsByOrganization(id);
    }

    @Override
    public List<XM0210A18DTO> getAllFileList(XM0210A18InputDTO input) {
        List<XM0210A18DTO> xm0210A18DTOS=new ArrayList<>();
        int type = xmFundingMapper.getOrganizationType(input.getorganizationId());
        if(type==1) {
            return xmProjectFileMapper.getAllFileList(input);
        }
        else if(type==4){
       return  xmProjectFileMapper.getPriovincFileList(input);
        }
     return xm0210A18DTOS;
    }


}
