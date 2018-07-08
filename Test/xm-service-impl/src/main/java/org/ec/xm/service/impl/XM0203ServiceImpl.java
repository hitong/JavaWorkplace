package org.ec.xm.service.impl;

import org.ec.xm.dao.mapper.XmProjectFileMapper;
import org.ec.xm.dao.mapper.*;
import org.ec.xm.dao.mapper.XmMoneySourceMapper;
import org.ec.xm.dao.mapper.XmProjectMapper;
import org.ec.xm.dao.mapper.XmTaskMapper;
import org.ec.xm.dto.XM0203.*;
import org.ec.xm.dto.XM0210.XM0210A04InputDTO;
import org.ec.xm.entity.XmProjectFile;
import org.ec.xm.service.XM0203Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * XM0203: 项目执行 - 项目详情（资金来源页面）
 * 作者：
 * 日期：
 */
@Component
@Transactional
public class XM0203ServiceImpl implements XM0203Service {
    private final XmProjectMapper xmProjectMapper;
    private final XmTaskMapper xmTaskMapper;
    private  final XmMoneySourceMapper xmMoneySourceMapper;
    private final XmProjectConfigMapper xmProjectConfigMapper;
    private final XmFundingMapper xmFundingMapper;
    private final XmProjectFileMapper xmProjectFileMapper;
    private final XmFundingDetailMapper xmFundingDetailMapper;
    public XM0203ServiceImpl(XmProjectMapper xmProjectMapper, XmTaskMapper xmTaskMapper, XmMoneySourceMapper xmMoneySourceMapper, XmProjectConfigMapper xmProjectConfigMapper, XmFundingMapper xmFundingMapper, XmProjectFileMapper xmProjectFileMapper, XmFundingDetailMapper xmFundingDetailMapper) {
        this.xmProjectMapper = xmProjectMapper;
        this.xmTaskMapper = xmTaskMapper;
        this.xmMoneySourceMapper = xmMoneySourceMapper;
        this.xmProjectConfigMapper = xmProjectConfigMapper;
        this.xmFundingMapper = xmFundingMapper;
        this.xmProjectFileMapper = xmProjectFileMapper;
        this.xmFundingDetailMapper = xmFundingDetailMapper;
    }

    @Override
    public XM0203A02DTO getProjectDetailById(Integer id,Integer organizationId) {
        Object totalMoney = xmFundingMapper.getProjectTotalMoney(id, organizationId);
        XM0203A02DTO xm0203A02DTO=  xmProjectMapper.getProjectDetailById(id);
         if(totalMoney!=null){
            xm0203A02DTO.setMoney((double)totalMoney);
             }
            else {
             xm0203A02DTO.setMoney((double)0);
         }
        return xm0203A02DTO;
    }

    @Override
    public List<XM0203A01DTO> getTaskList(XM0203A01InputDTO input) {
        return xmTaskMapper.getTaskListXX(input);
    }

    @Override
    public int addSource(XM0203A09InputDTO input) {
        return xmMoneySourceMapper.addSource(input);
    }

    @Override
    public XM0203A08DTO getAllSource(XM0203A08InputDTO input) {
        return xmMoneySourceMapper.getAllSource(input);
    }

    @Override

