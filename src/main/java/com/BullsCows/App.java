package com.BullsCows;

import com.BullsCows.controller.BullsCowsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

//    @Autowired
//    BullsCowsController controller;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }



//    public void run(String... args) throws Exception {
//        controller.run();
//    }
}