package leetcode.google.high_frequency;

public class RedundantConnectionII_685 {


    private int[] parents;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] records = new int[edges.length + 1];

        int[] possible1 = null;
        int[] possible2 = null;
        for(int[] curt : edges) {
            int left = curt[0], right = curt[1];

            if(records[right] != 0) {
                possible1 = new int[] { records[curt[1]], curt[1] };
                possible2 = new int[] { curt[0], curt[1] };

                curt[0] = curt[1] = -1;
            }

            records[right] = left;
        }

        parents = new int[edges.length + 1];

        for(int[] edge : edges) {

            int left = edge[0], right = edge[1];

            if(left == -1 && right == -1) continue;

            if(parents[left] == 0) parents[left] = left;
            if(parents[right] == 0) parents[right] = right;

            int left_parent = find(left);
            int right_parent = find(right);

            if(left_parent == right_parent)
                return possible1 == null ? edge : possible1;

            parents[right_parent] = left_parent;
        }

        return possible2;
    }

    private int find(int value) {
        if(parents[value] == value)
            return value;
        return parents[value] = find(parents[value]);
    }
}
