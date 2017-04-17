import java.util.Scanner;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int N = in.nextInt();
        int H = in.nextInt();
        int I = in.nextInt();

        long[][] building = new long[N][H];
        long[][] dp = new long[N][H];
        long[] mx = new long[H];

        for (int i = 0; i < N; i++) {
            int u = in.nextInt();
            int[] A = new int[u];
            for (int j = 0; j < u; j++) {
                A[j] = in.nextInt();
            }
            for (int j = 0; j < u; j++)
                building[i][A[j] - 1]++;
        }

        for (int j = 0; j < N; j++) {
            dp[j][0] = building[j][0];
            mx[0] = Math.max(mx[0], building[j][0]);
        }

        for (int h = 1; h < H; h++) {
            for (int b = 0; b < N; b++) {

                long jump = 0;
                if (h >= I) {
                    jump = Math.max(jump, mx[h - I]);
                }

                dp[b][h] = building[b][h] + Math.max(dp[b][h - 1], +jump);
                mx[h] = Math.max(mx[h], dp[b][h]);
            }
        }

        System.out.println(mx[H - 1]);
    }
}