    public List<XM0203A12DTO> getAllOrganization(Integer id) {
       if(xmProjectConfigMapper.getParentId(id)!=null){
            return xmProjectConfigMapper.getAllOrganization1(id);
       }
   else{
           return xmProjectConfigMapper.getAllOrganization(id);
       }

    }
    @Override
    public int addMoney(XM0203A03InputDTO xm0203A03InputDTO) throws Exception {
        int type = xmFundingMapper.getOrganizationType(xm0203A03InputDTO.getCurOrganizationId());
        if (type == 1) {
            Object totalMoney = xmFundingMapper.getProjectTotalMoney(xm0203A03InputDTO.getProjectId(), xm0203A03InputDTO.getCurOrganizationId());
            Object havingMoney = xmFundingMapper.getProjectHavingMoney(xm0203A03InputDTO.getProjectId(), xm0203A03InputDTO.getCurOrganizationId());
            double getMoney = 0;
            double remainMoney = 0;
            if (totalMoney == null) {
                throw new Exception("请检查经费是否充足");
            }
            if (havingMoney != null) {
                remainMoney =(double)Math.round(((double)totalMoney - (double) havingMoney)*100)/100;
            } else {
                remainMoney = (double) totalMoney;
            }

            for (int j = 0; j < xm0203A03InputDTO.getMoney().length; j++) {
                if(xm0203A03InputDTO.getMoney()[j]!=null&&xm0203A03InputDTO.getMoney()[j]>0) {
                    getMoney += (double) xm0203A03InputDTO.getMoney()[j];
                }
            }
            getMoney=(double)Math.round(((double)getMoney)*100)/100;
            if (remainMoney >= getMoney) {
                if(getMoney<=0){
                    throw new Exception("请至少输入一位组织的金额");
                }
                if (xm0203A03InputDTO.getOrganizationId().length > 0) {
                    int id = xmFundingMapper.addMoney(xm0203A03InputDTO);
                    int mark1=0;
                    for (int i = 0; i < xm0203A03InputDTO.getOrganizationId().length; i++) {
                        if(xm0203A03InputDTO.getMoney()[i]!=null&&xm0203A03InputDTO.getMoney()[i]>0) {
                         mark1=   xmFundingMapper.addMoneyDetail(xm0203A03InputDTO.getId(), xm0203A03InputDTO.getOrganizationId()[i],
                                    xm0203A03InputDTO.getProjectId(), (double) xm0203A03InputDTO.getMoney()[i]);
                        }
                    }
                    return xm0203A03InputDTO.getId();
                }
                return 0;
            } else {

                throw new Exception("请检查经费是否充足");
            }

        } else if (type == 4) {
            XM0210A04InputDTO xm0210A04InputDTO=new XM0210A04InputDTO();
            xm0210A04InputDTO.setProjectId(xm0203A03InputDTO.getProjectId());
            xm0210A04InputDTO.setOrganizationId(xm0203A03InputDTO.getCurOrganizationId());
            Object totalMoney1=xmMoneySourceMapper.getTotalFromMoneydown(xm0210A04InputDTO);
            Object totalMoney2=xmMoneySourceMapper.getTotalFromMoneysource(xm0210A04InputDTO);
            double totalMoney=0;
            double getMoney = 0;
            if(totalMoney1!=null){
                totalMoney+=(double)totalMoney1;
            }
            if(totalMoney2!=null){
                totalMoney+=(double)totalMoney2;
            }
            if(totalMoney==0){
                throw new Exception("请检查经费是否充足");
            }
            Object havingMoney = xmFundingMapper.getProjectHavingMoney(xm0203A03InputDTO.getProjectId(), xm0203A03InputDTO.getCurOrganizationId());
            double remainMoney = 0;
            if (havingMoney != null) {
                remainMoney = (double) totalMoney - (double) havingMoney;
            } else {
                remainMoney = (double) totalMoney;
            }
            for (int j = 0; j < xm0203A03InputDTO.getMoney().length; j++) {
                if(xm0203A03InputDTO.getMoney()[j]!=null&&xm0203A03InputDTO.getMoney()[j]>0) {
                    getMoney += (double) xm0203A03InputDTO.getMoney()[j];
                }
            }
            if (remainMoney >= getMoney) {
                if(getMoney<=0){
                    throw new Exception("请至少输入一位组织的金额");
                }
                if (xm0203A03InputDTO.getOrganizationId().length > 0) {
                    int id = xmFundingMapper.addMoney(xm0203A03InputDTO);
                    int mark=0;
                    for (int i = 0; i < xm0203A03InputDTO.getOrganizationId().length; i++) {
                        if(xm0203A03InputDTO.getMoney()[i]!=null&&xm0203A03InputDTO.getMoney()[i]>0&&true) {
                          mark=  xmFundingMapper.addMoneyDetail(xm0203A03InputDTO.getId(), xm0203A03InputDTO.getOrganizationId()[i],
                                    xm0203A03InputDTO.getProjectId(), (double) xm0203A03InputDTO.getMoney()[i]);
                        }
                    }
                    return xm0203A03InputDTO.getId();
                }
                return 0;
            } else {

                throw new Exception("请检查经费是否充足");
            }
        }
        return 0;
    }
    public int fileUpLoad(XmProjectFile xmProjectFile){
        return xmProjectFileMapper.fileUpLoad(xmProjectFile);
    }

    public int changeFileById(XmProjectFile xmProjectFile){
        return xmProjectFileMapper.changeFileById(xmProjectFile);
    }

    @Override
    public List<XM0203A06DTO> getDownList(XM0203A06InputDTO input) {

        return xmFundingDetailMapper.getDownList(input);
    }

