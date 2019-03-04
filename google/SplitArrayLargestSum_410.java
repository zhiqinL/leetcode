package leetcode.google;

public class SplitArrayLargestSum_410 {
    public static void main(String[] args) {
        int[] nums = new int[] {7, 2, 5, 10, 8};
        System.out.println(new SplitArrayLargestSum_410().splitArray(nums, 2));
    }


    public int splitArray(int[] nums, int m) {
//        int len = nums.length;
//
//        int[][] dp = new int[m + 1][len];
//
//        dp[1][0] = nums[0];
//        for(int i = 1; i < len; i++)
//            dp[1][i] = dp[1][i - 1] + nums[i];
//
//        for(int i = 2; i <= m; i++) {
//            for(int j = 1; j < len; j++) {
//                dp[i][j] = Integer.MAX_VALUE;
//                for(int k = 0; k < j; k++) {
//                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], dp[1][j] - dp[1][k]));
//                }
//            }
//        }
//
//        for(int val : dp[m])
//            System.out.println(val);
//
//        return dp[m][len - 1];
        return -1;
    }

    public int splitArray_2(int[] nums, int m) {
        int len = nums.length;

        int[][] dp = new int[m + 1][len];

        dp[1][0] = nums[0];
        for(int i = 1; i < len; i++)
            dp[1][i] = dp[1][i - 1] + nums[i];

        for(int n = 2; n <= m; n++) {
            for(int i = 1; i < len; i++) {
                dp[n][i] = Integer.MAX_VALUE;

                for(int k = n - 1; k < i; k++) {
                    dp[n][i] = Math.min(dp[n][i], Math.max(dp[n - 1][k], dp[1][i] - dp[1][k]));
                }
            }
        }

        return dp[m][len - 1];
    }
}
