package com.example.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void performOperation() {
        System.out.println("Performing operation...");
    }
}
