package com.staffmanage.dao;

import com.staffmanage.entity.staffTalentPool;

import java.util.List;

public interface staffTalentPoolDao {

    void addstaffTalentPool(staffTalentPool s);

    void deletestp(String id);
    //
    List<staffTalentPool> getstafftpByNI(String name,String idcardNo);
}
