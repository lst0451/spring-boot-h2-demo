package com.example.demo;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * created on 2018/12/6.
 * author: Shitao Li
 * Copyright defined in demo/LICENSE.txt
 */
@Data
public class Worker implements Serializable {
    private String worker_id;
    private String contract;
    private Integer status;
    private Integer occur_time;
    private String ip;
}
