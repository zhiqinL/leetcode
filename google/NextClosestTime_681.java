package leetcode.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NextClosestTime_681 {
    public static void main(String[] args) {
        NextClosestTime_681 test = new NextClosestTime_681();
        System.out.println(test.nextClosestTime("19:34"));
    }

    public String nextClosestTime(String time) {
        Set<Integer> hash = new HashSet();
        for(char ch : time.toCharArray()) {
            if(Character.isDigit(ch))
                hash.add(ch - '0');
        }

        if(hash.size() == 1) return time;

        List<Integer> digits = new ArrayList(hash);
        int target = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));

        dfs(digits, "", 0, target);

        return res;
    }

    int diff = Integer.MAX_VALUE;
    String res = "";
    public void dfs(List<Integer> digits, String curt, int pos, int target) {
        if(pos == 4) {
            int curtMinute = Integer.parseInt(curt.substring(0, 2)) * 60 + Integer.parseInt(curt.substring(2, 4));
            if(curtMinute == target) return;
            int curtDiff = curtMinute > target ? curtMinute - target : curtMinute - target + 1440;
            if(curtDiff < diff) {
                diff = curtDiff;
                res = curt.substring(0, 2) + ":" + curt.substring(2, 4);
            }
            return;
        }

        for(int val : digits) {
            if(pos == 0 && val > 2) continue;
            if(pos == 1 && Integer.valueOf(curt) * 10 + val > 23) continue;
            if(pos == 2 && val > 5) continue;
            if(pos == 3 && Integer.valueOf(curt.substring(2)) * 10 + val >= 60) continue;

            dfs(digits, curt + val, pos + 1, target);
        }
    }

}
