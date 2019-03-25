package com.httpapi.bmt.service.Impl;

import com.httpapi.bmt.model.Result;
import com.httpapi.bmt.model.ShopOrder;

import java.util.HashMap;
import java.util.List;

public interface CartService {
    Result shoporder( int shopid,int userid);
    public Result shoplist(int userid);
    public  Result deletecar(int cid);
    public  Result Checkcar( int shopid,int userid);
   public Result Addorder(List<HashMap> list, int orderTotal, int  money);

    Result SelectOrder(int userid, String status);

    ;
}
