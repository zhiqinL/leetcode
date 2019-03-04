package leetcode.google;

public class LongestSubstringwithAtMostKDistinctCharacters_340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int[] count = new int[26];
        int left = 0, res = 0, num = 0;
        for(int i = 0; i < s.length(); i++) {
            char curt = s.charAt(i);

            if(count[curt - 'a']++ == 0) num++;

            while(num > k) {
                char temp = s.charAt(left++);
                if(--count[temp - 'a'] == 0) num--;
            }

            if(num == k)
                res = Math.max(res, i - left + 1);
        }

        return res;
    }
}
