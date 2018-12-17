package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
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
    private Integer id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String gender;
}
