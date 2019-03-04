package leetcode.google;

import java.util.HashSet;
import java.util.Set;

interface Robot {
    public boolean move();
    public void turnLeft();
    public void turnRight();
    public void clean();
}

public class RobotRoomCleaner_489 {
    public void cleanRoom(Robot robot) {
        Set<String> hash = new HashSet();
        dfs(robot, 0, 0, 0, hash);
    }

    private void dfs(Robot robot, int x, int y, int dir, Set<String> hash) {
        String pos = x + "|" + y;
        if(!hash.add(pos)) return;

        robot.clean();

        int[] deltaX = new int[] {1, -1, 0, 0};
        int[] deltaY = new int[] {0, 0, 1, -1};

        for(int i = 0; i < 4; i++) {
            if(robot.move()) {
                dfs(robot, x + deltaX[dir], y + deltaY[dir], dir, hash);
                moveBack(robot);
            }
            robot.turnRight();
            dir++;
            if(dir == 4) dir = 0;
        }
    }

    private void moveBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
}
