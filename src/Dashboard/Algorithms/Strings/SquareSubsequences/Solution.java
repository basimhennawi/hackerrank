import java.util.Scanner;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        int tc = in.nextInt();
        while (tc-- > 0) {
            String l = in.next();
            int ln = l.length(), ans = 0;

            for (int i = 0; i < ln; i++) {
                for (int j = i + 1; j < ln; j++) {
                    if (l.charAt(i) == l.charAt(j)) {
                        String top = l.substring(i, j);
                        String bottom = l.substring(j);

                        ans += Common_Sequences(top, bottom);
                        ans %= MOD;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    static int Common_Sequences(String top, String bottom) {
        int n = top.length(), m = bottom.length();
        int[][] w = new int[n + 1][];
        for (int i = 0; i <= n; i++)
            w[i] = new int[m + 1];

        // 2 is because it's missing the first letter
        for (int i = 2; i <= n; ++i) {
            for (int j = 2; j <= m; ++j) {
                if (top.charAt(i - 1) == bottom.charAt(j - 1)) {
                    w[i][j] = w[i][j - 1] + w[i - 1][j] + 1;
                } else {
                    w[i][j] = w[i][j - 1] + w[i - 1][j] - w[i - 1][j - 1];
                }
                w[i][j] %= MOD;
            }

        }
        // 1 is because it was missing the first letter
        return 1 + w[n][m];
    }
}
