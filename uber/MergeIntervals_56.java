package leetcode.uber;

import java.util.*;

public class MergeIntervals_56 {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList();
        if(intervals.isEmpty()) return res;

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        Interval prev = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
            Interval curt = intervals.get(i);

            if(curt.start > prev.end) {
                res.add(prev);
                prev = curt;
            } else
                prev.end = Math.max(prev.end, curt.end);
        }
        res.add(prev);

        return res;
    }

    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
