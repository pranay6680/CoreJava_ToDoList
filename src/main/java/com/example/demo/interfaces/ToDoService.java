package com.example.demo.interfaces;

import java.util.Map;

public interface ToDoService {
    Map<Integer, String> addMethod(int key, String value);
    Map<Integer, String> modifyMethod(int key, String modValue);
    Map<Integer, String> statusMethod(int key, String value, String stat);
    Map<Integer, String> deleteMethod(int re);

}
