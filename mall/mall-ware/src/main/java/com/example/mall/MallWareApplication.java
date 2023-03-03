package com.example.mall;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@EnableDiscoveryClient
@EnableRabbit
@SpringBootApplication
public class MallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallWareApplication.class, args);
    }


}
