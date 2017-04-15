import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int x = in.nextInt();
        in.close();
        
        TreeSet<String> substrings = new TreeSet<String>();
        for (int i = 0; i <= (s.length() - x); i++) {
            substrings.add(s.substring(i, i+x));
        }
        System.out.println(substrings.first());
        System.out.println(substrings.last());
    }
}
