package leetcode.google;

import java.util.*;

public class Game24_679 {

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList();
        for(int num : nums) list.add((double) num);

        return helper(list);
    }

    private boolean helper(List<Double> nums) {
        if(nums.size() == 1) return Double.compare(nums.get(0), 24) == 0;

        for(int i = 0; i < nums.size(); i++) {
            for(int j = 0; j < nums.size(); j++) {
                if(i == j) continue;

                List<Double> temp = new ArrayList();
                for(int x = 0; x < nums.size(); x++) {
                    if(x == i || x == j) continue;

                    temp.add(nums.get(x));
                }

                for(int k = 0; k < 4; k++) {
                    if(k < 2 && j > i) continue;
                    if(k == 0) temp.add(nums.get(i) + nums.get(j));
                    else if(k == 1) temp.add(nums.get(i) * nums.get(j));
                    else if(k == 2) temp.add(nums.get(i) - nums.get(j));
                    else {
                        if(nums.get(j) > 0) temp.add(nums.get(i) / nums.get(j));
                    }
                    if(helper(temp)) return true;
                    temp.remove(temp.size() - 1);
                }
            }
        }
        return false;
    }
}
