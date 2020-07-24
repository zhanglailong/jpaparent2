package com.zll.jpa.repository;

import com.zll.jpa.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby,Integer> {
}
