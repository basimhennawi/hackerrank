import java.util.Arrays;
import java.util.Scanner;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int k = in.nextInt();

        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = in.nextInt();

        Arrays.sort(A);

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < n - k + 1; i++) {
            long tmp = 0;
            int p = i, q = k - 1 + i;
            long m = k - 1;
            while (p < q) {
                tmp += m * (A[q] - A[p]);
                p++;
                q--;
                m -= 2;
            }
            ans = Math.min(ans, tmp);
        }
        System.out.println(ans);
    }
}
