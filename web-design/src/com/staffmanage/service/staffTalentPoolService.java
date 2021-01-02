package com.staffmanage.service;



import com.staffmanage.entity.staffTalentPool;

import java.util.List;

public interface staffTalentPoolService {

    void addstaffTalentPool(staffTalentPool s);

    void deletestp(String id);
    //
    List<staffTalentPool> getstafftpByNI(String name, String idcardNo);
}
