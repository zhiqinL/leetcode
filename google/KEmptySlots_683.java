package leetcode.google;

import java.util.TreeSet;

public class KEmptySlots_683 {
    public static void main(String[] args) {
        KEmptySlots_683 test = new KEmptySlots_683();
        int[] temp = new int[] {1, 2, 3};
        System.out.println(test.kEmptySlots_3(temp, 1));
    }

    public int kEmptySlots_1(int[] flowers, int k) {
        TreeSet<Integer> positions = new TreeSet();
        for(int i = 0; i < flowers.length; i++) {
            positions.add(flowers[i]);
            Integer lower = positions.lower(flowers[i]);
            Integer upper = positions.higher(flowers[i]);
            if(lower != null && flowers[i] - lower - 1 == k) return i + 1;
            if(upper != null && upper - flowers[i] - 1 == k) return i + 1;
        }
        return -1;
    }

    public int kEmptySlots_2(int[] flowers, int k) {
//        int[] days = new int[flowers.length + 1];
//        for(int index = 0; index < flowers.length; index++)
//            days[flowers[index]] = index + 1;
//
//        int left = 1, right = k + 2, res = Integer.MAX_VALUE;
//        while(right <= flowers.length) {
//            boolean valid = true;
//            int max = Math.max(days[left], days[right]);
//            for(int i = left + 1; i < right; i++) {
//                if(days[i] < max) {
//                    left = i; right = i + k + 1;
//                    valid = false;
//                    break;
//                }
//            }
//            if(valid) {
//                res = Math.min(res, max);
//                left = right + 1;
//                right = left + k + 1;
//            }
//        }
//        return res == Integer.MAX_VALUE ? -1 : res;
        return -1;
    }

    public int kEmptySlots_3(int[] flowers, int k) {
        int[] days = new int[flowers.length + 1];
        for(int i = 0; i < flowers.length; i++) {
            days[flowers[i]] = i + 1;
        }

        int left = 1, right = k + 2, res = Integer.MAX_VALUE;
        while(right < days.length) {
            int max = Math.max(days[left], days[right]);
            boolean valid = true;
            for(int i = left + 1; i < right; i++) {
                if(days[i] < max) {
                    left = i; right = i + k + 1;
                    valid = false;
                    break;
                }
            }

            if(valid) {
                res = Math.min(res, max);
                left = right + 1;
                right = left + k + 1;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
