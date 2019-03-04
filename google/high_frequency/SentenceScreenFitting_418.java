package leetcode.google.high_frequency;

public class SentenceScreenFitting_418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if(sentence.length == 0 || rows == 0 || cols == 0) return 0;

        int res = 0, index = 0;
        for(int r = 0; r < rows; r++) {
            int remain = cols;
            while(remain > 0) {
                if(remain < sentence[index].length()) break;

                remain -= (sentence[index].length() + 1);
                index++;

                if(index >= sentence.length) {
                    index = 0;
                    res++;
                }
            }
        }

        return res;
    }
}
