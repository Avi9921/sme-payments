package com.credmarg.smepayments.model;

import lombok.Data;

@Data
public class Vendor {
    private Long id;
    private String name;
    private String email;
    private String upi;
}