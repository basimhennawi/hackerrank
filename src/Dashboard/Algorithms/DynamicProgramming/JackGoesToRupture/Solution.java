import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Hackerrank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next());
        int e = Integer.parseInt(in.next());

        ArrayList<HashSet<Pair>> adjacencyList = new ArrayList<HashSet<Pair>>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new HashSet<Pair>());
        }

        for (int i = 0; i < e; i++) {
            int a = Integer.parseInt(in.next()) - 1;
            int b = Integer.parseInt(in.next()) - 1;
            int c = Integer.parseInt(in.next());
            adjacencyList.get(a).add(new Pair(b, c));
            adjacencyList.get(b).add(new Pair(a, c));
        }

        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = -1;
        }

        Queue<Integer> Q = new LinkedList<Integer>();
        Q.add(0);
        cost[0] = 0;

        while (Q.size() > 0) {
            int current = Q.poll();
            int so_far = cost[current];
            for (Pair item : adjacencyList.get(current)) {
                int next = item.first, price = Math.max(item.second, so_far);

                if (cost[next] == -1 || price < cost[next]) {
                    Q.add(next);
                    cost[next] = price;
                }
            }
        }
        System.out.println(cost[n - 1] == -1 ? "NO PATH EXISTS" : cost[n - 1]);
    }
    public static class Pair {
        public int first, second;
        public Pair(int a, int b) {
            first = a;
            second = b;
        }
    }
}
