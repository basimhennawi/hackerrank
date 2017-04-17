import java.util.Scanner;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int tc = in.nextInt();
        while (tc-- > 0) {
            String s = in.next().trim();
            int n = s.length();
            long[] z = new long[n];
            int L = 0, R = 0;
            for (int i = 1; i < n; i++) {
                if (i > R) {
                    L = R = i;
                    while (R < n && s.charAt(R - L) == s.charAt(R))
                        R++;
                    z[i] = R - L;
                    R--;
                } else {
                    int k = i - L;
                    if (z[k] < R - i + 1)
                        z[i] = z[k];
                    else {
                        L = i;
                        while (R < n && s.charAt(R - L) == s.charAt(R))
                            R++;
                        z[i] = R - L;
                        R--;
                    }
                }
            }
            long ans = n;
            for (long i : z)
                ans += i;
            System.out.println(ans);
        }
    }
}
