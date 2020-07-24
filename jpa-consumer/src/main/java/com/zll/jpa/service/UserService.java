package com.zll.jpa.service;

import com.zll.jpa.entity.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// ,fallback = UserServiceFailBack.class
@FeignClient(value = "jpa-service")
public interface UserService {

    @RequestMapping("/user/list")
    MyPageImpl<User> list(@RequestBody UserVo userVo);
    @RequestMapping("/user/del")
    boolean del(@RequestParam("id")Integer id);
    @RequestMapping("/user/add")
    boolean add(@RequestBody User user);
    @RequestMapping("/user/departs")
    List<Depart> listDeparts();
    @RequestMapping("/user/hobbys")
    List<Hobby> listbobbys();
}
