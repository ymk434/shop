package com.httpapi.bmt.service.Impl;

import com.httpapi.bmt.model.Result;
import com.httpapi.bmt.model.Student;
import com.httpapi.bmt.model.shop_commodity;

import java.util.List;

public interface StudentService {
    public List<Student> finallmessage();
    public Result index(int page);
    public Result ShowListGoods(int id);
    public Result ShowListbyGoods(String bread);

}
