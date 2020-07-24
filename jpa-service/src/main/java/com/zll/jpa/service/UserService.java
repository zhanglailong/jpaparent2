package com.zll.jpa.service;

import com.zll.jpa.entity.*;

import java.util.List;

public interface UserService {

    MyPageImpl list(UserVo userVo);
    boolean del(Integer id);
    boolean add(User user);

    List<Depart> listDeparts();
    List<Hobby> hobbyList();
}
