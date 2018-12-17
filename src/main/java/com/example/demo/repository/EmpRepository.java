package com.example.demo.repository;

import com.example.demo.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created on 2018/12/17.
 * author: Shitao Li
 * Copyright defined in demo/LICENSE.txt
 */
public interface EmpRepository extends JpaRepository<Emp,Long> {

    public Emp findEmpByFirstName(String name);

}
