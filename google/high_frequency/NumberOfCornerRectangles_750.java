package leetcode.google.high_frequency;

public class NumberOfCornerRectangles_750 {
    public int countCornerRectangles(int[][] grid) {

        int row = grid.length, col = grid[0].length;

        int res = 0;
        int[][] state = new int[col][col];
        for(int i = 0; i < row; i++) {

            for(int j = 0; j < col; j++) { if(grid[i][j] == 1)
                for(int c = j + 1; c < col; c++) {
                    if(grid[i][c] == 1) {
                        res += state[j][c];
                        state[j][c]++;
                    }
                }
            }
        }
        return res;
    }
}
