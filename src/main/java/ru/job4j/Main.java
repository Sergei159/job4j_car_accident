package ru.job4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan({"ru.job4j", "ru.job4j.config"})
//@EnableMongoRepositories("ru.job4j.repository")
@ComponentScan(basePackages = {"ru.job4j.repository"})
//@EnableAutoConfiguration
public class Main {


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("Go to http://localhost:8080/index");
    }
}
