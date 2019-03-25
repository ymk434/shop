package com.httpapi.bmt.controller;

import com.httpapi.bmt.model.Result;
import com.httpapi.bmt.model.Student;
import com.httpapi.bmt.model.shop_commodity;
import com.httpapi.bmt.service.Impl.StudentService;
import com.httpapi.bmt.service.StudentServiceill;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/shop")
public class IndexController {
   /* @Autowired
    private  StudentServiceill studentServiceill;
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public List<Student> ShowallStudent(){
        return studentServiceill.finallmessage();
    }*/
   @Autowired
   private  StudentServiceill studentServiceill;
//一个参数传参过来
    @ApiOperation(value = "获取首页的数据", httpMethod = "GET")
    @ApiImplicitParam(name="page",value = "页码",dataType = "int",required = true,paramType = "query")

  /*  多个参数传参@ApiOperation(value="更新信息", notes="根据url的id来指定更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })*/

    @RequestMapping(value = "/index",method = RequestMethod.GET )
    public Result index(@RequestParam(value = "page", required = true, defaultValue = "0") int page){
       return studentServiceill.index(page);



    }
    //多个id接口前端对接
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int",paramType = "query"),
    })
    @RequestMapping(value = "/info",method = RequestMethod.GET )
    public  Result Listallmessage(@RequestParam(value = "id", required = true, defaultValue = "0") int id){
        return studentServiceill.ShowListGoods(id);



    }

    //商品分类
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bread", value = "分类形式", required = true, dataType = "String",paramType = "query"),
    })
    @RequestMapping(value = "/class",method = RequestMethod.GET )
    public  Result Listallbymessage(@RequestParam(value = "bread", required = true, defaultValue = "0") String bread){
        return studentServiceill.ShowListbyGoods(bread);



    }



}
