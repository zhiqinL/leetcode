package leetcode.google.high_frequency;

public class SplitArrayintoConsecutiveSubsequences_659 {
    public boolean isPossible(int[] nums) {
//        int first = nums[0], len = nums[nums.length - 1] - first + 1;
//        int[] count = new int[len + 1];
//
//        for(int num : nums)
//            count[num - first + 1]++;
//
//        int left = 1, right = 1;
//        while(right <= len) {
//            while(right < len && count[right] <= count[right + 1]) right++;
//            if(right - left < 2) return false;
//
//            for(int i = left; i <= right; i++) {
//                count[i]--;
//                if(count[i] == 0) left = i + 1;
//            }
//
//            while(right <= len && count[right] == 0) {
//                right++;
//                left = right;
//            }
//        }
//        return true;



        int first = nums[0], len = nums[nums.length - 1] - first + 1;
        int[] count = new int[len + 1];

        for(int num : nums)
            count[num - first + 1]++;

        int left = 1, right = 1;
        while(right <= len) {
            while(right < len && count[right] <= count[right + 1]) right++;
            if(right - left < 2) return false;

            for(int i = left; i <= right; i++) {
                count[i]--;
                if(count[i] == 0) left = i + 1;
            }

            while(right <= len && count[right] == 0) {
                right++;
                left = right;
            }
        }

        return true;
    }
}
