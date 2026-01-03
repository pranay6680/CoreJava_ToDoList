package com.example.demo.implementations;
import com.example.demo.interfaces.ToDoService;
import com.example.demo.model.DateTime;
import com.example.demo.model.ToDoModel;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.util.Map;

@Service
public class ToDoServiceImpl implements ToDoService {

    ToDoModel tdm = new ToDoModel();
    DateTime dt = new DateTime();

    private BufferedReader br;
    private Map<Integer, String> hs;

    public ToDoServiceImpl(BufferedReader br, Map<Integer, String> hs) {
        this.br = br;
        this.hs = hs;
    }


    public void addMethod(int key, String value) {
        try {
                hs.put(key, value + tdm.getCrtd() + dt.getDateTime() + tdm.getStat() + tdm.getStart());
                for(Map.Entry<Integer, String> h : hs.entrySet()) {
                System.out.println(h.getKey() + " = " + h.getValue());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void modifyMethod(int key, String modValue) {
        try {
                String creatdt = dt.getDateTime();
                DateTime dt = new DateTime();
                hs.put(key, modValue + tdm.getCrtd() + creatdt + tdm.getUpdt() + dt.getDateTime() + tdm.getStat() + tdm.getStart());
            for(Map.Entry<Integer, String> h : hs.entrySet()) {
                System.out.println(h.getKey() + " = " + h.getValue());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

        public void statusMethod (int in, String valuePart, String newStatus) {
            try {
                    hs.put(in, valuePart + tdm.getStat() + newStatus);
                    for(Map.Entry<Integer, String> h : hs.entrySet()) {
                        System.out.println(h.getKey() + " = " + h.getValue());
                    }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        public void deleteMethod (int re) {
            try {
                if (hs.containsKey(re)) {
                    hs.remove(re);
                } else {
                    System.out.println("Entered list num is not matching");
                }
                if (hs.isEmpty()) {
                    System.out.println("list is Empty press 5 to exit");
                }
                System.out.println("List contains : " + hs.size() + " items");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


