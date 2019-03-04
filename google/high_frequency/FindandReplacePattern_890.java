package leetcode.google.high_frequency;

import java.util.*;

public class FindandReplacePattern_890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList();
        if(words.length == 0) return res;

        for(String word : words) {
            if(isvalid(word, pattern))
                res.add(word);
        }

        return res;
    }

    private boolean isvalid(String word, String pattern) {
        if(word.length() != pattern.length()) return false;

        Map<Character, Character> map = new HashMap();
        Set<Character> seen = new HashSet();
        for(int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);

            if(!map.containsKey(p)) {
                if(!seen.add(w)) return false;
                map.put(p, w);
            } else {
                if(map.get(p) != w) return false;
            }
        }

        return true;
    }
}
