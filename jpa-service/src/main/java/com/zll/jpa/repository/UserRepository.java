package com.zll.jpa.repository;

import com.zll.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

   // List<User> findByUsernameLike(String username);
}
