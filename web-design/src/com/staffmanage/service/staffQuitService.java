package com.staffmanage.service;



import com.staffmanage.entity.staffQuit;

import java.util.List;

public interface staffQuitService {
    //员工离职(加入离职表)
    void addstaffQuit(staffQuit s);
    //离职员工查询
    List<staffQuit> getstaffQuitByINDPTSE(String id, String name, String dname, String pname, String type , String startDayte, String endDate);
}
