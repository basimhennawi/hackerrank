import java.util.Scanner;
import java.util.HashMap;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        HashMap<String, Integer> arr = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            String key = in.nextLine();
            if (arr.containsKey(key)) {
                arr.replace(key, arr.get(key) + 1);
            } else {
                arr.put(key, 1);
            }
        }
        int q = in.nextInt();
        in.nextLine();
        int count;
        for (int i = 0; i < q; i++) {
            String query = in.nextLine();
            if (arr.containsKey(query)) {
                count = arr.get(query);
            } else {
                count = 0;
            }
            System.out.println(count);
        }
    }
}
