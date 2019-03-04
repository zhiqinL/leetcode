package leetcode.uber;

import java.util.*;

public class ExclusiveTimeofFunctions_636 {
    public static void main(String[] args) {
        String[] test = new String[] {"0:start:0"," 0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"};
        List<String> logs = new ArrayList(Arrays.asList(test));
        for(int val : new ExclusiveTimeofFunctions_636().exclusiveTime(2, logs))
            System.out.print(val + ", ");
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        if(logs.isEmpty()) return res;

        Stack<Integer> stack = new Stack();
        String[] first = logs.get(0).split(":");
        stack.push(Integer.valueOf(first[0]));
        int prev = Integer.valueOf(first[2]), index = 1;

        while(index < logs.size()) {
            String[] curt = logs.get(index++).split(":");

            if(curt[1].equals("start")) {
                if(!stack.isEmpty())
                    res[stack.peek()] += Integer.valueOf(curt[2]) - prev;
                stack.push(Integer.valueOf(curt[0]));
                prev = Integer.valueOf(curt[2]);

            } else {
                res[stack.peek()] += Integer.valueOf(curt[2]) - prev + 1;
                stack.pop();
                prev = Integer.valueOf(curt[2]) + 1;
            }
        }

        return res;
    }
}
