package com.zll.jpa.service;

import com.zll.jpa.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 熔断
 */
@Component
public class UserServiceFailBack  implements  UserService{

    @Override
    public MyPageImpl<User> list(UserVo userVo) {
        System.out.println(" 对不起，熔断了。。。。");
                return  null;
    }

    @Override
    public boolean del(Integer id) {
        return false;
    }

    @Override
    public boolean add(User user) {
        return false;
    }

    @Override
    public List<Depart> listDeparts() {
        return null;
    }

    @Override
    public List<Hobby> listbobbys() {
        return null;
    }
}
