package leetcode.google;

public class lengthOfLongestSubstringTwoDistinct_159 {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() == 0) return 0;

        int[] hash = new int[256];
        int res = 0, count = 0;
        int left = 0, right = 0;

        char[] chs = s.toCharArray();
        while(right < chs.length) {
            if(count <= 2) {
                if(hash[chs[right]] == 0) count++;
                if(count <= 2) res = Math.max(res, right - left + 1);
                hash[chs[right++]]++;
            } else {
                if(hash[chs[left]] == 1) count--;
                hash[chs[left++]]--;
            }
        }
        return res;
    }
}
