import java.util.Scanner;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int tc= in.nextInt();
        while (tc-- > 0) {
            int n = in.nextInt();
            String A = in.next();
            String B = in.next();

            boolean ans = false;
            int z = 0;
            for (char c : A.toCharArray()) z += '1' - c;
            for (char c : B.toCharArray()) z += '1' - c;
            if (z % 2 == 0) {
                ans = true;
                int i = 0, j = 0;
                while (ans && i < n && j < n) {
                    if (A.charAt(i) == '1') { i++; continue; }
                    if (B.charAt(j) == '1') { j++; continue; }

                    if (i == j) { i++; j++; continue; }
                    if (i - j == 1) { i++; j++; continue; }

                    if (i < j) {
                        if (i + 1 < n && A.charAt(i) == A.charAt(i + 1)) { i += 2; continue; }
                        if (j + 1 < n && B.charAt(j) == B.charAt(j + 1)) { j += 2; continue; }
                    } else {
                        if (j + 1 < n && B.charAt(j) == B.charAt(j + 1)) { j += 2; continue; }
                        if (i + 1 < n && A.charAt(i) == A.charAt(i + 1)) { i += 2; continue; }
                    }
                    ans = false;
                }

                while (ans && i < n) {
                    if (A.charAt(i) == '1') { i++; continue; }
                    if (A.charAt(i) == A.charAt(i + 1)) { i += 2; continue; }
                    ans = false;
                }
                while (ans && j < n) {
                    if (B.charAt(j) == '1') { j++; continue; }
                    if (B.charAt(j) == B.charAt(j + 1)) { j += 2; continue; }
                    ans = false;
                }

            }
            System.out.println(ans ? "YES" : "NO");
        }
    }
}
