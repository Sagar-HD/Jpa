package com.sagar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDate;
import java.time.Year;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "model_year")
    private Year modelYear;


}
