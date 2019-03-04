package leetcode.google;

import java.util.*;
import java.util.regex.*;

public class ParseLispExpression_736 {
    public static void main(String[] args) {
        String test = "(let x 2 (mult x 5))";
        System.out.println(new ParseLispExpression_736().evaluate(test));
    }

//    private int index;
//    private List<String> tokens;
//    public int evaluate(String expression) {
//        tokens = getTokens(expression);
//        index = 1;
//
//        return execute(new HashMap());
//    }
//
//    private int execute(Map<String, Integer> global) {
//        Map<String, Integer> local = new HashMap(global);
//        String command = tokens.get(index++);
//
//        int res = 0;
//        System.out.println(command);
//        if(command.equals("let")) {
//            res = assignCommand(local);
//        } else if(command.equals("add")) {
//            res = getValue(local) + getValue(local);
//        } else if(command.equals("mult")) {
//            res = getValue(local) * getValue(local);
//        }
//
//        index++;
//        return res;
//    }
//
//    private int assignCommand(Map<String, Integer> map) {
//        while(index < tokens.size()) {
//            String var = tokens.get(index++);
//
//            if(var.equals("(")) return execute(map);
//            if(tokens.get(index).equals(")"))
//                return map.containsKey(var) ? map.get(var) : Integer.valueOf(var);
//
//            map.put(var, getValue(map));
//        }
//
//        return -1;
//    }
//
//    private int getValue(Map<String, Integer> map) {
//        String var = tokens.get(index++);
//
//        if(var.equals("(")) return execute(map);
//
//        return map.containsKey(var) ? map.get(var) : Integer.valueOf(var);
//    }
//
//    private List<String> getTokens(String expression) {
//        Matcher matcher = Pattern.compile("\\(|-?\\w+|\\)").matcher(expression);
//
//        List<String> tokens = new ArrayList();
//        while(matcher.find())
//            tokens.add(matcher.group());
//
//        return tokens;
//    }

    private int index;
    private String str;
    public int evaluate(String expression) {
        index = 0;
        str = expression;
        return calculate(new HashMap());
    }

    private int calculate(Map<String, Integer> vars) {
        if(isDigit()) return Integer.valueOf(parse());
        else if(isVar()) return vars.get(parse());

        left();

        String operation = parse(); space();

        int res = 0;
        if(operation.equals("add")) {
            res = calculate(vars); space();
            res += calculate(vars);

        } else if(operation.equals("mult")) {
            res = calculate(vars); space();
            res *= calculate(vars);

        } else if(operation.equals("let")) {
            Map<String, Integer> temp = new HashMap(vars);

            while(str.charAt(index) != ')') {
                if(!isVar()) res = calculate(temp);
                else {
                    String var = parse();
                    if(str.charAt(index) == ' ') {
                        space();
                        res = calculate(temp); space();
                        temp.put(var, res);
                    } else
                        res = temp.get(var);
                }
            }

        }

        right();

        return res;
    }

    private boolean isDigit() {
        char curt = str.charAt(index);
        return Character.isDigit(curt) || curt == '+' || curt == '-';
    }

    private boolean isVar() {
        char curt = str.charAt(index);
        return Character.isLetter(curt);
    }

    private String parse() {
        int end = index;
        while(end < str.length() && str.charAt(end) != ' ' && str.charAt(end) != ')')
            end++;

        String res = str.substring(index, end);
        index = end;
        return res;
    }

    private void space() {
        char curt = str.charAt(index);
        if(curt == ' ') index++;
    }

    private void left() {
        char curt = str.charAt(index);
        if(curt == '(') index++;
    }

    private void right() {
        char curt = str.charAt(index);
        if(curt == ')') index++;
    }
}
