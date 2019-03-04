package leetcode.google;

public class PredicttheWinner_486 {
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length < 3) return true;

        int len = nums.length;
        int[][] dp = new int[len][len];
        int sum = 0;
        for(int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
            sum += nums[i];
        }

        for(int i = len - 1; i >= 0; i--) {
            for(int j = i + 1; j < len; j++) {
                if(i + 1 == j) {
                    dp[i][j] = Math.max(dp[i][i], dp[j][j]);
                    continue;
                }
                int takeLeft = Math.min(dp[i + 1][j - 1], dp[i + 2][j]) + nums[i];
                int takeRight = Math.min(dp[i + 1][j - 1], dp[i][j - 2]) + nums[j];
                dp[i][j] = Math.max(takeLeft, takeRight);
            }
        }

        return dp[0][len - 1] * 2 > sum;
    }
}
