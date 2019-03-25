package com.httpapi.bmt.controller;

import com.httpapi.bmt.model.MD5Utils;
import com.httpapi.bmt.model.Result;
import com.httpapi.bmt.service.StudentServiceill;
import com.httpapi.bmt.service.UserServiceill;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserServiceill userService;
    @ApiOperation(value = "获取首页的数据", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone ", value = "用户名", required = true),
            @ApiImplicitParam(name = "pwd ", value = "用户密码", required = true),
    })
    @RequestMapping(value = "/login",method = RequestMethod.POST )
    public Result Loginuser(@RequestBody Map<String,String> user ){
        System.out.println(MD5Utils.encode(user.get("pwd")));
        return userService.login(user.get("phone"), user.get("pwd"));



    }


    @ApiOperation(value = "获取首页的数据", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone ", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "nickname ", value = "用户昵称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pwd", value = "用户密码", required = true, dataType = "String "),
    })
    @RequestMapping(value = "/addUser",method = RequestMethod.POST )
    public Result Insetuser(@RequestBody Map<String,String> user ){
        System.out.println(user.get("pwd"));
        return userService.insertUser(user.get("phone"),MD5Utils.encode(user.get("pwd")),user.get("nickname"));



    }
    @ApiOperation(value = "获取首页的数据", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "truename", value = "收货人姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "address", value = "收获地址", required = true, dataType = "String"),
            @ApiImplicitParam(name = "uid ", value = "收货id", required = true, dataType = "int"),

    })
    //添加收获地址
    @RequestMapping(value = "/setAddress",method = RequestMethod.POST )
    public Result SetAddress(@RequestBody Map<String,String> user ){


        return  userService.AddAddress(user.get("address"),user.get("truename"),Integer.parseInt(user.get("uid")));


    }
}
