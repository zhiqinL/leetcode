package leetcode.google;

import java.util.*;

public class TheMazeII_505 {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;

        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(maze[i], Integer.MAX_VALUE);

        dist[start[0]][start[1]] = 0;

        int[] deltaX = new int[] {1, 0, -1, 0};
        int[] deltaY = new int[] {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList();
        queue.offer(start);

        while(!queue.isEmpty()) {
            int[] curt = queue.poll();

            for(int i = 0; i < 4; i++) {
                int count = 0;
                int x = curt[0], y = curt[1];

                while(isValid(maze, x + deltaX[i], y + deltaY[i])) {
                    x += deltaX[i];
                    y += deltaY[i];
                    count++;
                }

                if(dist[curt[0]][curt[1]] + count < dist[x][y]) {
                    dist[x][y] = dist[curt[0]][curt[1]] + count;
                    queue.offer(new int[] {x, y});
                }
            }
        }

        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }

    private boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }
}
