package com.besti.swaggerdemo.controller;

import com.besti.swaggerdemo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jack Pan
 * @version 1.0 2020/11/28
 */
//@Api(tags = "Hello控制类")
@RestController
public class HelloController {


    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    //只要我们的接口中，返回值中存在实体类，就会被扫描到swagger中
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }

    @ApiOperation("Hello控制类")
    @ApiImplicitParam(name = "username", value = "用户名",required = true, dataType = "String", paramType = "path")
    @GetMapping(value = "/hello2/{username}")
    public String hello2(@PathVariable("username") String username){
        return "hello"+username;
    }

    @ApiOperation("Post测试")
    @PostMapping(value = "/hello3")
    public User hello3(@RequestBody @ApiParam("用户名") User user){
        return user;
    }

}
