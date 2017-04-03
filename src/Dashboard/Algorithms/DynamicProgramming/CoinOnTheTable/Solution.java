import java.util.Scanner;

public class Hackerrank {

    static Scanner in = new Scanner(System.in);
    static int cot_k, cot_n, cot_m;
    static int[][][] cot_score;
    public static void main(String[] args) {
        cot_n = in.nextInt();
        cot_m = in.nextInt();
        cot_k = in.nextInt();
        String[] map = new String[cot_n];
        int x = -1, y = -1;
        for (int i = 0; i < cot_n; i++) {
            map[i] = in.next();
            if (y < 0) {
                x = i;
                y = map[i].indexOf('*');
            }
        }

        cot_score = new int[cot_n][cot_m][cot_k + 1];
        for (int i = 0; i < cot_n; i++) {
            for (int j = 0; j < cot_m; j++) {
                for (int k = 0; k <= cot_k; k++)
                    cot_score[i][j][k] = -1;
            }
        }

        track(map, 0, 0, 0, 0);

        int ans = -1;
        for (int i = 0; i <= cot_k; i++) {
            if (cot_score[x][y][i] == -1)
                continue;
            if (ans < 0 || ans > cot_score[x][y][i]) {
                ans = cot_score[x][y][i];
            }
        }
        System.out.println(ans);
    }
    static void track(String[] map, int r, int c, int prev, int step) {
        if (cot_score[r][c][step] >= 0 && cot_score[r][c][step] <= prev)
            return;
        cot_score[r][c][step] = prev;

        if (step >= cot_k)
            return;

        prev++;
        int a1 = prev, a2 = prev, a3 = prev, a4 = prev;
        switch (map[r].charAt(c)) {
            case 'U' : a1--; break;
            case 'D' : a2--; break;
            case 'R' : a3--; break;
            case 'L' : a4--; break;
            default  : return;
        }
        step++;
        if (r > 0)
            track(map, r - 1, c, a1, step);
        if (r < cot_n - 1)
            track(map, r + 1, c, a2, step);
        if (c < cot_m - 1)
            track(map, r, c + 1, a3, step);
        if (c > 0)
            track(map, r, c - 1, a4, step);
    }
}
