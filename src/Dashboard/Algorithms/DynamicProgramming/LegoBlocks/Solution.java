import java.util.Scanner;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);
    static long[][] AA;
    static long[][] SS;
    final static int MOD = 1000000007;

    public static void main(String[] args) {
        long[] w = new long[1500];
        w[1] = 1;
        w[2] = 2;
        w[3] = 4;
        w[4] = 8;
        for (int i = 5; i < 1500; i++)
            w[i] = (w[i - 1] + w[i - 2] + w[i - 3] + w[i - 4]) % MOD;

        AA = new long[1001][];
        SS = new long[1001][];
        for (int i = 0; i < 1001; i++) {
            AA[i] = new long[1001];
            SS[i] = new long[1001];
            for (int j = 0; j < 1001; j++) {
                AA[i][j] = -1;
                SS[i][j] = -1;
            }
        }

        int tc = in.nextInt();
        while (tc-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            long ans = S(n, m, w) % MOD;
            ans = (MOD + ans) % MOD;
            System.out.println(ans);
        }
    }

    static long S(int n, int m, long[] w) {
        if (AA[n][m] == -1) {
            long r = A(n, m, w) % MOD;
            long sum = 0;
            for (int i = 0; i < m; i++) {
                sum += S(n, i, w) * A(n, m - i, w);
                sum %= MOD;
            }
            AA[n][m] = (r - sum) % MOD;
        }
        return AA[n][m];
    }

    static long A(int n, int m, long[] w) {
        if (SS[n][m] == -1)
            SS[n][m] = modpow(w[m], n, MOD);
        return SS[n][m];
    }

    static long modpow(long bas, long exp, long modulus) {
        bas %= modulus;
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * bas) % modulus;
            bas = (bas * bas) % modulus;
            exp >>= 1;
        }
        return result;
    }
}
