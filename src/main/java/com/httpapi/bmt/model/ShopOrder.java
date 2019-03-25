package com.httpapi.bmt.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShopOrder {
    private  int id;
    private  int user_id;
    private int commodity_id;
    private  String  order_number;
    private  String order_status;
    private String order_total;
    private int  order_size;


}
