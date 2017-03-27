import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] arr = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = scan.nextInt();    
        }
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}