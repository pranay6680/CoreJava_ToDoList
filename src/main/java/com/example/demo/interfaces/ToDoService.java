package com.example.demo.interfaces;

public interface ToDoService {
    void addMethod(int key, String value);
    void modifyMethod(int key, String modValue);
    void statusMethod(int key, String value, String stat);
    void deleteMethod(int re);

}
