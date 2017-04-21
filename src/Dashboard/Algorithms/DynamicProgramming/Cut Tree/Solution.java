import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    static Scanner in = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static ArrayList<HashSet<Integer>> adj;
    public static void main(String[] args) {
        int n = in.nextInt();
        int k = in.nextInt();

        adj = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i <= n; i++)
            adj.add(new HashSet<Integer>());

        for (int i = 0; i < n - 1; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            adj.get(l).add(r);
            adj.get(r).add(l);
        }

        long ans = 0;
        boolean[] V = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            V[i] = true;
            Map<Integer, Long> _r = findSubs(i, -1, V);
            for (int j = 0; j <= k; j++) {
                if (_r.containsKey(j))
                    ans += _r.get(j);
            }
        }
        System.out.println(ans + 1);
    }
    static Map<Integer, Long> findSubs(int p, int proh, boolean[] V) {
        int c = adj.get(p).size();
        Map<Integer, Long> d = new HashMap<Integer, Long>();
        d.put(c, 1L);
        for (int node : adj.get(p)) {
            if (node == proh || V[node])
                continue;
            Map<Integer, Long> tmp = new HashMap<Integer, Long>();
            for (Map.Entry<Integer, Long> item : findSubs(node, p, V)
                    .entrySet()) {
                for (Map.Entry<Integer, Long> taken : d.entrySet()) {
                    Add(tmp, taken.getKey() + item.getKey() - 2,
                            item.getValue() * taken.getValue());
                }
            }
            for (Map.Entry<Integer, Long> taken : d.entrySet()) {
                Add(tmp, taken.getKey(), taken.getValue());
            }
            d = tmp;
        }
        return d;
    }
    static void Add(Map<Integer, Long> dic, int i, long j) {
        if (dic.containsKey(i))
            dic.put(i, dic.get(i) + j);
        else
            dic.put(i, j);
    }
}
