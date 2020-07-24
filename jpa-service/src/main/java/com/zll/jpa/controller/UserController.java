package com.zll.jpa.controller;


import com.zll.jpa.entity.*;
import com.zll.jpa.repository.UserRepository;
import com.zll.jpa.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "没什么意思",tags = {"用户","管理"})

@RestController
@RequestMapping("user")
@Slf4j
@CrossOrigin
public class UserController {

    @Autowired
    UserRepository userRep;

    @Autowired
    UserService userService;
    @Autowired
    UserRepository ur;

    @RequestMapping("test")
    public String test(){
        return "test";
    }

    @RequestMapping("testaa")
    public String testAdd(){
        User user = new User();
        user.setUsername("mytest");
        user.setEmail("1547@qq.com");
        user.setPassword("123456");
        userRep.save(user);
        return "ok";
    }

    @ApiOperation(value = "获取用户列表",notes = "获取用户列表，用户列表的信息主要包含。。。。",
            response=MyPageImpl.class,httpMethod="GET")

    @ApiResponse(code = 200,message="返回的MyPageImpl对象",response=MyPageImpl.class)
    @RequestMapping("list")
    public MyPageImpl<User> list(@RequestBody UserVo userVo){
        //System.out.print(" 服务提供者  参数是  " + userVo);
       // List<User> list = ur.findByUsernameLike(userVo.getUsername());
        MyPageImpl<User> userPage = userService.list(userVo);
        //log.info(" 已经获取数据了。。。。。。。。。。。。");
        userPage.getContent().iterator().forEachRemaining(x->{System.out.println("x is " + x);});
       // log.info("page.class is " + userPage.getClass());
        return userPage;
    }

    @RequestMapping("del")
    public boolean delete(@RequestParam(value = "id")Integer id){
        System.out.println("id  provider= " + id);
        boolean del = userService.del(id);
        return del;
    }

    @RequestMapping("add")
    public boolean add(@RequestBody User user){
        System.err.println("user  service= " + user);
        boolean add = userService.add(user);
        return add;
    }

    @RequestMapping("departs")
    public List<Depart> getDeparts(){
         return  userService.listDeparts();
    }

    @RequestMapping("hobbys")
    public List<Hobby> gethobbys(){
        return  userService.hobbyList();
    }

}
