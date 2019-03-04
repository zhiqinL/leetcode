package leetcode.google;

import java.util.*;

public class TextJustification_68 {
    public static void main(String[] args) {
        String[] test = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
        new TextJustification_68().fullJustify(test, 16);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList();
        if(words.length == 0 || maxWidth <= 0) return res;

        int start = 0, end = 0;
        while(end < words.length) {
            int remain = maxWidth, wordLen = 0;
            while(end < words.length && remain >= words[end].length()) {
                wordLen += words[end].length();
                remain -= (words[end++].length() + 1);
            }

            res.add(generateLine(words, start, end, wordLen, maxWidth, end == words.length));

            start = end;
        }

        return res;
    }

    private String generateLine(String[] words, int left, int right, int wordLen, int maxWidth, boolean isLastLine) {
        StringBuilder res = new StringBuilder();
        if(isLastLine || right - left == 1) {
            for(int i = left; i < right; i++) {
                if(i > left) res.append(' ');
                res.append(words[i]);
            }

            while(res.length() < maxWidth)
                res.append(' ');
        } else {
            int spaceNum = (maxWidth - wordLen) / (right - left - 1);
            int extraSpace = (maxWidth - wordLen) % (right - left - 1);

            for(int i = left; i < right; i++) {
                res.append(words[i]);

                if(i < right - 1) {
                    for(int n = 0; n < spaceNum; n++)
                        res.append(' ');

                    if(extraSpace > 0) {
                        res.append(' ');
                        extraSpace--;
                    }
                }
            }
        }

        return res.toString();
    }
}
