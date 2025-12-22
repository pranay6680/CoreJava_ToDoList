import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ToDoMain {
    public void m1(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, String> hs = new HashMap<>();

        ToDoService tdl = new ToDoServiceImpl(br,hs);
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
            break;
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
