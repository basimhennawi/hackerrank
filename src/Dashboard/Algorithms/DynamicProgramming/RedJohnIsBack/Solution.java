import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Integer> prime = new ArrayList<Integer>();
        prime.add(2);
        for (int i = 3; i < 13310; i += 2) {
            if (isPrime(i))
                prime.add(i);
        }
        Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
        dic.put(0, 0);
        dic.put(1, 1);
        dic.put(2, 1);
        dic.put(3, 1);
        dic.put(4, 2);
        for (int i = 5; i < 41; i++) {
            dic.put(i, dic.get(i - 1) + dic.get(i - 4));
        }
        int last = dic.get(40);
        int u = 13311;
        while (u <= last) {
            if (isPrime(u))
                prime.add(u);
            u += 2;
        }

        int tc = in.nextInt();
        for (int x = 0; x < tc; x++) {
            int n = in.nextInt();

            int p = 0;
            for (int i = 0; i < prime.size(); i++) {
                if (prime.get(i) <= dic.get(n))
                    p++;
                else
                    break;
            }

            System.out.println(p);
        }
    }

    static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0)
            return false;

        for (int j = 3; j <= (n + 1) / 2; j += 2) {
            if (n % j == 0)
                return false;
        }
        return true;
    }
}
