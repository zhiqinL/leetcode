package leetcode.google;

public class IncreasingTripletSubsequence_334 {

    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;

        int min = Integer.MAX_VALUE, sec = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num > sec) return true;
            if(num < min)
                min = num;
            else if(num > min && num < sec)
                sec = num;
        }
        return false;
    }
}
