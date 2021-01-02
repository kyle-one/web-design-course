package com.staffmanage.dao;

import com.staffmanage.entity.DepartmentTransfer;
import com.staffmanage.entity.view.DepartmentTransferView;

import java.util.List;

public interface departmentTransferDao {
    void add(DepartmentTransfer departmentTransfer);

    List<DepartmentTransfer> getAll();

    List<DepartmentTransferView> getByTimeAndSidAndSnameAndType(String startime, String endtime, String sid, String sname, String type);
}
