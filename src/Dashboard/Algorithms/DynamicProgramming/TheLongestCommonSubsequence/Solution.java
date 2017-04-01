import java.util.Scanner;
import java.util.Arrays;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();

        int[] A = new int[n];
        int[] B = new int[m];
        for (int i = 0; i < n; i++)
            A[i] = in.nextInt();

        for (int i = 0; i < m; i++)
            B[i] = in.nextInt();

        int[][] w = new int[2][];
        String[][] s = new String[2][];
        w[0] = new int[m + 1];
        w[1] = new int[m + 1];
        s[0] = new String[m + 1];
        s[1] = new String[m + 1];
        Arrays.fill(s[0],"");
        Arrays.fill(s[1],"");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1]) {
                    w[i % 2][j] = w[(i - 1) % 2][j - 1] + 1;
                    s[i % 2][j] = s[(i - 1) % 2][j - 1] + " " + A[i - 1];
                } else {
                    if (w[(i - 1) % 2][j] > w[i % 2][j - 1]) {
                        w[i % 2][j] = w[(i - 1) % 2][j];
                        s[i % 2][j] = s[(i - 1) % 2][j];
                    } else {
                        w[i % 2][j] = w[i % 2][j - 1];
                        s[i % 2][j] = s[i % 2][j - 1];
                    }
                }
            }
        }

        System.out.println(s[n % 2][m].trim());
    }
}
