import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int tc = in.nextInt();
        while (tc-- > 0) {
            int n = in.nextInt();
            boolean[] A = new boolean[n+1];
            for (int i = 0; i < n; i++) {
                A[i] = in.nextInt() == 1;
            }
            A[n] = true;
            int c = count(n, A);
            sb.append(c % 2 == 1 ? "Alice\n" : "Bob\n");
        }

        System.out.println(sb.toString());
    }

    static int count(int n, boolean[] A) {
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (A[i])
                continue;
            int j = i;
            while (j < n && (!A[j] || !A[j + 1]))
                j++;

            r += Math.max(0, j - i - 2);
            i = j - 1;
        }
        return r;
    }
}
