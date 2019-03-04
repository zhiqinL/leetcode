package leetcode.uber;

public class ConstructQuadTree_427 {

    public Node construct(int[][] grid) {
        int length = grid.length;
        return helper(grid, 0, 0, length);
    }

    private Node helper(int[][] grid, int x, int y, int length) {
        if(length == 1) return new Node(grid[x][y] == 1, true, null, null, null, null);

        length /= 2;
        Node n1 = helper(grid, x, y, length);
        Node n2 = helper(grid, x + length, y, length);
        Node n3 = helper(grid, x, y + length, length);
        Node n4 = helper(grid, x + length, y + length, length);
        if(n1.isLeaf && n2.isLeaf && n3.isLeaf && n4.isLeaf) {
            if(n1.val == n2.val && n1.val == n3.val && n1.val == n4.val)
                return new Node(n1.val, true, null, null, null, null);
        }

        return new Node(false, false, n1, n2, n3, n4);
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}

