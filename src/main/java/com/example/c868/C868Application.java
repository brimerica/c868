package com.example.c868;

import com.example.c868.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class C868Application {

    public static void main(String[] args) {

        SpringApplication.run(C868Application.class, args);

    }

}