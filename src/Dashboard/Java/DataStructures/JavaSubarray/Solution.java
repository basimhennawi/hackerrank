import java.util.Scanner;

public class Solution {
    private static int negativeSubarrays(int[] array) {
        int count = 0;
        int sum   = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (sum < 0) {
                    count++;
                }
            }
            sum = 0;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int[] a = new int[x];
        for (int i = 0; i < x; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(negativeSubarrays(a));
    }
}
