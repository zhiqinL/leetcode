package leetcode.google.high_frequency;

public class RedundantConnection_684 {

    public static void main(String[] args) {

    }

    private int[] parents;
    public int[] findRedundantConnection(int[][] edges) {
        int length = edges.length;
        parents = new int[length + 1];

        for(int i = 1; i <= length; i++)
            parents[i] = i;

        for(int[] edge : edges) {
            int left = find(edge[0]);
            int right = find(edge[1]);

            if(left == right)
                return edge;

            parents[right] = left;
        }
        return new int[] {};
    }

    private int find(int value) {
        if(parents[value] == value)
            return value;
        return parents[value] = find(parents[value]);
    }
}
