package com.httpapi.bmt.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class shop_commodity {
    private int id;
    private String commodity_name;
    private String commodity_nowprice;
    private String commodity_brand;
    private String commodity_stock;
    private String commodity_oldprice;
    private String commodity_sales;
    private String commodity_main;
    private String commodity_thumbnail;
    private String commodity_attachimg;
    private String commodity_content;

}
