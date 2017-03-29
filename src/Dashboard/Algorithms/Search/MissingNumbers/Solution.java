import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(in.next());
        }

        int m = Integer.parseInt(in.next());
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(in.next());
        }

        Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            if (dic.containsKey(B[i])) {
                dic.put(B[i], dic.get(B[i]) + 1);
            } else {
                dic.put(B[i], 1);
            }
        }

        for (int i = 0; i < n; i++) {
            dic.put(A[i], dic.get(A[i]) - 1);
            if (dic.get(A[i]) == 0) 
            {
                dic.remove(A[i]);
            }
        }

        Set<Integer> keys = dic.keySet();
        ArrayList<Integer> lst = new ArrayList<Integer>(keys);
        Collections.sort(lst);
        for (int i = 0; i < lst.size(); i++) {
            System.out.print(lst.get(i) + " ");
        }
    }
}
