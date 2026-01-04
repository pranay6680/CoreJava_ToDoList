package com.example.demo.controller;
import com.example.demo.interfaces.ToDoService;
import com.example.demo.model.ToDoModel;
import com.example.demo.repository.DataFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.Map;

@Component
public class ToDoCont {

    ToDoModel tdm = new ToDoModel();
    private final BufferedReader br;
    private final ConfigurableApplicationContext ctx;
    private final ToDoService tdl;
    private final DataFlow df;


    @Autowired
    public ToDoCont(ConfigurableApplicationContext ctx, BufferedReader br, ToDoService tdl,DataFlow df) {
        this.ctx = ctx;
        this.br = br;
        this.tdl = tdl;
        this.df = df;
    }

    public void m1(){
        boolean running = true;
         try {
           while (running) {
        System.out.println("press 1 to Add item");
        System.out.println("press 2 to modify");
        System.out.println("press 3 to status update");
        System.out.println("press 4 to delete");
        System.out.println("press 5 to exit");
        System.out.println("List contians :" + df.items() + " Items");
        int num = Integer.parseInt(br.readLine());
        switch (num) {
            case 1: {
                System.out.println("Enter Item num or enter '0' to cancel");
                tdm.setIns(Integer.parseInt(br.readLine()));
                int key = tdm.getIns();
                if (key == 0) {
                    break;
                } else if(df.findKey(key)) {
                    System.out.println("Entered Key already exists");
                    break;
                }
                System.out.println("Enter value");
                tdm.setSs(br.readLine());
                String value = tdm.getSs();
                Map<Integer, String> allItems = tdl.addMethod(key, value);
                for(Map.Entry<Integer, String> disp : allItems.entrySet()){
                    System.out.println(disp);
                }
            }
            break;
            case 2: {
                System.out.println("Enter list-no to modify");
                int inp = Integer.parseInt(br.readLine());
                if (df.findKey(inp)) {
                    int key = tdm.getIns();
                    System.out.print("Change With : ");
                    tdm.setSs(br.readLine());
                    String modValue = tdm.getSs();
                    Map<Integer, String> allItems = tdl.modifyMethod(key,modValue);
                    for(Map.Entry<Integer, String> h : allItems.entrySet()) {
                        System.out.println(h.getKey() + " = " + h.getValue());
                    }
                } else {
                System.out.println("To Do Not Found");
            }
            }
            break;
            case 3: {
                try {
                System.out.println("Update Status");
                System.out.println("Enter list no for status update");
                int in = Integer.parseInt(br.readLine());
                if (df.findKey(in)){
                    String oldValue = df.retrieve(in);
                    String[] parts = oldValue.split(tdm.getStat());
                    String valuePart = parts[0];
                    String newStatus;
                    System.out.println("Enter 1 for In Progress, 2 for Done, 3 for exit");
                    int k = Integer.parseInt(br.readLine());
                    if (k == 1) {
                        newStatus = tdm.getInProg();
                    } else if (k == 2) {
                        newStatus = tdm.getDn();
                    } else {
                        break;
                    }
                    Map<Integer, String> allItems = tdl.statusMethod(in,valuePart,newStatus);
                    for(Map.Entry<Integer, String> h : allItems.entrySet()){
                        System.out.println(h.getKey() + " = " + h.getValue());
                    }
                }
                }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
            }
            break;
            case 4: {
                System.out.println("Enter list num to delete");
                int re = Integer.parseInt(br.readLine());
                Map<Integer, String> allItems = tdl.deleteMethod(re);
                for(Map.Entry<Integer, String> h : allItems.entrySet()){
                    System.out.println(h.getKey() + " = " + h.getValue());
                }
                if (df.empty()) {
                    System.out.println("List contains : " + df.items() + " items");
                    System.out.println("list is Empty press 5 to exit");
                }
            }
            break;
            case 5: {
                running = false;
                br.close();
                break;
            }
            default:
                System.out.println("Exiting the system");
        }
    }ctx.close();
}catch (Exception e){
    System.out.println(e.getMessage());

    }
}
}