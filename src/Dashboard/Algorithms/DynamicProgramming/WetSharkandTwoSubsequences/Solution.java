import java.util.Scanner;

public class Hackerrank {
	
	final static int MOD = 1000000007;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.next());
		int r = Integer.parseInt(in.next());
		int s = Integer.parseInt(in.next());

		int[] X = new int[n];
		for (int i = 0; i < n; i++) {
			X[i] = Integer.parseInt(in.next());
		}

		if (s > r) {
			System.out.println(0);
			return;
		}

		int a = r + s, b = r - s;
		if (a % 2 == 1) {
			System.out.println(0);
			return;
		}
		
		a /= 2;
		b /= 2;

		long[][][] dp = new long[n][][];

		long ans = 0;
		long[] dpA = new long[n + 1], dpB = new long[n + 1];

		for (int i = 0; i < n; i++) {
			int num = X[i];
			int bound = a - num;

			dp[i] = new long[2001][];
			for (int j = 0; j < 2001; j++) {
				dp[i][j] = new long[n + 1];
			}

			for (int j = 0; j < i; j++) {
				for (int k = 1; k <= bound; k++) {
					if (dp[j][k][0] != 0) {
						long[] tmp = dp[i][k + num], tmp2 = dp[j][k];
						for (int t = 1; t <= i; t++) {
							tmp[t + 1] += tmp2[t];
							tmp[t + 1] %= MOD;
							tmp[0] = 1;
						}
					}
				}
			}

			dp[i][num][1]++;
			dp[i][num][0] = 1;

			for (int j = 1; j < n + 1; j++) {
				dpA[j] += dp[i][a][j];
				dpA[j] %= MOD;
				dpB[j] += dp[i][b][j];
				dpB[j] %= MOD;
			}
		}

		for (int i = 0; i <= n; i++) {
			ans += dpA[i] * dpB[i];
			ans %= MOD;
		}

		System.out.println(ans);
	}
}
