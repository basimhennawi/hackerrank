import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        ArrayList<ArrayList<Integer>> bigArrList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arrList = new ArrayList<>();
            int d = in.nextInt();
            for (int j = 0; j < d; j++) {
                arrList.add(in.nextInt());
            }
            bigArrList.add(arrList);
        }
        
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            try {
                System.out.println(bigArrList.get(in.nextInt() - 1).get(in.nextInt() - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }

    }
}
