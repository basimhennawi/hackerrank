import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int current = n;
        int added = 0;
        while (t-- > 1) {
            current -= in.nextInt();
            if (current < 5) {
                added += n - current;
                current = n;
            }
        }
        System.out.println(added);
    }
}
