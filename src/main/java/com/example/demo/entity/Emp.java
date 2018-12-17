package com.example.demo.entity;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * created on 2018/12/17.
 * author: Shitao Li
 * Copyright defined in demo/LICENSE.txt
 */
@Data
@Entity
public class Emp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String gender;
}
