package com.zll.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EureServerApp {
    public static void main(String[] args) {
        SpringApplication.run(EureServerApp.class);
    }
}
