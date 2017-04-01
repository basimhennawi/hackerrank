import java.util.Scanner;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String line = in.nextLine();
        int n = line.length();

        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (line.charAt(i) == line.charAt(j)) {
                    dp[i][j] = 2 + (j > 0 && i < n - 1 ? dp[i + 1][j - 1] : 0);
                    if (i == j)
                        dp[i][j]--;
                } else {
                    dp[i][j] = Math.max(j > 0 ? dp[i][j - 1] : 0, i < n - 1 ? dp[i + 1][j] : 0);
                }

            }
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, dp[0][i] * dp[i + 1][n - 1]);
        }
        System.out.println(ans);
    }
}
