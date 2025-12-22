package main.java.com.example.demo.implementations;
import main.java.com.example.demo.interfaces.ToDoService;
import main.java.com.example.demo.model.DateTime;
import main.java.com.example.demo.model.ToDoModel;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class ToDoServiceImpl implements ToDoService {

    private BufferedReader br;
    private HashMap<Integer, String> hs;

    public ToDoServiceImpl(BufferedReader br, HashMap<Integer, String> hs) {
        this.br = br;
        this.hs = hs;
    }
    DateTime dt = new DateTime();
    ToDoModel tdm = new ToDoModel();

    public void addMethod() {
        try {
            System.out.println("Enter Item num or enter '0' to cancel");
            tdm.setIns(Integer.parseInt(br.readLine()));
            if (tdm.getIns() == 0) {
                return;
            } else if (hs.containsKey(tdm.getIns())) {
                System.out.println("Item num already exists");
                return;
            }
                System.out.println("Enter value");
                tdm.setSs(br.readLine());
                hs.put(tdm.getIns(), tdm.getSs() + tdm.getCrtd() + dt.getDateTime() + tdm.getStat() + tdm.getStart());
                for(Map.Entry<Integer, String> h : hs.entrySet()) {
                System.out.println(h.getKey() + " = " + h.getValue());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void modifyMethod() {
        try {
            System.out.println("Enter list-no to modify");
            int inp = Integer.parseInt(br.readLine());
            if (hs.containsKey(inp)) {
                tdm.setIns(inp);
                System.out.print("Change With : ");
                tdm.setSs(br.readLine());
                String creatdt = dt.getDateTime();
                DateTime dt = new DateTime();
                hs.put(tdm.getIns(), tdm.getSs() + tdm.getCrtd() + creatdt + tdm.getUpdt() + dt.getDateTime() + tdm.getStat() + tdm.getStart());
            } else {
                System.out.println("To Do Not Found");
            }
            for(Map.Entry<Integer, String> h : hs.entrySet()) {
                System.out.println(h.getKey() + " = " + h.getValue());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

        public void statusMethod () {
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
                    hs.put(in, valuePart + tdm.getStat() + newStatus);
                    for(Map.Entry<Integer, String> h : hs.entrySet()) {
                        System.out.println(h.getKey() + " = " + h.getValue());
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        public void deleteMethod () {
            try {
                System.out.println(hs);
                System.out.println("Enter list num to delete");
                int re = Integer.parseInt(br.readLine());
                if (hs.containsKey(re)) {
                    hs.remove(re);
                } else {
                    System.out.println("Entered list num is not matching");
                }
                if (hs.isEmpty()) {
                    System.out.println("list is Empty press 4 to exit");
                }
                System.out.println("List contains : " + hs.size() + " items");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


