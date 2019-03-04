package leetcode.google;

import java.util.*;

public class DesignSearchAutocompleteSystem_642 {

    private Trie root;
    private StringBuilder input;
    public DesignSearchAutocompleteSystem_642(String[] sentences, int[] times) {
        root = new Trie();
        for(int i = 0; i < sentences.length; i++)
            insert(sentences[i], times[i]);

        input = new StringBuilder();
    }


    public List<String> input(char c) {
        List<String> res = new ArrayList();
        if(c == '#') {
            insert(input.toString(), 1);
            input.setLength(0);
        } else {
            List<Pair> temp = lookup(input.toString());
            Collections.sort(temp, (a, b) -> b.times == a.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);

            for(int i = 0; i < Math.min(3, temp.size()); i++)
                res.add(temp.get(i).sentence);
        }
        return res;
    }

    private void insert(String sentence, int times) {
        Trie node = root;
        for(char ch : sentence.toCharArray()) {
            Trie[] next = node.nodes;
            int index = getIndex(ch);

            if(next[index] == null)
                next[index] = new Trie();

            node = next[index];
        }
        node.sentence = sentence;
        node.times += times;
    }

    private List<Pair> lookup(String prefix) {
        Trie node = root;
        for(char ch : prefix.toCharArray()) {
            Trie[] next = node.nodes;
            int index = getIndex(ch);

            if(next[index] == null) return new ArrayList();

            node = next[index];
        }

        List<Pair> list = new ArrayList();
        traverse(node, list);

        return list;
    }

    private void traverse(Trie node, List<Pair> list) {
        if(node.times > 0) list.add(new Pair(node.times, node.sentence));

        for(Trie next : node.nodes) {
            if(next == null) continue;

            traverse(node, list);
        }
    }

    private int getIndex(char value) {
        if(value == ' ') return 26;
        return value - 'a';
    }

    class Trie {
        int times;
        String sentence;
        Trie[] nodes;

        Trie() {
            times = 0;
            sentence = "";
            nodes = new Trie[27];
        }
    }

    class Pair {
        int times;
        String sentence;

        Pair(int times, String sentence) {
            this.times = times;
            this.sentence = sentence;
        }
    }
}
