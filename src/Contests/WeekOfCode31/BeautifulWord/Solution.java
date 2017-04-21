import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String s = in.nextLine();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)
                    || ("aeuoiy".indexOf(s.charAt(i)) > -1 && "aeuoiy".indexOf(s.charAt(i - 1)) > -1)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
