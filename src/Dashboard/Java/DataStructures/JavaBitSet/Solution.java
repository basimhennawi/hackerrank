import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        for (int i = 0; i < m; i++) {
            String operation = in.next();
            int first = in.nextInt();
            int second = in.nextInt();
            switch (operation) {
                case "AND":
                    switch (first) {
                        case 1: {
                            b1.and(b2);
                            break;
                        }
                        case 2: {
                            b2.and(b1);
                            break;
                        }
                    }
                    break;
                case "OR":
                    switch (first) {
                        case 1: {
                            b1.or(b2);
                            break;
                        }
                        case 2: {
                            b2.or(b1);
                            break;
                        }
                    }
                    break;
                case "XOR":
                    switch (first) {
                        case 1: {
                            b1.xor(b2);
                            break;
                        }
                        case 2: {
                            b2.xor(b1);
                            break;
                        }
                    }
                    break;
                case "FLIP":
                    switch (first) {
                        case 1: {
                            b1.flip(second);
                            break;
                        }
                        case 2: {
                            b2.flip(second);
                            break;
                        }
                    }
                    break;
                case "SET":
                    switch (first) {
                        case 1: {
                            b1.set(second);
                            break;
                        }
                        case 2: {
                            b2.set(second);
                            break;
                        }
                    }
                    break; 
            }
            System.out.printf("%d %d\n", b1.cardinality(), b2.cardinality());
        }
    }
}
