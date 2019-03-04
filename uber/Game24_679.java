package leetcode.uber;

import java.util.*;

public class Game24_679 {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList();
        for(int num : nums) list.add((double) num);

        return helper(list);
    }

    private boolean helper(List<Double> nums) {
        if(nums.isEmpty()) return false;
        if(nums.size() == 1) return Math.abs(nums.get(0) - 24) < 1e-6;

        for(int i = 0; i < nums.size(); i++) {
            for(int j = 0; j < nums.size(); j++) {
                if(i == j) continue;

                List<Double> temp = new ArrayList();
                for(int n = 0; n < nums.size(); n++) {
                    if(n == i || n == j) continue;
                    temp.add(nums.get(n));
                }

                for(int k = 0; k < 4; k++) {
                    if(k < 2 && i > j) continue;
                    if(k == 0) temp.add(nums.get(i) + nums.get(j));
                    else if(k == 1) temp.add(nums.get(i) * nums.get(j));
                    else if(k == 2) temp.add(nums.get(i) - nums.get(j));
                    else {
                        if(nums.get(j) == 0) continue;
                        temp.add(nums.get(i) / nums.get(j));
                    }
                    if(helper(temp)) return true;
                    temp.remove(temp.size() - 1);
                }
            }
        }
        return false;
    }
}
