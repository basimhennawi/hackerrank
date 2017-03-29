import java.util.Scanner;
import java.lang.StringBuilder;

public class Solution {
	static long[] a, b, d, eOdd, eEven, fOdd, fEven;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.next());
		int s = Integer.parseInt(in.next());

		a = new long[s];
		b = new long[s];
		d = new long[s];
		eOdd  = new long[s];
		eEven = new long[s];
		fOdd  = new long[s];
		fEven = new long[s];

		for (int i = 0; i < s; i++) {
			a[i] = Long.parseLong(in.next()) - 1;
			b[i] = Long.parseLong(in.next()) - 1;
			d[i] = Long.parseLong(in.next());
		}

		for (int i = 1; i < s; i += 2) {
			eOdd[i] = (a[i] + b[i] + d[i]) - (i > 1 ? eOdd[i - 2] : 0);
			if (i < s - 1)
				eOdd[i + 1] = eOdd[i];

			fOdd[i] = (a[i] - b[i]) - (i > 1 ? fOdd[i - 2] : 0);
			if (i < s - 1)
				fOdd[i + 1] = fOdd[i];
		}
		for (int i = 0; i < s; i += 2) {
			eEven[i] = (a[i] + b[i] + d[i]) - (i > 1 ? eEven[i - 2] : 0);
			if (i < s - 1)
				eEven[i + 1] = eEven[i];

			fEven[i] = (a[i] - b[i]) - (i > 1 ? fEven[i - 2] : 0);
			if (i < s - 1)
				fEven[i + 1] = fEven[i];
		}

		Pair tmp;
		int q = Integer.parseInt(in.next());
		while (q-- > 0) {
			long t = Long.parseLong(in.next());
			long i = t / n, j = t % n, II = i, JJ = j;
			long aa = 0, bb = 0;
			int mid, low = 0, high = s - 1;
			if (Inside(II, JJ, 0)) {
				tmp = EvaluatePosition(II, JJ, 0);
				aa = tmp.a;
				bb = tmp.b;
				if (Inside(aa, bb, 0)) {
					i = aa;
					j = bb;
				}

				while (high - low > 1) {
					mid = (low + high) / 2;
					tmp = EvaluatePosition(II, JJ, mid);
					aa = tmp.a;
					bb = tmp.b;
					if (Inside(aa, bb, mid)) {
						low = mid;
						i = aa;
						j = bb;
					} else {
						high = mid;
					}
				}
			}
			sb.append(++i).append(" ").append(++j).append("\n");
		}
		System.out.println(sb.toString());
	}

	static Pair EvaluatePosition(long i, long j, int p) {
		Pair pair = new Pair();
		if (p % 2 == 0) {
			if (p % 4 == 0) {
				pair.a = eOdd[p]  + fEven[p] + j;
				pair.b = eEven[p] - fOdd[p]  - i;
			} else {
				pair.a = eOdd[p]  + fEven[p] - j;
				pair.b = eEven[p] - fOdd[p]  + i;
			}
		} else {
			if ((1 + p) % 4 == 0) {
				pair.a = eEven[p] + fOdd[p]  + i;
				pair.b = eOdd[p]  - fEven[p] + j;
			} else {
				pair.a = eEven[p] + fOdd[p]  - i;
				pair.b = eOdd[p]  - fEven[p] - j;
			}
		}
		return pair;
	}

	static Boolean Inside(long i, long j, int p) {
		return i >= a[p] && j >= b[p] && i <= a[p] + d[p] && j <= b[p] + d[p];
	}

	static class Pair {
		public long a, b;
	}
}
