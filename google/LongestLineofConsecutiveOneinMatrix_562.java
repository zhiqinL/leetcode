package leetcode.google;

public class LongestLineofConsecutiveOneinMatrix_562 {
    public static void main(String[] args) {
        int[][] test = new int[][] {
            {0,1,0,1,1},
            {1,1,0,0,1},
            {0,0,0,1,0},
            {1,0,1,1,1},
            {1,0,0,0,1}
        };

        System.out.println(new LongestLineofConsecutiveOneinMatrix_562().longestLine(test));
    }

    public int longestLine(int[][] M) {
        int row = M.length, col = M[0].length;

        int[][] dp = new int[col][4];

        int res = 0;
        for(int i = 0; i < row; i++) {
            int prev = 0;
            for(int j = 0; j < col; j++) {
                int temp = dp[j][1];
                if(M[i][j] == 1) {
                    dp[j][0] = j > 0 ? dp[j - 1][0] + 1 : 1;
                    dp[j][1] = prev + 1;
                    dp[j][2] = dp[j][2] + 1;
                    dp[j][3] = j < col - 1 ? dp[j + 1][3] + 1 : 1;

                    int curt = Math.max(Math.max(dp[j][0], dp[j][1]), Math.max(dp[j][2], dp[j][3]));
                    res = Math.max(res, curt);
                } else {
                    for(int x = 0; x < 4; x++) dp[j][x] = 0;
                }
                prev = temp;
            }
        }

        return res;
    }
}
