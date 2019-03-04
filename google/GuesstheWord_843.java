package leetcode.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Master {
    public int guess(String word) { return -1; }
}

public class GuesstheWord_843 {
    public static void main(String[] args) {

    }

    public void findSecretWord(String[] wordlist, Master master) {
        Random random = new Random();
        List<String> possible = new ArrayList(Arrays.asList(wordlist));
        while(possible.size() != 0) {
            int index = random.nextInt(possible.size());

            String word = possible.get(index);
            int match = master.guess(word);

            if(match == 6) return;

            List<String> temp = new ArrayList();
            for(int i = 0; i < possible.size(); i++) {
                if(i == index) continue;

                String next = possible.get(i);
                if(match == getMatch(word, next))
                    temp.add(next);
            }
            possible = temp;
        }
    }

    private int getMatch(String word1, String word2) {
        int match = 0;
        for(int index = 0; index < 6; index++) {
            if(word1.charAt(index) == word2.charAt(index)) match++;
        }
        return match;
    }

}
