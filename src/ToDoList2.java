import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ToDoList2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, String> hs = new HashMap<>();
        Practice pp = new Practice();
        pp.m1(br,hs);
    }
        }

