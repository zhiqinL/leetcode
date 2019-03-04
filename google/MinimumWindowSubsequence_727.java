package leetcode.google;

public class MinimumWindowSubsequence_727 {

    public String minWindow(String S, String T) {
//        int m = S.length(), n = T.length();
//        int[][] dp = new int[m][n];
//
//        for(int i = 0; i < m; i++) {
//            if(S.charAt(i) == T.charAt(0))
//                dp[i][0] = i;
//            else {
//                if(i == 0) dp[i][0] = -1;
//                else dp[i][0] = dp[i - 1][0];
//            }
//        }
//
//        for(int j = 1; j < n; j++) {
//            dp[0][j] = -1;
//
//            for(int i = 1; i < m; i++) {
//                if(S.charAt(i) == T.charAt(j))
//                    dp[i][j] = dp[i - 1][j - 1];
//                else
//                    dp[i][j] = dp[i - 1][j];
//            }
//        }
//
//        int start = 0, len = m + 1;
//        for(int i = n - 1; i < m; i++) {
//            if(dp[i][n - 1] == -1) continue;
//
//            if(i - dp[i][n - 1] + 1 < len) {
//                start = dp[i][n - 1];
//                len = i - dp[i][n - 1] + 1;
//            }
//        }
//
//        return S.substring(start, start + len);
        return "";
    }

    public String minWindow_2(String S, String T) {
        int m = S.length(), n = T.length();
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            if(S.charAt(i) == T.charAt(0))
                dp[i][0] = i;
            else {
                if(i == 0) dp[i][0] = -1;
                else dp[i][0] = dp[i - 1][0];
            }
        }

        for(int j = 1; j < n; j++) {
            dp[0][j] = -1;

            for(int i = 1; i < m; i++) {
                if(S.charAt(i) == T.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        int start = 0, len = m + 1;
        for(int i = n - 1; i < m; i++) {
            if(dp[i][n - 1] == -1) continue;

            if(i - dp[i][n - 1] + 1 < len) {
                start = dp[i][n - 1];
                len = i - start + 1;
            }
        }

        return len == m + 1 ? "" : S.substring(start, start + len);
    }
}
