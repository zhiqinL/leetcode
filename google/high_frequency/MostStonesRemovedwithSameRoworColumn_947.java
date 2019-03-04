package leetcode.google.high_frequency;

public class MostStonesRemovedwithSameRoworColumn_947 {
    private int[] parents;
    public int removeStones(int[][] stones) {
        int len = stones.length;
        parents = new int[len];

        for(int i = 0; i < len; i++)
            parents[i] = i;

        for(int i = 0; i < len; i++) {
            int[] left = stones[i];
            for(int j = i + 1; j < len; j++) {
                int[] right = stones[j];
                if(left[0] == right[0] || left[1] == right[2]) {
                    int l_p = find(i);
                    int r_p = find(j);

                    if(l_p != r_p) parents[r_p] = l_p;
                }
            }
        }

        int res = len;
        for(int i = 0; i < len; i++) {
            if(parents[i] == i) res--;
        }

        return res;
    }

    private int find(int val) {
        if(parents[val] == val) return val;
        return parents[val] = find(parents[val]);
    }
}
