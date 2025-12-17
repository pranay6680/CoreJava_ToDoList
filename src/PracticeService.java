import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Practice {
    public void m1(BufferedReader br, HashMap<Integer,String> hs) throws IOException {
        String start = "START";
        int ins;
        String ss;
        while (true) {
            System.out.println("press 1 to Add item");
            System.out.println("press 2 to modify");
            System.out.println("press 3 to status update");
            System.out.println("press 4 to delete");
            System.out.println("press 5 to exit");
            System.out.println("List contians :" + hs.size() + " Items");
            int num = Integer.parseInt(br.readLine());
            if (num == 5) {
                break;
            }
            switch (num) {
                case 1: {
                    System.out.print("Enter Key or enter 'e' to exit");
                    String proc = br.readLine();
                    if (proc.equalsIgnoreCase("e")) {
                        break;
                    }
                    System.out.println("Enter Item num");
                    ins = Integer.parseInt(br.readLine());
                    System.out.println("Enter value");
                    ss = br.readLine();
                    hs.put(ins, ss + ":::" + start);
                    System.out.println(hs);
                }
                break;
                case 2: {
                    System.out.println("Enter list-no to modify");
                    int inp = Integer.parseInt(br.readLine());
                    if (hs.containsKey(inp)) {
                        ins = inp;
                        System.out.print("Change With : ");
                        ss = br.readLine();
                        hs.put(ins, ss + ":::" + start);
                    } else {
                        System.out.println("To Do Not Found");
                    }
                    System.out.println(hs);
                }
                break;

                case 3: {
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
                            break;
                        }
                        hs.put(in, valuePart + ":::" + newStatus);
                        System.out.println(hs);
                    }
                }
                break;

                case 4: {
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
                }
                break;
            }

        }
    }
}
