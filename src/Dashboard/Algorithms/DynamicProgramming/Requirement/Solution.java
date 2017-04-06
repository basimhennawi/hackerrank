import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);
    static ArrayList<HashSet<Integer>> smaller;
    static HashMap<String, Long> map = new HashMap<String, Long>();
    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }

        smaller = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i < n; i++)
            smaller.add(new HashSet<Integer>());
        
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            smaller.get(x).add(y);
        }

        int[] w = new int[n];
        long ans = search(0, w, n);

        System.out.println(ans % 1007);
    }

    static long search(int p, int[] w, int n) {
        if (p == n)
            return 1;

        int i;
        String key = "";
        for (i = p; i < n; i++)
            key += w[i];

        if (map.containsKey(key))
            return map.get(key);

        long r = 0;

        int[] tmp = new int[n];
        for (i = 0; i < n; i++)
            tmp[i] = w[i];

        while (w[p] < 10) {
            Iterator<Integer> it = smaller.get(p).iterator();
            while (it.hasNext()) {
                int l = it.next();
                w[l] = Math.max(w[l], w[p]);
            }

            r += search(p + 1, w, n);
            for (i = p + 1; i < n; i++)
                w[i] = tmp[i];
            w[p]++;
        }

        for (i = 0; i < n; i++)
            w[i] = tmp[i];
        map.put(key, r);
        return r;
    }
}
