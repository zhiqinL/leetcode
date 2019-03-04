package leetcode.google;

public class Sqrtx_69 {
    public int mySqrt(int x) {
        long target = (long) x;
        long num = 1;
        while((num + 1) * (num + 1) < target) num++;
        return (int) num;
    }
}
