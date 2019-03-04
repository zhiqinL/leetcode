package leetcode.google;

import java.util.*;

public class LongestWordinDictionarythroughDeleting_524 {

    public String findLongestWord(String s, List<String> d) {
        String res = "";
        int len = 0;

        for(String curt : d) {
            if(!isValid(s, curt)) continue;

            if(curt.length() > len) {
                res = curt;
                len = curt.length();
            } else if(curt.length() == len && curt.compareTo(res) < 0) res = curt;
        }

        return res;
    }

    private boolean isValid(String s, String d) {
        int sIndex = 0, dIndex = 0;

        while(sIndex < s.length() && dIndex < d.length()) {
            while(sIndex < s.length() && s.charAt(sIndex) != d.charAt(dIndex)) sIndex++;

            if(sIndex >= s.length()) break;

            sIndex++; dIndex++;
        }
        return dIndex == d.length();
    }
}