    @Override
    public List<XM0203A07DTO> getDownDetail(XM0203A07InputDTO input) {
        int type = xmFundingMapper.getOrganizationType(input.getOrganizationId());
        if(type==1){
            input.setOrgType(4);
        }
        else if(type==4){
            input.setOrgType(5);
        }
        List<XM0203A07DTO> list2=new ArrayList<>();
         list2=xmFundingMapper.getDownDetail(input);
        return list2;
    }

    @Override
    public int changeDownDetail(XM0203A13InputDTO input) throws Exception {

        int type = xmFundingMapper.getOrganizationType(input.getCurOrganizationId());
        if (type == 1) {
            Object totalMoney = xmFundingMapper.getProjectTotalMoney(input.
                    getProjectId(), input.getCurOrganizationId());
            Object havingMoney = xmFundingMapper.getProjectHavingMoney(input.getProjectId(), input.getCurOrganizationId());
            double getMoney = 0;
            double remainMoney = 0;
            if (totalMoney == null) {
                throw new Exception("请检查经费是否充足");
            }
            if (havingMoney != null) {
                remainMoney = (double) totalMoney - (double) havingMoney;
            } else {
                remainMoney = (double) totalMoney;
            }
            for (int j = 0; j < input.getMoney().length; j++) {
                if(input.getMoney()[j]!=null&&input.getMoney()[j]>0) {
                    getMoney += (double) input.getMoney()[j];
                }
            }

            Object fundingTotal= xmFundingDetailMapper.getTotalMoneyByFundingId(input.getFundingId());
            double realFundingTotal=0;
            if(fundingTotal!=null){
                realFundingTotal=(double)fundingTotal;
            }
            if (remainMoney >= (getMoney-realFundingTotal)) {
                if(getMoney<0){
                    throw new Exception("请至少输入一位组织的金额");
                }
                int mark=0;
                Integer[] allId=xmFundingDetailMapper.selectAllIdByFundingId(input.getFundingId());
                 //    if((double)input.getMoney()[i]==0){
                  //       xmFundingDetailMapper.deleteFundingDetatilById(input.getFundingId(),input.getOrganizationId()[i]);
                 //    }
                 //     else {
                    for(int m=0;m<input.getMoney().length;m++){
                        if(input.getMoney()[m]!=null&&!input.getMoney()[m].equals("")){
                            for(int j=0;j<allId.length;j++){
                                if(allId[j]==input.getOrganizationId()[m]){
                                    xmFundingDetailMapper.changeDownDetail(input.getFundingId(), input.getOrganizationId()[m], (double) input.getMoney()[m]);
                                    allId[j]=0;
                                   break;
                                }
                                if(j==allId.length-1)
                                xmFundingMapper.addMoneyDetail(input.getFundingId(), input.getOrganizationId()[m],
                                        input.getProjectId(), (double) input.getMoney()[m]);
                            }
                        }
                    }
                    for(int k=0;k<allId.length;k++){
                        if(allId[k]!=0){
                            xmFundingDetailMapper.changeDownDetail(input.getFundingId(),allId[k], (double)0);
                        }
                    }
                  //   }

                return 1;
            }
         else{
                throw new Exception("请检查经费是否充足");
            }

        }
        else if (type==4){

            XM0210A04InputDTO xm0210A04InputDTO=new XM0210A04InputDTO();
            xm0210A04InputDTO.setProjectId(input.getProjectId());
            xm0210A04InputDTO.setOrganizationId(input.getCurOrganizationId());
            Object totalMoney1=xmMoneySourceMapper.getTotalFromMoneydown(xm0210A04InputDTO);
            Object totalMoney2=xmMoneySourceMapper.getTotalFromMoneysource(xm0210A04InputDTO);
            double totalMoney=0;
            double getMoney = 0;
            if(totalMoney1!=null){
                totalMoney+=(double)totalMoney1;
            }
            if(totalMoney2!=null){
                totalMoney+=(double)totalMoney2;
            }
            if(totalMoney==0){
                throw new Exception("请检查经费是否充足");
            }
            Object havingMoney = xmFundingMapper.getProjectHavingMoney(input.getProjectId(), input.getCurOrganizationId());
            double remainMoney = 0;
            if (havingMoney != null) {
                remainMoney = (double) totalMoney - (double) havingMoney;
            } else {
                remainMoney = (double) totalMoney;
            }
            for (int j = 0; j < input.getMoney().length; j++) {
                getMoney += (double) input.getMoney()[j];
            }
            Object fundingTotal= xmFundingDetailMapper.getTotalMoneyByFundingId(input.getFundingId());
            double realFundingTotal=0;
            if(fundingTotal!=null){
                realFundingTotal=(double)fundingTotal;
            }
            if (remainMoney >= (getMoney-realFundingTotal)) {
                int mark=0;
                if(getMoney<0){
                    throw new Exception("请至少输入一位组织的金额");
                }
                Integer[] allId=xmFundingDetailMapper.selectAllIdByFundingId(input.getFundingId());
                //    if((double)input.getMoney()[i]==0){
                //       xmFundingDetailMapper.deleteFundingDetatilById(input.getFundingId(),input.getOrganizationId()[i]);
                //    }
                //     else {
                for(int m=0;m<input.getMoney().length;m++){
                    if(input.getMoney()[m]!=null&&!input.getMoney()[m].equals("")){
                        for(int j=0;j<allId.length;j++){
                            if(allId[j]==input.getOrganizationId()[m]){
                                xmFundingDetailMapper.changeDownDetail(input.getFundingId(), input.getOrganizationId()[m], (double) input.getMoney()[m]);
                                allId[j]=0;
                                break;
                            }
                            if(j==allId.length-1)
                                xmFundingMapper.addMoneyDetail(input.getFundingId(), input.getOrganizationId()[m],
                                        input.getProjectId(), (double) input.getMoney()[m]);
                        }
                    }
                }
                for(int k=0;k<allId.length;k++){
                    if(allId[k]!=0){
                        xmFundingDetailMapper.changeDownDetail(input.getFundingId(),allId[k], (double)0);
                    }
                }
                return mark;
            } else {

                throw new Exception("请检查经费是否充足");
            }



        }
        else{
            return 0;
        }
    }


