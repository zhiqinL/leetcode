package leetcode.google;

import java.util.*;

public class MissingRanges_163 {
    public static void main(String[] args) {
        int[] nums = new int[] {2147483647};
        MissingRanges_163 test = new MissingRanges_163();

        for(String curt : test.findMissingRanges(nums, 0, 2147483647))
            System.out.print(curt + ", ");
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList();
        if(lower > upper) return res;

        long curt = lower;
        int index = 0;
        while(curt <= upper) {
            while(index < nums.length && curt > nums[index]) index++;

            if(index < nums.length && curt == nums[index]) {
                curt++;
                index++;
            } else {
                String temp = String.valueOf(curt);

                int right = index < nums.length ? Math.min(nums[index] - 1, upper) : upper;

                if(right > curt)
                    temp += "->" + (right);
                res.add(temp);

                if(index >= nums.length || right == upper) break;

                curt = (long) nums[index] + 1;
                index++;
            }
        }

        return res;
    }

    public List<String> findMissingRanges_2(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList();
        if(lower > upper) return res;

        long curt = lower;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < curt) continue;

            int right = Math.min(nums[i] - 1, upper);

            if(curt != nums[i] && curt <= right) {
                String temp = String.valueOf(curt);

                if(right > curt)
                    temp += "->" + right;

                res.add(temp);
            }
            curt = (long) nums[i] + 1;
        }

        if(curt == upper)
            res.add(String.valueOf(curt));
        else if(curt < upper)
            res.add(curt + "->" + upper);

        return res;
    }
}
