import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    static Scanner in = new Scanner(System.in);
    static double high, low;
    static List<edge> L;
    final static double[] T = new double[1];

    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        L = new ArrayList<edge>();
        for (int i = 0; i < m; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            if (l != r)
                L.add(new edge(l, r, a, b));
        }
        m = L.size();
        for (double t = 0; ; t = high / low) {
            double ag = get(t, n, m);
            if (Math.abs(ag) < 1e-5)
                break;
        }

        int up = (int) high;
        int down = (int) low;
        int g = gcd(up, down);
        up /= g;
        down /= g;
        System.out.println(up + "/" + down);
    }

    static double get(double t, int n, int m) {
        T[0] = t;
        Collections.sort(L, new Comparator<edge>() {
            @Override
            public int compare(edge y, edge z) {
                double par1 = y.a - T[0] * y.b;
                double par2 = z.a - T[0] * z.b;
                if(Math.abs(par1-par2)<1e-5) return 0;
                if(par1<par2) return 1;
                return -1;
            }
        });

        low = high = 0;

        int x = n - 1;
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < m && x > 0; i++) {
            edge cur = L.get(i);
            int par_from = findParent(cur.from, parent), par_to = findParent(cur.to, parent);
            if (par_from == par_to) {
                continue;
            } else if (size[par_from] >= size[par_to]) {
                size[par_from] += size[par_to];
                parent[par_to] = par_from;
            } else {
                size[par_to] += size[par_from];
                parent[par_from] = par_to;
            }

            high += cur.a;
            low += cur.b;
            x--;
        }

        return high - t * low;
    }

    static int findParent(int a, int[] parent) {
        if (parent[parent[a]] != parent[a])
            parent[a] = findParent(parent[a], parent);
        return parent[a];
    }
    
    static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    static class edge {
        public int from, to, a, b;

        public edge(int u_, int v_, int a_, int b_) {
            from = u_; to = v_; a = a_; b = b_;
        }
    }
}
