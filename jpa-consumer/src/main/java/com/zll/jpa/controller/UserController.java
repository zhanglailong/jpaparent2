package com.zll.jpa.controller;

import com.zll.jpa.entity.*;
import com.zll.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("list")
    public MyPageImpl<User> list( UserVo userVo){

       // System.out.print(" 消费者参数是  " + userVo);
        MyPageImpl<User> page = userService.list(userVo);

         //System.out.println ("  消费者 ========== 已经获取数据了。。。。。。。。。。。。");
        //page.getContent().iterator().forEachRemaining(x->{System.out.println("消费者  x is " + x);});

        return page;
    }

    @RequestMapping("delete")
    public boolean del(Integer id){
        System.err.println("id  consumer= " + id);
        boolean del = userService.del(id);
        return del;
    }

    @RequestMapping("add")
    public boolean add(@RequestBody User user){
        System.err.println("user consumer = " + user);
        boolean add = userService.add(user);
        return add;
    }
    @RequestMapping("departs")
    public List<Depart> list(){
        List<Depart> departs = userService.listDeparts();
        return  departs;
    }

    @RequestMapping("hobbys")
    public List<Hobby> listhobby(){
      return  userService.listbobbys();
    }

}
