package com.staffmanage.dao;

import com.staffmanage.entity.Administrators;

public interface LoginDao {
    public Administrators getUserAndPassword(String name, String password);
}
