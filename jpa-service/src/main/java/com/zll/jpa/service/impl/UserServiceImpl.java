package com.zll.jpa.service.impl;

import com.netflix.discovery.util.StringUtil;
import com.zll.jpa.entity.*;
import com.zll.jpa.repository.DepartReponsitory;
import com.zll.jpa.repository.HobbyRepository;
import com.zll.jpa.repository.UserRepository;
import com.zll.jpa.service.UserService;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    DepartReponsitory dr;
    @Autowired
    HobbyRepository hr;

    @Override
    public MyPageImpl<User> list(UserVo userVo) {

        Specification<User> specification  = new Specification(){
            //动态生成查询条件
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {
                //保存查询条件
                ArrayList<Predicate> list = new ArrayList<Predicate>();
                //username
                if(userVo.getUsername()!=null){
                    Predicate predicate = cb.like(root.get("username"), "%" + userVo.getUsername() + "%");
                    list.add(predicate);
                }
                //获取条件的数组
                Predicate[] predicates = list.toArray(new Predicate[list.size()]);
                Predicate predicateAll = cb.and(predicates);
                return predicateAll;
            }
        };

        // 生成分页的对象
        Pageable pageable = PageRequest.of(userVo.getPage()-1,userVo.getPageSize(), Sort.Direction.DESC,"uid");
        //Page<User> userPage = userRepository.findAll(pageable);
        //return new MyPageImpl(userPage);
        Page page = userRepository.findAll(specification, pageable);

        return new MyPageImpl<>(page);
    }

    @Override
    public boolean del( Integer id) {
        System.out.println("id serviceimpl = " + id);
        try {
            userRepository.deleteById(id);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean add(User user) {
        User user1 = userRepository.saveAndFlush(user);
        try {
            if(user.getUid()>0){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<Depart> listDeparts() {
        List<Depart> all = dr.findAll();

        return all;
    }

    @Override
    public List<Hobby> hobbyList() {

        return hr.findAll();
    }


}
