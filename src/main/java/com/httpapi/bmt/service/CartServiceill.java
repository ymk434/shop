package com.httpapi.bmt.service;

import com.httpapi.bmt.dao.CartDao;
import com.httpapi.bmt.model.*;
import com.httpapi.bmt.service.Impl.CartService;
import com.httpapi.bmt.utils.Resultsutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class CartServiceill implements CartService {
    @Autowired
    private CartDao cartDao;
    public Result shoporder( int shopid,int userid) {
          List<ShopOrder> loginuser = null;
            try {

                loginuser = cartDao.shoporder(shopid,userid);

            } catch (Exception e) {
                Resultsutils.Error(200,e.getMessage());

            }
            return Resultsutils.Success("成功");

        }


    public Result shoplist(int userid) {
        List<HashMap<String,Object>>list=cartDao.shoplist(userid);
        return  list.isEmpty() ? Resultsutils.Error(404,"信息错误"):Resultsutils.Success(list);

    }

    @Override
    public Result deletecar(int cid) {
        try {

             cartDao.deletecar(cid);

        } catch (Exception e) {
            Resultsutils.Error(200,e.getMessage());

        }
        return Resultsutils.Success("成功");

    }

    @Override
    public Result Checkcar(int shopid,int userid) {
        List<HashMap<String, Object>> list = cartDao.Checkcar(shopid, userid);
        return list.isEmpty() ? Resultsutils.Error(404, "信息错误") : Resultsutils.Success(list);


    }



    @Override
    public Result Addorder(List<HashMap> list, int orderTotal, int  money) {
        String ordernum=null;
        try {
            ordernum = System.currentTimeMillis() + "";
            money=money-orderTotal;
            String userMoney=money+"";
            int userid = (Integer) list.get(0).get("uid");
            cartDao.changemoney(userMoney,userid);
            cartDao.Addorder(list, ordernum);
            cartDao.deletCar(userid);
        } catch (Exception e){
            return Resultsutils.Error(200,e.getMessage());
        }
        return  Resultsutils.Success(ordernum);
    }

    @Override
    public Result SelectOrder(int userid, String status) {

        List<HashMap<String, Object>> list = cartDao.SelectOrder(userid, status);
        return list.isEmpty() ? Resultsutils.Error(404, "信息错误") : Resultsutils.Success(list);

    }


}



