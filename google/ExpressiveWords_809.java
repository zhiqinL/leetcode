package leetcode.google;

public class ExpressiveWords_809 {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for(String word : words) {
            if (match(S, word)) count++;
        }

        return count;
    }

    private boolean match(String S, String word) {
        int sIndex = 0, wIndex = 0;
        while(sIndex < S.length() && wIndex < word.length()) {
            if(S.charAt(sIndex++) != word.charAt(wIndex++)) return false;

            int sCount = 0;
            while(sIndex < S.length() && S.charAt(sIndex) == S.charAt(sIndex - 1)) {
                sCount++;
                sIndex++;
            }

            int wCount = 0;
            while(wIndex < word.length() && word.charAt(wIndex) == word.charAt(wIndex - 1)) {
                wCount++;
                wIndex++;
            }

            if(sCount != wCount && (sCount < 3 || sCount < wCount)) return false;
        }
        return sIndex == S.length() && wIndex == word.length();
    }
}
