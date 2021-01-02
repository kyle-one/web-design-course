package com.staffmanage.service;


import com.staffmanage.dao.Imp.staffDaoImpl;
import com.staffmanage.dao.staffDao1;
import com.staffmanage.entity.Staff;
import com.staffmanage.entity.Staff1;

import java.util.List;

public class staffServiceImpl implements staffService {
    @Override
    public void addStaff(Staff1 s) {
        staffDao1 sd=new staffDaoImpl();
        sd.addstaff(s);
    }

    @Override
    public void delete(String id) {
        staffDao1 sd=new staffDaoImpl();
        sd.delete(id);
    }

    @Override
    public List<Staff1> getStaffByINPD(String did, String dname, String id, String name) {
          staffDao1 st=new staffDaoImpl();
          return st.getstaffByPDIN(did,dname,id,name);
    }

    @Override
    public void update(Staff1 s) {
        staffDao1 st=new staffDaoImpl();
        st.update(s);
    }

}
