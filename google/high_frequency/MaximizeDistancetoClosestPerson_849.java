package leetcode.google.high_frequency;

public class MaximizeDistancetoClosestPerson_849 {
    public static void main(String[] args) {
        int[] test = new int[] {1,0,0,0,1,0,1};
        System.out.println(new MaximizeDistancetoClosestPerson_849().maxDistToClosest(test));
    }

    public int maxDistToClosest(int[] seats) {

        int start = -1, end = -1, prev = -1, dist = 0, res = 0;

        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 1) {
                end = i;
                if(prev == -1) start = i;
                else {
                    int pos = (prev + i) / 2;
                    if (pos - prev > dist) {
                        res = pos;
                        dist = pos - prev;
                    }
                }
                prev = i;
            }
        }

        if(start > dist) {
            res = 0;
            dist = start;
        }

        if(seats.length - 1 - end > dist)
            res = seats.length - 1;

        System.out.println(start + ", " + end);

        return res;
    }
}
