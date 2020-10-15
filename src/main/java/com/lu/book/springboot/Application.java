package com.lu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring Boot 의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정해줌!
@SpringBootApplication
// Main Class
public class Application {
    public static void main(String[] args){
        // SpringApplication.run() 을 통해 내장 WAS를 실행함!
        SpringApplication.run(Application.class, args);
    }
}
