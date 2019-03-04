package leetcode.google;

import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals_56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList();
        if(intervals.size() == 0) return res;

        Collections.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);

        Interval prev = null;
        for(Interval curt : intervals) {
            if(prev == null) {
                prev = curt;
                continue;
            }

            if(prev.end < curt.start) {
                res.add(prev);
                prev = curt;
            } else
                prev.end = Math.max(prev.end, curt.end);
        }
        res.add(prev);

        return res;
    }
}
