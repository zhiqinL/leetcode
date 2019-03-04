package leetcode.google;

import java.util.*;

public class SumofDistancesinTree_834 {
    public static void main(String[] args) {
        int[][] edges = new int[][] {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        SumofDistancesinTree_834 test = new SumofDistancesinTree_834();
        for(int val : test.sumOfDistancesInTree(6, edges))
            System.out.print(val + ", ");
    }

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        List<Set<Integer>> graph = new ArrayList();

        for(int i = 0; i < N; i++)
            graph.add(new HashSet());

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] res = new int[N];
        int[] count = new int[N];

        Arrays.fill(count, 1);

        dfs_1(graph, 0, -1, res, count);
        dfs_2(graph, 0, -1, res, count, N);

        return res;
    }

    private void dfs_1(List<Set<Integer>> graph, int node, int parent, int[] res, int[] count) {
        for(int child : graph.get(node)) {
            if(child == parent) continue;
            dfs_1(graph, child, node, res, count);
            count[node] += count[child];
            res[node] += res[child] + count[child];
        }
    }

    private void dfs_2(List<Set<Integer>> graph, int node, int parent, int[] res, int[] count, int N) {
        for(int child : graph.get(node)) {
            if(child == parent) continue;
            res[child] = res[node] - count[child] + N - count[child];
            dfs_2(graph, child, node, res, count, N);
        }
    }
}
