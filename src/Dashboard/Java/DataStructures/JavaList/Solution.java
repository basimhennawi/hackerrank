import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(in.nextInt());
        }
        int Q = in.nextInt();
        for (int i = 0; i < Q; i++) {
            switch (in.next()) {
                case "Insert":
                    list.add(in.nextInt(), in.nextInt());
                    break;
                case "Delete":
                    list.remove(in.nextInt());
                    break;
                default:
                    break;
            }
        }
        for (int e : list) {
            System.out.print(e + " ");
        }
    }
}
