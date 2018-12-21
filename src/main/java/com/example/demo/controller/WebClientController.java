package com.example.demo.controller;

import com.example.demo.entity.Emp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Map;

/**
 * created on 2018/12/20.
 * author: Shitao Li
 * Copyright defined in demo/LICENSE.txt
 */
@RestController
public class WebClientController {

    @GetMapping("/web/test1")
    public Mono<String> testUrlPlaceholder(){
        Mono<String> resp = WebClient.create()
                .get()
                //多个参数也可以直接放到map中,参数名与placeholder对应上即可
                .uri("http://www.baidu.com/s?wd={key}&other={another}","北京天气","test") //使用占位符
                .retrieve()
                .bodyToMono(String.class);
        System.out.println("result:{}"+resp.block());
        return resp;

    }


    @GetMapping("/web/testflux")
    public  Flux<Map> testFlux(){
//        WebClient webClient = WebClient.create();
//        webClient.method(HttpMethod.GET).uri("http://localhost:8080/worker/testtransaction");

        Flux<Map> mapFlux = WebClient.create().get().uri("http://192.168.88.217:8092/recent10").retrieve().bodyToFlux(Map.class);

        return mapFlux;
    }

    @GetMapping("/web/testmono/{name}")
    public  Mono<Map> testMono(@PathVariable("name") String name ){

        Mono<Map> mapMono = WebClient.create().get().uri("http://localhost:8080/worker/ledgerDetails/"+name).retrieve().bodyToMono(Map.class);

        return mapMono;
    }

    @GetMapping("/web/testemp/{name}")
    public  Mono<Map> testEmp(@PathVariable("name") String name ){

        Mono<Map> mapMono = WebClient.create().get().uri("http://localhost:8081/emp/"+name).retrieve().bodyToMono(Map.class);

        return mapMono;
    }
}
