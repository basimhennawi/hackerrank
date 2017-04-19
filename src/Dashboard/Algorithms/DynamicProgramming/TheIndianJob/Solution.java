import java.util.HashSet;
import java.util.Scanner;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int tc = in.nextInt();
        while (tc-- > 0) {
            int n = in.nextInt();
            int G = in.nextInt();
            int[] A = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                A[i] = in.nextInt();
                sum += A[i];
            }
            if (sum > 2 * G) {
                System.out.println("NO");
            } else {
                HashSet<Integer> sums = new HashSet<Integer>();

                for (int cur : A) {
                    HashSet<Integer> b = new HashSet<Integer>(sums);
                    b.add(cur);
                    for (int item : sums) {
                        if (item + cur <= G) {
                            b.add(item + cur);
                        }
                    }
                    sums = b;
                }

                boolean found = false;
                for (int s : sums) {
                    found |= s <= G && sum - s <= G;
                }

                System.out.println(found ? "YES" : "NO");
            }
        }
    }
}
