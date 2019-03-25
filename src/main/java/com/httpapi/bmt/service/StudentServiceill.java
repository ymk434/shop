package com.httpapi.bmt.service;
import com.httpapi.bmt.dao.StudentDao;
import com.httpapi.bmt.model.Result;
import com.httpapi.bmt.model.Student;
import com.httpapi.bmt.model.shop_commodity;
import com.httpapi.bmt.service.Impl.StudentService;
import com.httpapi.bmt.utils.Resultsutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceill implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> finallmessage() {
        return studentDao.finallmessage();
    }
    //显示页面数量
    public Result index (int page){
        List<shop_commodity>indexlist=studentDao.index(5,5);
        return  indexlist.isEmpty() ? Resultsutils.Error(404,"信息错误"):Resultsutils.Success(indexlist);

    }

    @Override
    //查看商品信息
    public Result ShowListGoods(int id) {
        List<shop_commodity> index=studentDao.ShowListGoods(id);
        return  index.isEmpty() ? Resultsutils.Error(404,"信息错误"):Resultsutils.Success(index);

    }

    public Result ShowListbyGoods(String bread) {
        List<shop_commodity>list=studentDao.ShowListbyGoods(bread);
        return  list.isEmpty() ? Resultsutils.Error(404,"信息错误"):Resultsutils.Success(list);

    }
}
