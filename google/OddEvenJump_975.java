package leetcode.google;

import java.util.*;

public class OddEvenJump_975 {
    public static void main(String[] args) {
        int[] test = new int[] {10, 13, 12, 14, 15};
        System.out.println(new OddEvenJump_975().oddEvenJumps(test));
    }

    public int oddEvenJumps(int[] A) {
        int len = A.length;
        int[] even = new int[len];
        int[] odd = new int[len];
        even[len - 1] = 1; odd[len - 1] = 1;

        TreeMap<Integer, Integer> map = new TreeMap();
        map.put(A[len - 1], len - 1);

        for(int i = len - 2; i >= 0; i--) {
            if(map.containsKey(A[i])) {
                even[i] = odd[map.get(A[i])];
                odd[i] = even[map.get(A[i])];
            } else {
                Integer lower = map.lowerKey(A[i]);
                Integer higher = map.higherKey(A[i]);

                if(lower != null) even[i] = odd[map.get(lower)];
                if(higher != null) odd[i] = even[map.get(higher)];
            }

            map.put(A[i], i);
        }

        int res = 0;
        for(int val : odd)
            if (val == 1) res++;

        return res;
    }
}
