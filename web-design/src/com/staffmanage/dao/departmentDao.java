package com.staffmanage.dao;

import com.staffmanage.entity.Department;

import java.util.List;

public interface departmentDao {
    //添加部门
    void addDepartment(Department dep);

    //查询部门
    void queryDepartment(Department dep);

    //删除部门
    void deleteDepartment(String[] dnumList);

    //获取所有部门
    List<Department> getAllDepartment();

    //根据dnum，dname，type查询部门
    List<Department> getByDnumAndDnameAndType(String dnum, String dname, String type);

    //更新部门
    void updateDepartment(Department dep);

}

