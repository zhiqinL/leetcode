package leetcode.google;

public class MinimizeMaxDistancetoGasStation_774 {
    public static void main(String[] args) {
        int[] test = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(new MinimizeMaxDistancetoGasStation_774().minmaxGasDist(test, 9));
    }

    public double minmaxGasDist(int[] stations, int K) {
        double left = 0.0, right = 1e8;

        while(right - left > 1e-6) {
            double mid = left + (right - left) / 2;
            int num = count(stations, mid);
            if(num > K) left = mid;
            else right = mid;
        }
        return left;
    }

    private int count(int[] stations, double gap) {
        int count = 0;

        for(int i = 0; i < stations.length - 1; i++)
            count += (stations[i + 1] - stations[i]) / gap;

        return count;
    }
}
