import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        sc.close();
        
        System.out.println(A.length() + B.length());
        if (A.compareTo(B) > 1) {
            System.out.println("Yes");   
        } else {
            System.out.println("No");
        }
        System.out.println(
            A.substring(0, 1).toUpperCase() + A.substring(1) + " " + B.substring(0, 1).toUpperCase() + B.substring(1)
        );
    }
}
