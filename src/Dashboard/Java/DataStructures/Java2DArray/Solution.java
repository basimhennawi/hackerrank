import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A[][] = new int[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                A[i][j] = in.nextInt();
            }
        }
        in.close();
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int sum = A[row+0][col+0] + A[row+0][col+1] + A[row+0][col+2]
                                          + A[row+1][col+1] +
                          A[row+2][col+0] + A[row+2][col+1] + A[row+2][col+2];
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}
