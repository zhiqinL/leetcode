package leetcode.google;

import java.util.*;

public class StrobogrammaticNumberIII_248 {
    public static void main(String[] args) {
        System.out.println(new StrobogrammaticNumberIII_248().strobogrammaticInRange("50", "100"));
    }

    private String[] digits = new String[] {"", "0", "1", "8"};
    private String[][] pairs = new String[][] {{"1", "1"}, {"6", "9"}, {"8", "8"}, {"9", "6"}};
    private int res = 0;

    public int strobogrammaticInRange(String low, String high) {
        for(String digit : digits) {
            if(isTooLarge(low, high, digit)) break;
            helper(digit, low, high);
        }
        return res;
    }

    private void helper(String value, String low, String high) {
        for(String[] pair : pairs) {
            String next = pair[0] + value + pair[1];
            if(isTooLarge(low, high, next)) return;
            helper(next, low, high);
        }
        value = "0" + value + "0";
        helper(value, low, high);
    }

    private boolean isTooLarge(String low, String high, String value) {
        if(value.length() > high.length() || value.length() == high.length() && value.compareTo(high) > 0) return true;
        if(value.length() > low.length() || value.length() == low.length() && value.compareTo(low) >= 0) res++;
        return false;
    }
}
