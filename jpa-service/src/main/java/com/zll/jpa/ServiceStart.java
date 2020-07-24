package com.zll.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceStart {
    public static void main(String[] args) {
        SpringApplication.run(ServiceStart.class,args);
    }
}
