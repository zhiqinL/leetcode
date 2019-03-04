package leetcode.uber;

import java.util.Arrays;

public class DesignHitCounter_362 {
    private final int BASE = 300;
    private int[] counts;
    private int total;
    private int start;
    private int num;
    /** Initialize your data structure here. */
    public DesignHitCounter_362() {
        counts = new int[301];
        total = 0;
        start = 1;
        num = 1;
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        preGenerate(timestamp);
        int index = timestamp % BASE;
        counts[index]++;
        total++;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        preGenerate(timestamp);
        return total;
    }

    private void preGenerate(int timestamp) {
        int index = timestamp % BASE;
        if(timestamp > (num + 1) * 300) {
            Arrays.fill(counts, 0);
            total = 0;
        } else {
            for (int i = start; i <= index; i++) {
                total -= counts[i];
                counts[i] = 0;
            }
        }
        num = timestamp / 300 + 1;
        start = index + 1;
    }
}
