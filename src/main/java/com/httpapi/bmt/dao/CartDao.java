package com.httpapi.bmt.dao;
import com.httpapi.bmt.model.ShopOrder;


import java.util.HashMap;
import java.util.List;

public interface CartDao {
    public List<ShopOrder> shoporder(int shopid,int userid);
    public List<HashMap<String,Object>> shoplist(int id);
    public  void deletecar(int cid);
    public List<HashMap<String,Object>>Checkcar(int shopid,int userid);
    public void Addorder(List<HashMap> list,String ordernumber);
    public void changemoney(String userMoney,int userid );

    public void deletCar(int userid);

    List<HashMap<String, Object>> SelectOrder(int userid, String status);
}
