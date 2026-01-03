package com.example.demo.controller;
import com.example.demo.interfaces.ToDoService;
import com.example.demo.model.ToDoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.Map;

@Component
public class ToDoCont {

    ToDoModel tdm = new ToDoModel();
    private BufferedReader br;
    private ConfigurableApplicationContext ctx;
    private Map<Integer, String> hs;
    private ToDoService tdl;

    @Autowired
    public ToDoCont(ConfigurableApplicationContext ctx, BufferedReader br, Map<Integer, String> hs, ToDoService tdl) {
        this.ctx = ctx;
        this.br = br;
        this.hs = hs;
        this.tdl = tdl;
    }

    public void m1(){
         try {
           while (true) {
        System.out.println("press 1 to Add item");
        System.out.println("press 2 to modify");
        System.out.println("press 3 to status update");
        System.out.println("press 4 to delete");
        System.out.println("press 5 to exit");
        System.out.println("List contians :" + hs.size() + " Items");
        int num = Integer.parseInt(br.readLine());
        if (num == 5) {
            ctx.close();
            System.exit(0);
        }
        switch (num) {
            case 1: {
                System.out.println("Enter Item num or enter '0' to cancel");
                tdm.setIns(Integer.parseInt(br.readLine()));
                int key = tdm.getIns();
                if (key == 0) {
                    return;
                } else if (hs.containsKey(key)) {
                    System.out.println("Item num already exists");
                    return;
                }
                System.out.println("Enter value");
                tdm.setSs(br.readLine());
                String value = tdm.getSs();
                tdl.addMethod(key, value);
            }
            break;
            case 2: {
                System.out.println("Enter list-no to modify");
                int inp = Integer.parseInt(br.readLine());
                if (hs.containsKey(inp)) {
                    int key = tdm.getIns();
                    System.out.print("Change With : ");
                    tdm.setSs(br.readLine());
                    String modValue = tdm.getSs();
                    tdl.modifyMethod(key,modValue);

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
                if (hs.containsKey(in)) {
                    String oldValue = hs.get(in);
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
                        return;
                    }
                    tdl.statusMethod(in,valuePart,newStatus);
                }
                }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

            }
            break;
            case 4: {
                System.out.println(hs);
                System.out.println("Enter list num to delete");
                int re = Integer.parseInt(br.readLine());
                tdl.deleteMethod(re);
            }
            break;
            default:
                System.out.println("Exiting the system");
        }
    }
}catch (Exception e){
    System.out.println(e.getMessage());

    }
}
}