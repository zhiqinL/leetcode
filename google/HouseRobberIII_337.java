package leetcode.google;

import java.util.*;

public class HouseRobberIII_337 {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper(TreeNode node) {
        if(node == null) return new int[2];
        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int[] res = new int[2];
        res[0] = left[1] + right[1] + node.val;
        res[1] = Math.max(Math.max(left[0] + right[0], left[0] + right[1]), Math.max(left[1] + right[0], left[1] + right[1]));

        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
