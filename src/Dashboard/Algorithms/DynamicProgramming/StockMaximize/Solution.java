import java.util.Scanner;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int tc = in.nextInt();
        while (tc-- > 0) {
            int nt = in.nextInt();
            double[] stock = new double[nt];
            double profit = 0, max = 0;
            int maxi = 0;
            for (int i = 0; i < nt; i++) {
                stock[i] = in.nextDouble();
                if (stock[i] > max) {
                    max = stock[i];
                    maxi = i;
                }
            }

            while (max > 0) {
                for (int i = maxi - 1; i >= 0; i--) {
                    if (stock[i] < 1)
                        break;
                    profit += max - stock[i];
                    stock[i] = 0;
                }
                stock[maxi] = 0;
                max = 0;
                maxi = 0;
                for (int i = 0; i < nt; i++) {
                    if (stock[i] > max) {
                        max = stock[i];
                        maxi = i;
                    }
                }
            }
            System.out.println((long)profit);
        }
    }
}
