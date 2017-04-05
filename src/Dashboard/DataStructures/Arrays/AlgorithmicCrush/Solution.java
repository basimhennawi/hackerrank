import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int a, b, k;
        
        long[] arr = new long[N + 1];
        
        for (int i = 0; i < M; i++) {
            a = in.nextInt();
            b = in.nextInt();
            k = in.nextInt();
            
            arr[a - 1] += k;
            arr[b] -= k;
        }
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
