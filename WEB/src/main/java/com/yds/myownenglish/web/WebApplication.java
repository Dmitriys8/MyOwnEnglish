package com.yds.myownenglish.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.yds.myownenglish.*")
@EnableJpaRepositories(basePackages = "com.yds.myownenglish.repo")
@EntityScan(basePackages = "com.yds.myownenglish.repo.entities")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
