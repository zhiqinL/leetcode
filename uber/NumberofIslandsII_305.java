package leetcode.uber;

import java.util.*;

public class NumberofIslandsII_305 {

    private int[] parent;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList();
        if(m == 0 || n == 0 || positions.length == 0) return res;

        parent = new int[m * n];
        Arrays.fill(parent, -1);
        Set<Integer> islands = new HashSet();

        int[] deltaX = new int[] {0, 1, 0, -1};
        int[] deltaY = new int[] {1, 0, -1, 0};

        int count = 0;
        for(int[] pos : positions) {
            count++;
            int curt = pos[0] * n + pos[1];
            for(int i = 0; i < 4; i++) {
                int nextX = pos[0] + deltaX[i];
                int nextY = pos[1] + deltaY[i];
                int next = nextX * n + nextY;

                if(!isValid(m, n, nextX, nextY) || !islands.contains(next)) continue;

                int curtParent = find(curt);
                int nextParent = find(next);

                if(curtParent == nextParent) continue;

                parent[nextParent] = curtParent;
                count--;
            }

            islands.add(curt);
            res.add(count);
        }

        return res;
    }

    private int find(int val) {
        if(parent[val] == -1)
            return val;

        return parent[val] = find(parent[val]);
    }

    private boolean isValid(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
