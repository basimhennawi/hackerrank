import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int d = in.nextInt();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[(i + N - d) % N] = in.nextInt();
        }
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }
}
