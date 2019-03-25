package com.httpapi.bmt.service.Impl;

import com.httpapi.bmt.model.Result;
import com.httpapi.bmt.model.Student;

import java.util.List;

public interface UserService {
    public Result login(String phone, String pwd);
    public Result insertUser(String phone,String pwd ,String nickname) ;
    public Result AddAddress(String address,String name,int id);
}
