package leetcode.google;

public class MinimumWindowSubstring_76 {

    public String minWindow(String s, String t) {

        int[] sNum = new int[256];
        int[] tNum = new int[256];

        for(char ch : t.toCharArray())
            tNum[ch]++;

        int left = 0, len = s.length();
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            char curt = s.charAt(i);
            sNum[curt]++;

            while(left < i && sNum[s.charAt(left)] > tNum[s.charAt(left)])
                sNum[s.charAt(left++)]--;

            if(containsAll(sNum, tNum) && i - left + 1 < len) {
                len = i - left + 1;
                res = s.substring(left, i + 1);
            }
        }

        return res;
    }

    private boolean containsAll(int[] sNum, int[] tNum) {
        for(int i = 0; i < tNum.length; i++) {
            if(tNum[i] != 0 && tNum[i] > sNum[i]) return false;
        }

        return true;
    }
}
