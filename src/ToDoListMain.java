import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ToDoListMain {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, String> hs = new HashMap<>();
        PracticeService pp = new PracticeService();
        pp.m1(br,hs);
    }
        }

