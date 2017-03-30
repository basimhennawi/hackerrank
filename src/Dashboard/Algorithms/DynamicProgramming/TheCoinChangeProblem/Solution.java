import java.util.Scanner;

public class Hackerrank {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.next());
		int m = Integer.parseInt(in.next());

		int[] S = new int[m];
		for (int i = 0; i < m; i++) {
			S[i] = Integer.parseInt(in.next());
		}

		long[] map = new long[n + 1];

		map[0] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = S[i]; j <= n; j++) {
				map[j] += map[j - S[i]];
			}
		}

		System.out.println(map[n]);
	}
}
