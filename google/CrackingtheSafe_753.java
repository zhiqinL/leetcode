package leetcode.google;

import java.util.*;

public class CrackingtheSafe_753 {
    public static void main(String[] args) {

    }

    public String crackSafe(int n, int k) {
        int totalSize = (int) Math.pow(k, n);
        Set<String> visited = new HashSet();
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < n; i++)
            res.append('0');
        visited.add(res.toString());

        helper(res, n, k, visited, totalSize);

        return res.toString();
    }

    private boolean helper(StringBuilder res, int n, int k, Set<String> visited, int totalSize) {
        if(visited.size() == totalSize) return true;

        StringBuilder curt = new StringBuilder(res.substring(res.length() - n + 1));

        for(char ch = '0'; ch < '0' + k; ch++) {
            String password = curt.append(ch).toString();
            if(visited.add(password)) {
                res.append(ch);
                if(helper(res, n, k, visited, totalSize)) return true;
                res.deleteCharAt(res.length() - 1);
                visited.remove(password);
            }
            curt.deleteCharAt(curt.length() - 1);
        }
        return false;
    }
}
