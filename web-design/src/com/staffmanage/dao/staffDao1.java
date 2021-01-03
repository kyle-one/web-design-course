package com.staffmanage.dao;

import com.staffmanage.entity.Staff;
import com.staffmanage.entity.Staff1;

import java.util.List;

public interface staffDao1 {
    //员工入职
    void addstaff(Staff1 s);

    //按id删除员工
    void delete(String id);
    //查询所有员工

    //员工离职中的员工查询
    List<Staff1> getstaffByPDIN(String did,String dname,String id,String name);
    //按照岗位查询
    List<Staff1> getstaffByPostNUm(String pnum);

    void update(Staff1 s);

    void update2(Staff1 s);

}
