package com.example.demo.controller;
import com.example.demo.interfaces.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.Map;

@Component
public class ToDoCont {


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
                tdl.addMethod();
            }
            break;
            case 2: {
                tdl.modifyMethod();
            }
            break;
            case 3: {
                tdl.statusMethod();
            }
            break;
            case 4: {
                tdl.deleteMethod();
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