import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);
    final static int MOD = 1000000007;
    static int[] badmasks, board;
    static boolean[][] map;
    static ArrayList<HashMap<Long, Long>> cache;
    public static void main(String[] args) {
        int tc = in.nextInt();
        while (tc-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            map = new boolean[n][m];
            badmasks = new int[n];
            for (int i = 0; i < n; i++) {
                String _t = in.next();
                for (int j = 0; j < m; j++) {
                    if (_t.charAt(j) == '.')
                        continue;
                    map[i][j] = true;
                    badmasks[i] = setBitOnQueen(badmasks[i], j);
                }
                badmasks[i] = ~badmasks[i];
            }

            board = new int[n];
            cache = new ArrayList<HashMap<Long, Long>>();
            for (int i = 0; i < n; i++)
                cache.add(new HashMap<Long, Long>());

            long ans = longLiveTheQueen(0, 0, n, m, 0, false);
            System.out.println(ans);
        }
    }
    static long longLiveTheQueen(int x, int y, int n, int m, int mask, boolean mv) {
        if (x == n)
            return 0;
        long ans = 0;
        long key = mask;
        int z = x;
        for (int i = 0; i < m; i++, z--) {
            key = key * 100;
            if (z >= 0) {
                key += board[z];
            }
        }

        if (cache.get(x).containsKey(key))
            return cache.get(x).get(key);

        for (int i = y; i < m; i++) {
            if (map[x][i]) {
                mv = false;
                continue;
            }
            if (mv || isOnQueen(mask, i))
                continue;

            boolean bad = false;
            int u = x - 1, v = i - 1;
            for (int j = 0; j < m && u >= 0 && v >= 0; j++, u--, v--) {
                if (map[u][v]) {
                    bad = false;
                    break;
                } else if (isOnQueen(board[u], v)) {
                    bad = true;
                    break;
                }
            }
            if (bad)
                continue;

            u = x - 1;
            v = i + 1;
            for (int j = 0; j < m && u >= 0 && v < m; j++, u--, v++) {
                if (map[u][v]) {
                    bad = false;
                    break;
                } else if (isOnQueen(board[u], v)) {
                    bad = true;
                    break;
                }
            }
            if (bad)
                continue;

            int res = board[x];

            board[x] = setBitOnQueen(board[x], i);
            ans += 1 + longLiveTheQueen(x, i + 1, n, m, badmasks[x] & setBitOnQueen(mask, i), true);
            board[x] = res;

        }

        ans += longLiveTheQueen(x + 1, 0, n, m, badmasks[x] & mask, false);
        ans %= MOD;

        cache.get(x).put(key, ans);
        return ans;
    }
    public static int setBitOnQueen(int a, int i) {
        return a |= (1 << i);
    }
    public static boolean isOnQueen(int a, int i) {
        return ((a >> i) & 1) == 1;
    }
}
