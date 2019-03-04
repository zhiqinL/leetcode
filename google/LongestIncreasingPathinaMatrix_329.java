package leetcode.google;

public class LongestIncreasingPathinaMatrix_329 {


    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] record = new int[m][n];

        helper(matrix, 0, 0, Integer.MIN_VALUE, record);
        return res;
    }

    private int res = 0;
    private int helper(int[][] matrix, int x, int y, int prevVal, int[][] record) {
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return 0;
        if(record[x][y] <= prevVal) return 0;
        if(record[x][y] != 0) return record[x][y];

        int[] deltaX = new int[] {1, 0, -1, 0};
        int[] deltaY = new int[] {0, 1, 0, -1};

        int len = 0;
        for(int i = 0; i < 4; i++) {
            int nextX = x + deltaX[i];
            int nextY = y + deltaY[i];
            len = Math.max(len, helper(matrix, nextX, nextY, record[x][y], record));
        }

        record[x][y] = len + 1;
        res = Math.max(res, record[x][y]);
        return record[x][y];
    }
}
