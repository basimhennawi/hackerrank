import java.util.Scanner;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int n = in.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }

        int ans = 1;
        int[] s = new int[n + 10];
        for (int i = 1; i < n; i++) {
            if (A[i] >= A[s[ans]]) {
                ans++;
                s[ans] = i;
            } else {
                int low = 1, high = ans;
                while (high > low) {
                    int mid = (high + low) / 2;

                    if (A[s[mid]] == A[i]) {
                        low = mid;
                        break;
                    }

                    if (A[s[mid]] > A[i])
                        high = mid;
                    else
                        low = mid + 1;
                }

                if (A[s[low]] >= A[i]) {
                    s[low] = i;
                }
            }
        }

        System.out.println(ans);
    }
}
