package leetcode.uber;

public class ValidSudoku_36 {

    public boolean isValidSudoku(char[][] board) {
        int[][] cols = new int[9][10];
        int[][] boxes = new int[9][10];

        for(int i = 0; i < 9; i++) {
            int[] row = new int[10];

            for(int j = 0; j < 9; j++) {
                char curt = board[i][j];
                if(curt == '.') continue;

                int num = curt - '0';
                int boxIndex = (i / 3) * 3 + (j / 3);

                if(row[num] != 0 || cols[j][num] != 0 || boxes[boxIndex][num] != 0)
                    return false;

                row[num]++;
                cols[j][num]++;
                boxes[boxIndex][num]++;
            }
        }

        return true;
    }
}
