package com.example.demo.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataFlow {
    public Map<Integer, String> d1() {
        return new Map<Integer, String>(){

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public String get(Object key) {
                return "";
            }

            @Override
            public String put(Integer key, String value) {
                return "";
            }

            @Override
            public String remove(Object key) {
                return "";
            }

            @Override
            public void putAll(Map<? extends Integer, ? extends String> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<Integer> keySet() {
                return Set.of();
            }

            @Override
            public Collection<String> values() {
                return List.of();
            }

            @Override
            public Set<Entry<Integer, String>> entrySet() {
                return Set.of();
            }
        };
    }
}
