package leetcode.google;

import java.util.*;

public class NextGreaterElementI_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];

        Map<Integer, Integer> map = new HashMap();
        Stack<Integer> stack = new Stack();

        for(int num : nums2) {
            while(!stack.isEmpty() && num > stack.peek())
                map.put(stack.pop(), num);

            stack.push(num);
        }

        int[] res = new int[nums1.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }

        return res;
    }
}
