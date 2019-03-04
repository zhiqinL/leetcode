package leetcode.google.high_frequency;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCosttoHireKWorkers_857 {
    public static void main(String[] args) {

    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int len = quality.length;
        double[][] workers = new double[len][2];

        for(int i = 0; i < len; i++)
            workers[i] = new double[] {(double) wage[i] / quality[i], (double) quality[i]};

        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        PriorityQueue<Double> heap = new PriorityQueue<>((a, b) -> Double.compare(b, a));

        double temp = 0.0, res = Double.MAX_VALUE;
        for(double[] curt : workers) {
            temp += curt[1];
            heap.offer(curt[1]);
            if(heap.size() > K) temp -= heap.poll();
            if(heap.size() == K) res = Math.min(res, curt[0] * temp);
        }
        return res;
    }
}
