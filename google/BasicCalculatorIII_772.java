package leetcode.google;

import java.util.*;

public class BasicCalculatorIII_772 {
    public static void main(String[] args) {
        System.out.println(new BasicCalculatorIII_772().calculate("1 + 1"));
    }

    private int index;
    private String str;
    public int calculate(String s) {
        index = 0;
        str = s + "$";
        return helper();
    }

    private int helper() {
        Stack<Integer> stack = new Stack();
        char sign = '+';
        int num = 0;
        while(index < str.length()) {
            char curt = str.charAt(index++);
            if(curt == ' ') continue;
            if(curt == '(') num = helper();
            if(Character.isDigit(curt)) num = num * 10 + curt - '0';
            if(!Character.isDigit(curt) || index == str.length()) {
                if(sign == '+') stack.push(num);
                else if(sign == '-') stack.push(-num);
                else if(sign == '*') stack.push(stack.pop() * num);
                else if(sign == '/') stack.push(stack.pop() / num);

                if(curt == ')') break;
                num = 0;
                sign = curt;
            }
        }
        int sum = 0;
        while(!stack.isEmpty()) sum += stack.pop();

        return sum;
    }
}