    public List<XmProjectFile> getFileList(Integer fundingId){
        return xmProjectFileMapper.getFileList(fundingId);
    }

    @Override
    public int deleteFile(Integer fileId){
        return xmProjectFileMapper.deleteByPrimaryKey(fileId);
    }

    @Override
    public List<XM0203A16DTO> getSchoolDeatail(XM0203A16InputDTO input) {
        return xmFundingDetailMapper.getSchoolDeatail(input);
    }

    @Override
    public double[] getRemainMoney(Integer organizationId, Integer projectId) {
        int type = xmFundingMapper.getOrganizationType(organizationId);
        if (type == 1) {
            Object totalMoney = xmFundingMapper.getProjectTotalMoney(projectId, organizationId);
            Object havingMoney = xmFundingMapper.getProjectHavingMoney(projectId, organizationId);
            double getMoney = 0;
            double tot=0;
            double remainMoney = 0;
            if (totalMoney != null) {
                  tot=(double)totalMoney;
            }
            if (havingMoney != null) {
                remainMoney = tot - (double) havingMoney;
            } else {
                remainMoney = tot;
            }
            double [] array=new double[2];
              array[0]=tot;
              array[1]=remainMoney;
            return  array;
        }
         else if(type==4){
            XM0210A04InputDTO xm0210A04InputDTO=new XM0210A04InputDTO();
            xm0210A04InputDTO.setProjectId(projectId);
            xm0210A04InputDTO.setOrganizationId(organizationId);
            Object totalMoney1=xmMoneySourceMapper.getTotalFromMoneydown(xm0210A04InputDTO);
            Object totalMoney2=xmMoneySourceMapper.getTotalFromMoneysource(xm0210A04InputDTO);
            double totalMoney=0;
            double getMoney = 0;
            double [] array=new double[2];
            if(totalMoney1!=null){
                totalMoney+=(double)totalMoney1;
            }
            if(totalMoney2!=null){
                totalMoney+=(double)totalMoney2;
            }
            if(totalMoney==0){
                array[0]=0;
                array[1]=0;
                return  array;
            }
            Object havingMoney = xmFundingMapper.getProjectHavingMoney(projectId, organizationId);
            double remainMoney = 0;
            if (havingMoney != null) {
                remainMoney = (double) totalMoney - (double) havingMoney;
            } else {
                remainMoney = (double) totalMoney;
            }

            array[0]=totalMoney;
            array[1]=remainMoney;
            return  array;
        }
        double [] array=new double[]{0,0};
        return array;
    }
}
