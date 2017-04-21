import java.util.Scanner;

public class Solution {
    final static double PI = 3.14159265358979323846264338327;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }

        long[] sum = new long[n];
        sum[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) sum[i] = sum[i + 1] + A[i];

        double f1 = 0, f2 = 0;
        for (int i = 0; i < n; i++) f1 += A[i] * A[i];
        if(k == 0){
            System.out.println(f1 * PI);
            return;
        }

        for (int i = 0; i < n - 1; i++) f2 += A[i] * sum[i + 1];
        double s3 = 0.0;
        for (int i = 1 + n - k; i < n; i++) {
            s3 += 1.0 / (double)i / (double)(i + 1);
        }
        s3 *= (double)(n + 1);
        s3 += 1.0 / (double)n;

        f2 *= 4.0 * (double)s3 / (double)(n - 1);

        f1 *= PI;
        f2 *= PI;
        System.out.println(f1+f2);

    } 
}
