package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DataFlow {

    private final Map<Integer, String> hs = new HashMap<>();

    public String save(int key, String value){
        return hs.put(key,value);
    }
    public String retrieve(int key){
        return hs.get(key);
    }
    public void delete(int key){
        hs.remove(key);
    }
    public boolean findKey(int key){
        return hs.containsKey(key);
    }
    public Map<Integer, String> findAll(){
        return new HashMap<>(hs);
    }
    public int items(){
        return hs.size();
    }
    public boolean empty(){
        return hs.isEmpty();
    }
}
