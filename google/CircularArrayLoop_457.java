package leetcode.google;

public class CircularArrayLoop_457 {
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;

        for(int i = 0; i < len; i++) {
            if(nums[i] == 0) continue;
            int step = nums[i];
            int next = (i + step + len) % len;

            nums[i] = 0;

            if(next == i) continue;

            while(nums[next] != 0) {
                step = nums[next];
                nums[next] = 0;
                next = (next + step + len) % len;
            }

            if(next == i) return true;
        }

        return false;
    }
}
