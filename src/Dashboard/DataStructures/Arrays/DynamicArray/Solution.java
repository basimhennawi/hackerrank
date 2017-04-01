import java.util.Scanner;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        int Q = in.nextInt();
        
        int lastAns = 0;
        int type, x, y, c;
        ArrayList<Integer> inner;
            
        ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < N; i++) {
            outer.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < Q; i++) {
            type = in.nextInt();
            x = in.nextInt();
            y = in.nextInt();

            c = (x ^ lastAns) % N;
            inner = outer.get(c);
            
            switch (type) {
                case 1: 
                    inner.add(y);                    
                    break;
                case 2:
                    lastAns = inner.get(y % inner.size());
                    System.out.println(lastAns);
                    break;
            }
        }
    }
}
