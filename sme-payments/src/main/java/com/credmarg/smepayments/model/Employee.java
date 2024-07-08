package com.credmarg.smepayments.model;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String name;
    private String designation;
    private double ctc;
    private String email;
}