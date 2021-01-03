package com.staffmanage.service;

import com.staffmanage.entity.Staff;
import com.staffmanage.entity.Staff1;


import java.util.List;

public interface staffService {

    void addStaff(Staff1 s);

    void delete(String id);

    List<Staff1> getStaffByINPD(String did, String dname, String id, String name);

    void update(Staff1 s);

    List<Staff1> getStaffByPostNum(String pnum);
}
