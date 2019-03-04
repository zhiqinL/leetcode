package leetcode.uber;

import java.util.*;

public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        if(strs.length == 0) return res;

        Map<String, List<String>> map = new HashMap();
        for(String str : strs) {
            String key = getKey(str);

            if(!map.containsKey(key))
                map.put(key, new ArrayList());

            map.get(key).add(str);
        }

        for(List<String> list : map.values())
            res.add(list);

        return res;
    }

    private String getKey(String str) {
        char[] count = new char[26];
        for(char ch : str.toCharArray())
            count[ch - 'a']++;

        StringBuilder res = new StringBuilder();
        for(char c = 'a'; c <= 'z'; c++) {
            if(count[c - 'a'] == 0) continue;

            res.append(count[c - 'a']).append(c);
        }

        return res.toString();
    }
}
