package com.example.demo.controller;

import com.example.demo.entity.Emp;
import com.example.demo.service.EmpService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

/**
 * created on 2018/12/17.
 * author: Shitao Li
 * Copyright defined in demo/LICENSE.txt
 */
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping("/emp")
    public ResponseEntity addEmp(@RequestBody Emp emp){

        Emp saveEmp = empService.saveEmp(emp);

        return ResponseEntity.ok(saveEmp);
    }

    @GetMapping("/emp/{name}")
    public ResponseEntity getEmp(@PathVariable("name") String name ){
        return ResponseEntity.ok().body(empService.getEmp(name));
    }


}
