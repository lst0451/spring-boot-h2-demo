package com.example.demo.service;

import com.example.demo.entity.Emp;
import com.example.demo.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created on 2018/12/17.
 * author: Shitao Li
 * Copyright defined in demo/LICENSE.txt
 */
@Service
public class EmpService {
    @Autowired
    private EmpRepository empRepository;



    public Emp saveEmp(Emp emp){
        Emp saved = empRepository.save(emp);

        return saved;
    }

    public Emp getEmp(String name){
        return empRepository.findEmpByFirstName(name);
    }
}
