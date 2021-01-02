package com.staffmanage.service;


import com.staffmanage.dao.Imp.staffTalentPoolDaoImpl;
import com.staffmanage.dao.staffTalentPoolDao;
import com.staffmanage.entity.staffTalentPool;

import java.util.List;

public class staffTalentPoolServiceImpl implements staffTalentPoolService
{
    @Override
    public void addstaffTalentPool(staffTalentPool s) {
        staffTalentPoolDao st=new staffTalentPoolDaoImpl();
        st.addstaffTalentPool(s);
    }

    @Override
    public void deletestp(String id) {
        staffTalentPoolDao st=new staffTalentPoolDaoImpl();
        st.deletestp(id);
    }

    @Override
    public List<staffTalentPool> getstafftpByNI(String name, String idcardNo) {
        staffTalentPoolDao st=new staffTalentPoolDaoImpl();
        return st.getstafftpByNI(name,idcardNo);
    }
}
