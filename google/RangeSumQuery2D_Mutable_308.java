package leetcode.google;

public class RangeSumQuery2D_Mutable_308 {

    private int[][] hash;
    private int rowsNum, colsNum;
    public RangeSumQuery2D_Mutable_308(int[][] matrix) {
        rowsNum = matrix.length; colsNum = matrix[0].length;
        hash = new int[rowsNum][colsNum + 1];
        initValue(matrix);
    }

    private void initValue(int[][] matrix) {
        for(int index = 0; index < rowsNum; index++) {
            int[] curt = matrix[index];
            int[] row = hash[index];

            for(int i = 1; i <= colsNum; i++)
                row[i] = row[i - 1] + curt[i - 1];
        }
    }

    public void update(int row, int col, int val) {
        int[] curt = hash[row];
        int diff = val - (curt[col + 1] - curt[col]);
        for(int index = col + 1; index <= colsNum; index++)
            curt[index] += diff;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for(int index = row1; index <= row2; index++) {
            int[] row = hash[index];
            sum += row[col2 + 1] - row[col1];
        }
        return sum;
    }
}
