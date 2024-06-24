package com.example.aop;

import com.example.aop.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private MyService myService;

    @Override
    public void run(String... args) throws Exception {
        myService.performOperation();
    }
}
