package com.httpapi.bmt.dao;

import com.httpapi.bmt.model.Result;
import com.httpapi.bmt.model.Student;

import java.util.List;

public interface UserDao {
    public List<Student> login(String phone, String pwd) ;
    public List<Student> insertUser(String phone, String pwd,String nickname) ;
    public void AddAddress(String address,String name,int id);


}
