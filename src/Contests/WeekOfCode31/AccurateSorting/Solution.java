import java.util.Scanner;

public class Hackerrank {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int tc = in.nextInt();
        while (tc-- > 0) {
            System.out.println(solve() ? "Yes" : "No");
        }
    }

    static boolean solve() {
        int n = in.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++) A[i] = in.nextInt();
        
        for (int i = 0; i < n; i++) {
            if (Math.abs(i - A[i]) > 1) return false;
        }
        return true;
    }
}
