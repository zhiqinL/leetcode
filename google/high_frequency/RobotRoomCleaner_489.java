package leetcode.google.high_frequency;

import java.util.*;

public class RobotRoomCleaner_489 {

    public void cleanRoom(Robot robot) {
        helper(robot, 0, 0, 0, new HashSet());
    }

    private void helper(Robot robot, int direction, int x, int y, Set<String> hash) {
        String temp = x + "," + y;
        if(!hash.add(temp)) return;

        robot.clean();

        int[] deltaX = new int[] {1, 0, -1, 0};
        int[] deltaY = new int[] {0, 1, 0, -1};

        for(int i = 0; i < 4; i++) {
            int nextX = x + deltaX[direction];
            int nextY = y + deltaY[direction];

            if(robot.move()) {
                helper(robot, direction, nextX, nextY, hash);
                moveBack(robot);
            }

            robot.turnRight();

            direction++;
            if(direction >= 4) direction = 0;
        }
    }

    private void moveBack(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();
    public void turnRight();

    // Clean the current cell.
    public void clean();
}
