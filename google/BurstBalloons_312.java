package leetcode.google;

public class BurstBalloons_312 {
    public static void main(String[] args) {
        int[] test = new int[] {3, 1, 5, 8};
        System.out.println(new BurstBalloons_312().maxCoins(test));
    }

    public int maxCoins(int[] nums) {
        if(nums.length == 0) return 0;

        int len = nums.length;
        int[][] dp = new int[len][len];

//        for(int l = 1; l <= len; l++) {
//            for(int i = 0; i <= len - l; i++) {
//                int j = i + l - 1;
//
//                for(int k = i; k <= j; k++) {
//                    int left = 1, right = 1;
//                    int prevVal = 0, nextVal = 0;
//
//                    if(i > 0) left = nums[i - 1];
//                    if(j < nums.length - 1) right = nums[j + 1];
//
//                    if(k > i) prevVal = dp[i][k - 1];
//                    if(k < j) nextVal = dp[k + 1][j];
//
//                    int curt = left * nums[k] * right;
//
//                    dp[i][j] = Math.max(dp[i][j], prevVal + curt + nextVal);
//                }
//            }
//        }

        for(int i = len - 1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                int left = 1, right = 1;

                if(i > 0) left = nums[i - 1];
                if(j < len - 1) right = nums[j + 1];

                for(int k = i; k <= j; k++) {
                    int beforeVal = 0, afterVal = 0;

                    if(k > i) beforeVal = dp[i][k - 1];
                    if(k < j) afterVal = dp[k + 1][j];

                    int curt = left * nums[k] * right;

                    dp[i][j] = Math.max(dp[i][j], beforeVal + curt + afterVal);
                }
            }
        }

        return dp[0][len - 1];
    }
}
