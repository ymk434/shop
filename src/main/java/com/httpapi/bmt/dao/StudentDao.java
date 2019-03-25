package com.httpapi.bmt.dao;
import com.httpapi.bmt.model.Result;
import com.httpapi.bmt.model.Student;
import com.httpapi.bmt.model.shop_commodity;
import org.hibernate.validator.constraints.ParameterScriptAssert;

import java.util.List;

public  interface StudentDao {
    public List<Student> finallmessage();
    public List<shop_commodity>index(int StartPage,int TotalPage);
    public List<shop_commodity> ShowListGoods(int id);
    public List<shop_commodity>ShowListbyGoods(String bread);


}
