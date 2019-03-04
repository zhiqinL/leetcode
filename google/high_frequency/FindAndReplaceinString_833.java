package leetcode.google.high_frequency;

import java.util.Arrays;

public class FindAndReplaceinString_833 {
    public static void main(String[] args) {
        String S = "abcd";
        int[] indexes = new int[] {0, 2};
        String[] sources = new String[] {"ab","ec"};
        String[] targets = new String[] {"eee", "ffff"};
        System.out.println(new FindAndReplaceinString_833().findReplaceString(S, indexes, sources, targets));
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
//        StringBuilder res = new StringBuilder();
//
//        Integer[] hash = new Integer[indexes.length];
//        for(int i = 0; i < hash.length; i++) hash[i] = i;
//        Arrays.sort(hash, (a, b) -> indexes[a] - indexes[b]);
//
//        int prev = 0;
//        for(int i : hash) {
//            String source = sources[i], target = targets[i];
//            int index = indexes[i], len = source.length();
//
//            String match = S.substring(index, index + len);
//            if(!source.equals(match)) continue;
//
//            res.append(S.substring(prev, index)).append(target);
//            prev = index + len;
//        }
//
//        res.append(S.substring(prev));
//        return res.toString();

        int len = S.length();
        int[] matches = new int[len];
        Arrays.fill(matches, - 1);

        for(int i = 0; i < indexes.length; i++) {
            int index = indexes[i];
            if(S.substring(index, index + sources[i].length()).equals(sources[i]))
                matches[index] = i;
        }

        int index = 0;
        StringBuilder res = new StringBuilder();
        while(index < len) {
            if(matches[index] >= 0) {
                res.append(targets[matches[index]]);
                index += sources[matches[index]].length();
            } else res.append(S.charAt(index++));
        }

        return res.toString();
    }
}
