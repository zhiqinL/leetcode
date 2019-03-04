package leetcode.google.high_frequency;

import java.util.Arrays;
import java.util.Comparator;

public class CarFleet_853 {
    public static void main(String[] args) {
        int[] position = new int[] {6, 8};
        int[] speed = new int[] {3, 2};
        System.out.println(new CarFleet_853().carFleet(10, position, speed));
    }

    public int carFleet(int target, int[] position, int[] speed) {
        if(position == null || position.length == 0) return 0;

        int len = position.length;
        Integer[] index = new Integer[len];
        for(int i = 0; i < len; i++)
            index[i] = i;

        Arrays.sort(index, (a, b) -> position[b] - position[a]);

        int res = 0;
        double prev = 0.0;
        for(int i : index) {
            double time = (target - position[i]) / (double) speed[i];

            if(Double.compare(time, prev) > 0) {
                res++;
                prev = time;
            }
        }
        return res;
    }
}
