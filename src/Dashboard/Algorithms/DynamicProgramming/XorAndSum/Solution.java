import java.util.Scanner;

public class Hackerrank {

    final static int MOD = 1000000007;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        long[] two = new long[500000];
        two[0] = 1;
        long bi = 1;
        for (int i = 1; i < 500000; i++) {
            bi *= 2;
            bi %= MOD;
            two[i] = bi;
        }

        String str1 = in.nextLine();
        String str2 = in.nextLine();

        int n = str1.length(), m = str2.length();

        boolean[] a = new boolean[n];
        for (int i = 0; i < n; i++)
            a[n - i - 1] = str1.charAt(i) == '1';

        long[] after = new long[500000];
        after[0] = 1;
        for (int i = 1; i < 500000; i++)
            after[i] = (after[i - 1] + two[i]) % MOD;

        long sum = 0;
        long[] zero = new long[500000], one = new long[500000];
        zero[0] = str1.charAt(n - 1) - '0';
        one[0] = '1' - str1.charAt(n - 1);

        for (int j = 1; j < 500000; j++) {
            one[j] = one[j - 1];
            if (j >= n || !a[j])
                one[j] = (one[j] + two[j]) % MOD;

            zero[j] = zero[j - 1];
            if (j < n && a[j])
                zero[j] = (zero[j] + two[j]) % MOD;
        }

        for (int i = 0; i < m; i++) {
            if (str2.charAt(m - i - 1) == '1')
                sum = (sum + (one[i + 314159] - (i > 0 ? one[i - 1] : 0)) % MOD);
            else
                sum = (sum + (zero[i + 314159] - (i > 0 ? zero[i - 1] : 0)) % MOD);

            sum = (sum + MOD) % MOD;
        }

        for (int i = 0; i < n; i++) {
            if (a[i]) {
                long ai = i >= m ? (314160 - m) : (314159 - i);
                sum = (sum + two[i] * ai) % MOD;
            }
        }
        System.out.println(sum);
    }
}
