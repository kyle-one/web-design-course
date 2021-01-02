package com.staffmanage.service;



import com.staffmanage.dao.Imp.staffQuitDaoImpl;
import com.staffmanage.dao.staffQuitDao;
import com.staffmanage.entity.staffQuit;

import java.util.List;

public class staffQuitServiceImpl implements staffQuitService{
    @Override
    public void addstaffQuit(staffQuit s) {
        staffQuitDao sd=new staffQuitDaoImpl();
        sd.addstaffQuit(s);
    }

    @Override
    public List<staffQuit> getstaffQuitByINDPTSE(String id, String name, String dname, String pname, String type, String startDayte, String endDate) {
        staffQuitDao sd=new staffQuitDaoImpl();
        return sd.getstaffQuitByINDPTSE(id,name,dname,pname,type,startDayte,endDate);
    }
}
