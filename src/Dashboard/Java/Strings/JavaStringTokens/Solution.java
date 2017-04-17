import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
 
		StringTokenizer t = new StringTokenizer(s, " !,?._'@");
        System.out.println(t.countTokens());
		while (t.hasMoreTokens()) {
			System.out.println(t.nextToken());
		}
    }
}
