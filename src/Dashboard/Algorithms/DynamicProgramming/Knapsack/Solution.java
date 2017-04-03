import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);
    static int last;
    public static void main(String[] args) {
        int tc = in.nextInt();
        while (tc-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            ArrayList<Integer> sack = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0 || arr[i] > k || sack.contains(arr[i]))
                    continue;
                sack.add(arr[i]);
            }
            if (sack.size() == 0) {
                System.out.println(0);
                continue;
            }
            Collections.sort(sack);
            last = 0;
            if (sack.get(0) == 1) {
                System.out.println(k);
                continue;
            }
            for (int i = sack.size() - 1; i >= 0; i--) {
                Search_Knapsack(sack, sack.get(i), i, k);
            }
            System.out.println(last);
        }
    }

    static void Search_Knapsack(ArrayList<Integer> sack, int cur, int at, int k) {
        if (last == k || cur > k) return;
        if (cur == k) {
            last = k;
            return;
        }

        last = Math.max(last, cur);
        for (int i = at; i >= 0; i--) {
            Search_Knapsack(sack, cur + sack.get(i), i, k);
        }
    }
}
