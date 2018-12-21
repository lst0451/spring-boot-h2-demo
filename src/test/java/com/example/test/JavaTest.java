package com.example.test;

import com.example.demo.Worker;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.xml.transform.Result;
import java.util.*;

/**
 * created on 2018/11/12.
 * author: Shitao Li
 * Copyright defined in demo/LICENSE.txt
 */
public class JavaTest {

    private static final Object List = null;
    private boolean l;

    @Test
    public void test1(){
        System.out.println(System.currentTimeMillis());
    }


    @Test
    public void test2(){


//        List<String> list = Arrays.asList("1", "2", "3", "4");


//        Optional<List> list = Optional.of(Arrays.asList("1", "2", "3", "4"));//new ArrayList<>();
//        list.get().forEach(e-> System.out.println(e));

        Optional<List> list2 = Optional.of(Arrays.asList("1", "2", "3", "4"));//Optional.empty();
        list2.ifPresent(l->l.forEach(e-> System.out.println(e)));


//        Optional<List> list = Optional.ofNullable(List);


    }

    public void test3(){
        Map map = new HashMap();
    }


    @Test
    public void testMemCache(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://192.168.88.217:8092/taskstatus/txhash/0x96f7644dea8be46c7b839653b5a5e7134f3b22dfe77e93a961cf90cfd784767f";
//        ResponseEntity<ArrayList> workerByLedgerIp = restTemplate.getForEntity("http://192.168.88.217:8081/mem/" + "worker/" + "192.168.88.152", ArrayList.class);
        ResponseEntity<ArrayList> workerByLedgerIp = restTemplate.getForEntity(url, ArrayList.class);
        List<Worker> treeNodeList = new ArrayList<Worker>();

        HttpStatus code = workerByLedgerIp.getStatusCode();
        System.out.println(workerByLedgerIp);
        System.out.println("response code:"+code);
        if(code.is2xxSuccessful()){
            System.out.println("true.....");
        }

    }

    @Test
    public void testRest(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://192.168.88.217:8092/taskstatus/txhash/0x96f7644dea8be46c7b839653b5a5e7134f3b22dfe77e93a961cf90cfd784767f";

        ParameterizedTypeReference<List<Worker>> typeRef =
                new ParameterizedTypeReference<List<Worker>>() {};

        ResponseEntity<List<Worker>> entity = restTemplate.exchange(url, HttpMethod.GET, null, typeRef);

        entity.getBody().stream().forEach(worker -> {
            System.out.println(worker);
        });

    }


    @Test
    public void testUrlPlaceholder(){
        Mono<String> resp = WebClient.create()
                .get()
                //多个参数也可以直接放到map中,参数名与placeholder对应上即可
                .uri("http://www.baidu.com/s?wd={key}&other={another}","北京天气","test") //使用占位符
                .retrieve()
                .bodyToMono(String.class);
        System.out.println("result:{}"+resp.block());

    }




}
