import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();        
        int max = map.size();
        for (int i = 0; i < n; i++) {
            if (i >= m) {
                int old = deque.remove();
                if (map.get(old) == 1) {
                    map.remove(old);
                } else {
                    map.put(old, map.get(old) - 1);
                }
            }
            int num = scan.nextInt();
            deque.add(num);
            map.merge(num, 1, Integer::sum);
            max = Math.max(max, map.size());
        }
        scan.close();
        System.out.println(max);
    }
}
