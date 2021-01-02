package com.staffmanage.dao;

import com.staffmanage.entity.DepartmentTransfer;
import com.staffmanage.entity.PostTransfer;
import com.staffmanage.entity.view.DepartmentTransferView;
import com.staffmanage.entity.view.PostTransferView;

import java.util.List;

public interface postTransferDao {
    void add(PostTransfer postTransfer);

    List<PostTransfer> getAll();

    List<PostTransferView> getByTimeAndSidAndSnameAndType(String startime, String endtime, String sid, String sname, String type);
}
