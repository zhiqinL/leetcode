package leetcode.google.high_frequency;


import java.util.TreeSet;

public class ExamRoom_855 {

    private TreeSet<Integer> hash;
    private int num;

    public ExamRoom_855(int N) {
        hash = new TreeSet();
        num = N;
    }

    public int seat() {
        if(hash.size() == 0) {
            hash.add(0);
            return 0;
        }

        int dist = hash.first(), prev = hash.first(), res = 0;
        for(int curt : hash) {
            int pos = (curt + prev) / 2;
            if(pos - curt > dist) {
                dist = pos - curt;
                res = pos;
            }
            prev = curt;
        }

        if(num - 1 - prev > dist)
            res = num - 1;

        hash.add(res);
        return res;
    }

    public void leave(int p) {
        hash.remove(p);
    }
}
