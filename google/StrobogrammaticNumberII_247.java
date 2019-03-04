package leetcode.google;

import java.util.*;

public class StrobogrammaticNumberII_247 {
    public static void main(String[] args) {

    }

    private String[] digits = new String[] {"0", "1", "8"};
    private String[][] pairs = new String[][] {{"1", "1"}, {"6", "9"}, {"8", "8"}, {"9", "6"}};

    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList();
        if(n == 0) return res;

        if(n % 2 != 0) {
            for(String digit : digits)
                helper(digit, n, res);
        } else
            helper("", n, res);

        return res;
    }

    private void helper(String value, int n, List<String> res) {
        if(value.length() == n) {
            if(n == 1 || !value.startsWith("0"))
                res.add(value);
            return;
        }

        for(String[] pair : pairs) {
            String next = pair[0] + value + pair[1];
            helper(next, n, res);
        }
        value = "0" + value + "0";
        helper(value, n, res);
    }
}
