package leetcode.google;

import java.util.*;

public class Candy_135 {
    public static void main(String[] args) {
        int[] test = new int[] {1, 0, 2};
        System.out.println(new Candy_135().candy(test));
    }

    public int candy(int[] ratings) {
//        int len = ratings.length;
//        Integer[] indexes = new Integer[len];
//
//        for(int i = 0; i < len; i++)
//            indexes[i] = i;
//
//        Arrays.sort(indexes, (a, b) -> ratings[a] == ratings[b] ? a - b : ratings[a] - ratings[b]);
//
//        int[] nums = new int[len];
//        int res = 0;
//
//        for(int index : indexes) {
//            int num = 1;
//            if(index - 1 >= 0 && ratings[index] > ratings[index - 1])
//                num = nums[index - 1] + 1;
//
//            if(index + 1 < len && ratings[index] > ratings[index + 1])
//                num = Math.max(num, nums[index + 1] + 1);
//
//            nums[index] = num;
//            res += num;
//        }
//        return res;

        int len = ratings.length;
        int[] count = new int[len];

        Arrays.fill(count, 1);

        for(int i = 1; i < len; i++) {
            if(ratings[i] > ratings[i - 1])
                count[i] = count[i - 1] + 1;
        }

        int res = count[len - 1];
        for(int i = len - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1])
                count[i] = Math.max(count[i], count[i + 1] + 1);
            res += count[i];
        }

        return res;
    }
}
