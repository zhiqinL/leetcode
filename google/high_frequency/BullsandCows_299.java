package leetcode.google.high_frequency;

public class BullsandCows_299 {
    public String getHint(String secret, String guess) {
        int[] s_count = new int[10];
        int[] g_count = new int[10];
        int b_count = 0, c_count = 0;

        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) b_count++;
            else {
                s_count[secret.charAt(i) - '0']++;
                g_count[guess.charAt(i) - '0']++;
            }
        }

        for(int i = 0; i < 10; i++)
            c_count += Math.min(s_count[i], g_count[i]);

        return b_count + "A" + c_count + "B";
    }
}
