package com.example.demo.controller;

import com.google.common.collect.LinkedListMultimap;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * created on 2018/10/18.
 * author: Shitao Li
 * Copyright defined in demo/LICENSE.txt
 */

@RestController
public class MainController {

    @ApiOperation(value = "api", notes = "test api note")
    @ApiImplicitParam(name = "name",value = "value",required = true)
    @GetMapping("/api")
    public ResponseEntity<?> firstApi(){
        return ResponseEntity.ok("ok");
    }

    @ApiOperation(value = "test api",notes = "test")
    @ApiImplicitParam(name = "para name",value = "param orderid",dataTypeClass = Map.class)
    @PostMapping("/test")
    public ResponseEntity paraTest(@RequestBody Map req){

        Map body = new HashMap<>();
        body.put("result",req.get("orderId"));
        return ResponseEntity.ok(body);

    }

    @GetMapping("/map")
    public Map getMap(){
//        Map<Integer, String> map = new HashMap<>();
//        map.put(4,"4");
//        map.put(3,"3");
//        map.put(2,"2");
//        map.put(1,"1");
//        map.forEach((k,v)-> {
//            System.out.println(k+v);
//        });
        LinkedHashMap<Integer, String> map = new LinkedHashMap();
        TreeMap<Integer, String> mm = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        mm.put(3,"3");
        mm.put(4,"4");
        mm.put(1,"1");
        mm.put(2,"2");

        map.put(3,"3");
        map.put(4,"4");
        map.put(1,"1");
        map.put(2,"2");

//        NavigableMap<Integer, String> integerStringNavigableMap = map.descendingMap();
//        integerStringNavigableMap.forEach((k,v)-> {
//            System.out.println(k+v);
//            mm.put(k, v);
//        });

        mm.forEach((k,v)-> {
            System.out.println(k+v);
        });
        map.forEach((k,v)-> {
            System.out.println(k+v);
        });
        return map;
    }

}
