package com.projekt.s2e4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class S2E4Application {

    public static void main(String[] args) {
        SpringApplication.run(S2E4Application.class, args);
    }

}