package com.example.demo.implementations;
import com.example.demo.interfaces.ToDoService;
import com.example.demo.model.DateTime;
import com.example.demo.model.ToDoModel;
import com.example.demo.repository.DataFlow;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.util.Map;

@Service
public class ToDoServiceImpl implements ToDoService {

    ToDoModel tdm = new ToDoModel();
    DateTime dt = new DateTime();
    private final DataFlow df;
    private final BufferedReader br;

    public ToDoServiceImpl(BufferedReader br,DataFlow df) {
        this.br = br;
        this.df = df;
    }


    public Map<Integer, String> addMethod(int key, String value) {
        try {
                df.save(key, value + tdm.getCrtd() + dt.getDateTime() + tdm.getStat() + tdm.getStart());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return df.findAll();
    }

    public Map<Integer, String> modifyMethod(int key, String modValue) {
        try {
                String creatdt = dt.getDateTime();
                DateTime dt = new DateTime();
                df.save(key, modValue + tdm.getCrtd() + creatdt + tdm.getUpdt() + dt.getDateTime() + tdm.getStat() + tdm.getStart());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return df.findAll();
    }

        public Map<Integer, String> statusMethod (int in, String valuePart, String newStatus) {
            try {
                    df.save(in, valuePart + tdm.getStat() + newStatus);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return df.findAll();
        }
        public Map<Integer, String> deleteMethod (int re) {
            try {
                if (df.findKey(re)) {
                    df.delete(re);
                } else {
                    System.out.println("Entered list num is not matching");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return df.findAll();
        }
    }


