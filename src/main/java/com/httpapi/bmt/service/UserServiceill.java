package com.httpapi.bmt.service;


import com.httpapi.bmt.dao.UserDao;
import com.httpapi.bmt.model.MD5Utils;
import com.httpapi.bmt.model.Result;
import com.httpapi.bmt.model.Student;
import com.httpapi.bmt.service.Impl.UserService;
import com.httpapi.bmt.utils.Resultsutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceill implements UserService {
    @Autowired
    private UserDao userDao;

    public Result login(String phone, String pwd) {

        List<Student> loginuser = userDao.login(phone, MD5Utils.encode(pwd));
        return loginuser.isEmpty() ? Resultsutils.Error(404, "信息错误") : Resultsutils.Success(loginuser);
    }

    //插入用户信息
    public Result insertUser(String phone, String pwd, String nickname) {
        List<Student> loginuser = null;
        try {

            loginuser = userDao.insertUser(phone, MD5Utils.encode(pwd), nickname);

        } catch (Exception e) {
            Resultsutils.Error(200,e.getMessage());

        }
    return Resultsutils.Success(loginuser);

    }
    @Override
    public Result AddAddress(String address,String name,int id){

        try {

            userDao.AddAddress(address, name, id);


        } catch (Exception e) {
            Resultsutils.Error(200, e.getMessage());

        }
        return Resultsutils.Success("成功");
    }






}