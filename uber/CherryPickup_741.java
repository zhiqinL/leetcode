package leetcode.uber;

import java.util.*;

public class CherryPickup_741 {

    public int cherryPickup(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;

        int len = grid.length;
        int[][][] record = new int[len][len][len];
        for(int[][] two : record)
            for(int[] one : two)
                Arrays.fill(one, Integer.MIN_VALUE);

        helper(grid, 0, 0, 0, len, record);
        return record[len - 1][len - 1][len - 1];
    }

    private int helper(int[][] grid, int r1, int c1, int c2, int len, int[][][] record) {
        int r2 = r1 + c1 - c2;
        if(r1 == len || c1 == len || r2 == len || c2 == len || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE + 1;

        if(r1 == len - 1 && c1 == len - 1) return grid[len - 1][len - 1];
        if(record[r1][c1][c2] != Integer.MIN_VALUE) return record[r1][c1][c2];

        int res = grid[r1][c1];
        if(c1 != c2) res += grid[r2][c2];
        res += Math.max(
                Math.max(helper(grid, r1 + 1, c1, c2, len, record), helper(grid, r1, c1 + 1, c2 + 1, len, record)),
                Math.max(helper(grid, r1 + 1, c1, c2 + 1, len, record), helper(grid, r1, c1 + 1, c2, len, record))
        );
        record[r1][c1][c2] = res;
        return res;
    }

    public int cherryPickup_2(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;

        int len = grid.length;
        int[][] dp = new int[len][len];

        for(int n = 1; n < len * len - 1; n++) {
            for(int i = Math.min(n, len - 1); i >= 0 && i >= n - len + 1; i++) {
                for(int j = Math.min(n, len - 1); j >= 0 && j >= n - len + 1; j++) {
                    int p = n - i, q = n - j;

                    if(grid[i][p] == -1 || grid[j][q] == -1) {
                        dp[i][j] = Integer.MIN_VALUE;
                        continue;
                    }

                    int val = grid[i][p];
                    if(i != j) val += grid[j][q];

                    for(int pi = i - 1; pi <= i; pi++) {
                        for(int pj = j - 1; pj <= j; pj++) {
                            if(pi >= 0 && pj >= 0) dp[i][j] = Math.max(dp[i][j], dp[pi][pj]);
                        }
                    }
                    dp[i][j] += val;
                }
            }
        }
        return dp[len - 1][len - 1];
    }
}
