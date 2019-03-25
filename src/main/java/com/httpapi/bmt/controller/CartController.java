package com.httpapi.bmt.controller;


import com.alibaba.fastjson.JSONArray;
import com.httpapi.bmt.model.Result;
import com.httpapi.bmt.service.CartServiceill;

import com.httpapi.bmt.service.Impl.CartService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
       @Autowired
        private CartService cartServiceill;
        @ApiOperation(value = "获取首页的数据", httpMethod = "POST")
        @ApiImplicitParams({
                @ApiImplicitParam(name = " userid", value = "用户ID", required = true, dataType = "int"),
                @ApiImplicitParam(name = "shopid ", value = "商品ID", required = true, dataType = "int"),

        })
        @RequestMapping(value = "/addCart",method = RequestMethod.POST )
        //添加购物车
        public Result shoporder(@RequestBody Map<String,String> user ){

            return  cartServiceill.shoporder(Integer.parseInt(user.get("shopid")),Integer.parseInt(user.get("userid")));


        }

    @ApiOperation(value = "获取首页的数据", httpMethod = "POST")
    @ApiImplicitParam(name = "userid", value = "用户ID", required = true, dataType = "int" ,paramType = "query")
    //查询购物车
    @RequestMapping(value = "/selectCart",method = RequestMethod.POST )
    public Result ShowList(@RequestBody Map<String,String> user ){

        return  cartServiceill.shoplist(Integer.parseInt(user.get("userid")));


    }



    @ApiOperation(value = "获取首页的数据", httpMethod = "POST")
    @ApiImplicitParam(name = "cid", value = "用户ID", required = true, dataType = "int" )
    //查询购物车
    @RequestMapping(value = "/deleteCart",method = RequestMethod.POST )
    public Result DeleteCar(@RequestBody Map<String,String> user ){

        return  cartServiceill.deletecar(Integer.parseInt(user.get("cid")));


    }



    @ApiOperation(value = "获取首页的数据", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = " userid", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "shopid ", value = "商品ID", required = true, dataType = "int"),

    })
    //检查是否加入购物车
    @RequestMapping(value = "/checkCart",method = RequestMethod.POST )
    public Result CheckCar(@RequestBody Map<String,String> user ){

        return  cartServiceill.Checkcar(Integer.parseInt(user.get("shopid")),Integer.parseInt(user.get("userid")));
    }






    @ApiOperation(value = "获取首页的数据", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = " order", value = "用户信息数组", required = true,dataType = "String"),
            @ApiImplicitParam(name = "orderTotal ", value = "商品单价", required = true,dataType="String"),
            @ApiImplicitParam(name = "money  ", value = "用户总额", required = true,dataType = "String"),


    })
    //提交订单
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST )
    public Result AddOrder(@RequestBody Map<String,String> user ) {
        List<HashMap> list = JSONArray.parseArray(user.get("order"), HashMap.class);
        return  cartServiceill.Addorder(list,Integer.parseInt(user.get("orderTotal")),Integer.parseInt(user.get("money")));
    }






    @ApiOperation(value = "获取首页的数据", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = " userid", value = "用户id", required = true,dataType = "int"),
            @ApiImplicitParam(name = "status", value = "订单状态", required = true,dataType="String"),


    })
    //查看订单
    @RequestMapping(value = "/checkOrder",method = RequestMethod.POST )
    public Result SelectOrder(@RequestBody Map<String,String> user ) {



        return  cartServiceill.SelectOrder(Integer.parseInt(user.get("userid")),user.get("status"));
    }







}
