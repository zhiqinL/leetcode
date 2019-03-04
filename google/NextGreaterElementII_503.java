package leetcode.google;

import java.util.*;

public class NextGreaterElementII_503 {

    public int[] nextGreaterElements(int[] nums) {
//        if(nums.length == 0) return new int[0];
//
//        int len = nums.length;
//        int[] temp = new int[len * 2];
//        for(int i = 0; i < len; i++) {
//            temp[i] = nums[i];
//            temp[i + len] = nums[i];
//        }
//
//        Map<Integer, Integer> map = new HashMap();
//        Stack<Integer> stack = new Stack();
//
//        for(int i = 0; i < len * 2; i++) {
//            int curt = temp[i];
//            while(!stack.isEmpty() && curt > temp[stack.peek()])
//                map.put(stack.pop(), curt);
//
//            stack.push(i);
//        }
//
//        int[] res = new int[len];
//        for(int i = 0; i < len; i++)
//            res[i] = map.getOrDefault(i, -1);
//
//        return res;


        if(nums.length == 0) return new int[0];

        int len = nums.length;
        Stack<Integer> stack = new Stack();

        int[] res = new int[len];
        for(int i = 2 * len - 1; i >= 0; i--) {
            int curt = nums[i % len];
            while(!stack.isEmpty() && curt >= nums[stack.peek()])
                stack.pop();

            res[i % len] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % len);
        }

        return res;
    }
}
