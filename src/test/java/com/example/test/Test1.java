package com.example.test;

import org.junit.Test;

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;

/**
 * created on 2018/12/12.
 * author: Shitao Li
 * Copyright defined in demo/LICENSE.txt
 */
public class Test1 {

    @Test
    public void test(){

        TreeMap<Integer,Integer> map1 = new TreeMap<Integer,Integer>();
        TreeMap<Integer,Integer> map2= new TreeMap<Integer,Integer>(new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return b-a;
            }
        });
        map2.put(1,2);
        map2.put(2,4);
        map2.put(7,1);
        map2.put(5,2);
        System.out.println("Map2="+map2);

        map1.put(1,2);
        map1.put(2,4);
        map1.put(7,1);
        map1.put(5,2);

        System.out.println("map1="+map1);

        NavigableMap<Integer, Integer> map3 = map1.descendingMap();
        System.out.println("map3="+map3);


    }

}
