package com.zll.jpa.repository;

import com.zll.jpa.entity.Depart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DepartReponsitory extends JpaRepository<Depart,Integer>, JpaSpecificationExecutor<Depart> {
}
