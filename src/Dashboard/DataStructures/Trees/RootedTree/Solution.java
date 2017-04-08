import java.util.Scanner;
import java.util.ArrayList;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);
    final static int MOD = 1000000007;
    static StringBuilder sb;
    static int N, Q, R, chainNo, lg, MAX = 100000;
    static int[][] LCA;
    static int[] chainHead, chain, subsize, parent, L, level, chainPos, chainLeaf;
    static ArrayList<long[]> f_KLp2, f_KLp, f_K, f_V, f_VLp;
    static ArrayList<Integer> paths;
    static ArrayList<ArrayList<Integer>> adj, children;
    public static void main(String[] args) {
        N = in.nextInt();
        Q = in.nextInt();
        R = in.nextInt() - 1;

        pre();

        chainNo = 0;
        HLD(0, -1, -1);
        setUpFenwickTrees();

        while (Q-- > 0) {
            String c = in.next();
            int a = read(in.nextInt() - 1);
            int b = in.nextInt();    

            if (c.equals("U")) {
                Update(a, b, in.nextLong(), 0);
            } else {
                sb.append(Report(a, read(b - 1))).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static void setUpFenwickTrees() {
        for (int i = 0; i < N; i++) {
            if (adj.get(i).size() == 1) {
                chainLeaf[chain[i]] = i;
            }
        }

        chainNo++;
        f_V = new ArrayList<long[]>();
        f_VLp = new ArrayList<long[]>();
        f_K = new ArrayList<long[]>();
        f_KLp = new ArrayList<long[]>();
        f_KLp2 = new ArrayList<long[]>();
        for (int i = 0; i < chainNo; i++) {
            int len = level[chainLeaf[i]] - level[chainHead[i]] + 1;

            f_V.add(new long[len + 1]);
            f_VLp.add(new long[len + 1]);
            f_K.add(new long[len + 1]);
            f_KLp.add(new long[len + 1]);
            f_KLp2.add(new long[len + 1]);
        }
        chainNo--;
    }
    static int read(int i) { if (i == R) return 0; if (i == 0) return R; return i; }
    static void pre() {
        sb = new StringBuilder();
        adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<Integer>());
        for (int i = 0; i < N - 1; i++) {
            int a = read(in.nextInt() - 1);
            int b = read(in.nextInt() - 1);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        chainHead = new int[MAX];
        chainLeaf = new int[MAX];
        paths = new ArrayList<Integer>();
        children = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < MAX; i++)
            chainHead[i] = -1;

        chain = new int[N];
        for (int i = 0; i < N; i++)
            chain[i] = -1;
        chainPos = new int[N];
        subsize = new int[N];
        parent = new int[N];
        level = new int[N];
        L = new int[N];

        LCA = new int[N][22];
        lg = (int) Math.ceil(Math.log(N) / Math.log(2));
        for (int i = 0; i < N; i++)
            for (int j = 0; j < 22; j++)
                LCA[i][j] = -1;

        SubsizeParentLevel(0, -1, 1);
        ConstructLCA(N);
    }
    static int SubsizeParentLevel(int p, int no, int l) {
        LCA[p][0] = no;
        L[p] = no == -1 ? 1 : L[no] + 1;
        parent[p] = no;
        level[p] = l;
        int r = 1;
        l++;
        for (int item : adj.get(p))
            if (item != no) r += SubsizeParentLevel(item, p, l);

        subsize[p] = r;
        return r;
    }
    // Lowest Common Ancestor
    static void ConstructLCA(int n) {
        for (int i = 1; i < lg; i++)
            for (int j = 1; j < n; j++)
                if (LCA[j][i - 1] != -1)
                    LCA[j][i] = LCA[LCA[j][i - 1]][i - 1];
    }
    static int getLca(int x, int y) {
        if (L[x] < L[y]) { int tmp = x; x = y; y = tmp; }
        for (int i = lg; i >= 0; i--) {
            if (LCA[x][i] != -1 && L[LCA[x][i]] >= L[y])
                x = LCA[x][i];
        }
        if (x == y) return x;
        for (int i = lg; i >= 0; i--) {
            if (LCA[x][i] != -1 && LCA[x][i] != LCA[y][i]) {
                x = LCA[x][i];
                y = LCA[y][i];
            }
        }
        return LCA[x][0];
    }
    static long Report(int A, int B) {
        int x = getLca(A, B);
        long u = (FenwickToRoot(B, -1, -1) - FenwickToRoot(x, -1, -1)) % MOD;
        u = (u + (FenwickToRoot(A, -1, -1) - FenwickToRoot(parent[x], -1, -1))
                % MOD) % MOD;
        if (u < 0)
            return MOD + u;
        return u;
    }

    static long FenwickToRoot(int a, int _lf, int _lc) {
        if (a == -1) return 0;
        int ch = chain[a];
        int pos = chainPos[a];
        int leaf = chainLeaf[ch];

        int Lf = _lf == -1 ? level[leaf] : _lf;
        int Lc = _lc == -1 ? level[a] : _lc;

        long v = query_fenwick(f_V.get(ch), pos);
        long vlp = query_fenwick(f_VLp.get(ch), pos);
        long klp2 = query_fenwick(f_KLp2.get(ch), pos);
        long klp = query_fenwick(f_KLp.get(ch), pos);
        long k = query_fenwick(f_K.get(ch), pos);

        long ans = (Lc * v - vlp) % MOD;

        long one = (k * (Lc * Lc + Lc)) % MOD;
        long three = (-(klp * (2 * Lc + 1))) % MOD;
        long xx = (one + klp2 + three) % MOD;

        ans = (ans + (xx * 500000004) % MOD) % MOD;

        ans = (ans + FenwickToRoot(parent[chainHead[ch]], Lf, Lc)) % MOD;
        if (ans < 0) return ans + MOD;
        return ans;
    }

    static void Update(int a, long V, long K, int d) {
        int ch = chain[a];
        int pos = chainPos[a];
        int lvl = level[a]; 
        int len = f_K.get(ch).length - 1;

        updatefenwick(f_V.get(ch), len, pos, V);
        updatefenwick(f_K.get(ch), len, pos, K);
        updatefenwick(f_VLp.get(ch), len, pos, (V * lvl) % MOD - V);
        updatefenwick(f_KLp.get(ch), len, pos, (K * lvl) % MOD);
        updatefenwick(f_KLp2.get(ch), len, pos, (((K * lvl) % MOD) * lvl) % MOD);

    }
    // Binary Indexed Tree (Fenwick)
    static long query_fenwick(long[] fenwick, int i) {
        i++;
        long sum = 0;
        for (; i > 0; i -= i & (-i))
            sum = (sum + fenwick[i]) % MOD;
        return sum;
    }

    static void updatefenwick(long[] fenwick, int n, int i, long val) {
        i++;
        for (; i <= n; i += i & (-i))
            fenwick[i] = (fenwick[i] + val) % MOD;
    }
    // Heavy Light Decomposition
    static void HLD(int p, int no, int parentChain) {
        if (parentChain != -1)
            children.get(parentChain).add(chainNo);
        if (chainHead[chainNo] == -1) {
            chainHead[chainNo] = p;
            paths.add(0);
            children.add(new ArrayList<Integer>());
        }

        chain[p] = chainNo;
        chainPos[p] = paths.get(chainNo);
        paths.set(chainNo, paths.get(chainNo) + 1);
        int s = -1, ssz = -1;
        ArrayList<Integer> AI = adj.get(p);
        for (int i = 0; i < adj.get(p).size(); i++) {
            if (AI.get(i) != no && subsize[AI.get(i)] > ssz) {
                ssz = subsize[AI.get(i)];
                s = i;
            }
        }
        if (s == -1) return;
        HLD(AI.get(s), p, -1);
        for (int i = 0; i < AI.size(); i++) {
            if (AI.get(i) != no && i != s) {
                chainNo++;
                HLD(AI.get(i), p, chain[p]);
            }
        }
    }
}
