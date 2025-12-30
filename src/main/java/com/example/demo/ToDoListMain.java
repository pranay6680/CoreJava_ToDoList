package com.example.demo;
import com.example.demo.controller.ToDoCont;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoListMain implements CommandLineRunner {
    private final ToDoCont tdc;

    public ToDoListMain(ToDoCont tdc) {
        this.tdc = tdc;
    }

    public static void main(String args[]){
        SpringApplication.run(ToDoListMain.class, args);
    }
    @Override
    public void run(String args[]){
        tdc.m1();
    }
        }

