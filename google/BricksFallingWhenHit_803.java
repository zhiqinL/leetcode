package leetcode.google;

public class BricksFallingWhenHit_803 {

    public static void main(String[] args) {
        int[][] grid = new int[][] {{1}, {1}, {1}, {1}, {1}};
        int[][] hits = new int[][] {{3, 0}, {4, 0}, {1, 0}, {2, 0}, {0, 0}};
        System.out.println(new BricksFallingWhenHit_803().hitBricks(grid, hits));
    }

    private int[] father;
    private int[] sizes;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length, n = grid[0].length;
        int len = m * n + 1;

        father = new int[len]; sizes = new int[len];

        for(int i = 0; i < len; i++) {
            father[i] = i;
            sizes[i] = 1;
        }

        sizes[0] = 0;

        for(int[] hit : hits) {
            int x = hit[0], y = hit[1];
            if(grid[x][y] != 1) continue;

            grid[x][y] = 2;
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 1) continue;
                unionAround(grid, i, j);
            }
        }

        int count = sizes[0];
        int[] res = new int[hits.length];

        for(int i = hits.length - 1; i >= 0; i--) {
            int[] hit = hits[i];
            int x = hit[0], y = hit[1];

            if(grid[x][y] == 2) {
                unionAround(grid, x, y);
                grid[x][y] = 1;
            }
            int size = sizes[find(0)];
            res[i] = size > count ? size - count - 1 : 0;
            count = size;
        }
        return res;
    }

    private void unionAround(int[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        int[] deltaX = new int[] {1, 0, -1, 0};
        int[] deltaY = new int[] {0, 1, 0, -1};

        int curt = twoDtoOneD(x, y, n);

        for(int i = 0; i < 4; i++) {
            int nextX = x + deltaX[i];
            int nextY = y + deltaY[i];
            if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) continue;

            if(grid[nextX][nextY] == 1) {
                int next = twoDtoOneD(nextX, nextY, n);
                union(curt, next);
            }
        }

        if(x == 0) union(0, curt);
    }

    private int twoDtoOneD(int x, int y, int len) {
        return x * len + y + 1;
    }

    private void union(int a, int b) {
        int a_f = find(a);
        int b_f = find(b);

        if(a_f == b_f) return;

        father[b_f] = a_f;
        sizes[a_f] += sizes[b_f];
    }

    private int find(int val) {
        if(father[val] == val) return val;
        return father[val] = find(father[val]);
    }
}
