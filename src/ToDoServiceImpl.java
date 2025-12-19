import java.io.BufferedReader;
import java.util.HashMap;

public class ToDoServiceImpl implements ToDoService {

    private BufferedReader br;
    private HashMap<Integer, String> hs;

    public ToDoServiceImpl(BufferedReader br, HashMap<Integer, String> hs) {
        this.br = br;
        this.hs = hs;
    }

    ToDoModel tdm = new ToDoModel();

    public void addMethod() {
        try {
            System.out.println("Enter Item num or enter '0' to cancel");
            tdm.ins = Integer.parseInt(br.readLine());
            if (tdm.ins == 0) {
                return;
            } else if (hs.containsKey(tdm.ins)) {
                System.out.println("Item num already exists");
                return;
            }
                System.out.println("Enter value");
                tdm.ss = br.readLine();
                hs.put(tdm.ins, tdm.ss + ":::" + tdm.str);
                System.out.println(hs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void modifyMethod() {
        try {
            System.out.println("Enter list-no to modify");
            int inp = Integer.parseInt(br.readLine());
            if (hs.containsKey(inp)) {
                tdm.ins = inp;
                System.out.print("Change With : ");
                tdm.ss = br.readLine();
                hs.put(tdm.ins, tdm.ss + ":::" + tdm.str);
            } else {
                System.out.println("To Do Not Found");
            }
            System.out.println(hs);
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
                    String[] parts = oldValue.split(":::");
                    String valuePart = parts[0];
                    String newStatus;

                    System.out.println("Enter 1 for In Progress, 2 for Done, 3 for exit");
                    int k = Integer.parseInt(br.readLine());
                    if (k == 1) {
                        newStatus = "IN PROGRESSS";
                    } else if (k == 2) {
                        newStatus = "DONE";
                    } else {
                        return;
                    }
                    hs.put(in, valuePart + ":::" + newStatus);
                    System.out.println(hs);
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


