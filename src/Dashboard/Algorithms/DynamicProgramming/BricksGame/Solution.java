import java.util.Scanner;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int tc = in.nextInt();
        while (tc-- > 0) {
            int n = in.nextInt();
            long[] arr = new long[n];
            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[n - i - 1] = in.nextLong();
                sum += arr[n - i - 1];
            }

            if (n < 4) {
                System.out.println(sum);
                continue;
            }

            long[] max = new long[n];

            max[0] = arr[0];
            max[1] = arr[1] + arr[0];
            max[2] = arr[2] + arr[1] + arr[0];
            for (int i = 3; i < n; i++) {
                dp_bricks(arr, i, n, max);
            }
            System.out.println(max[n - 1]);
        }
    }
    static void dp_bricks(long[] arr, int j, int n, long[] max) {
        if (j == n)
            return;

        long j2 = max[j - 2], j3 = max[j - 3], j4 = (j >= 4 ? max[j - 4] : 0),
                j5 = (j >= 5 ? max[j - 5] : 0), j6 = (j >= 6 ? max[j - 6] : 0);
        long aa = arr[j] + min(j2, j3, j4);
        aa = Math.max(aa, arr[j] + arr[j - 1] + min(j3, j4, j5));
        aa = Math.max(aa, arr[j] + arr[j - 1] + arr[j - 2] + min(j4, j5, j6));

        max[j] = aa;
    }
    static long min(long a, long b, long c) {
        return Math.min(a, Math.min(b, c));
    }
}
