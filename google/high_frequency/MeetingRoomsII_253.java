package leetcode.google.high_frequency;

import java.util.*;

public class MeetingRoomsII_253 {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) return 0;

        List<TimeSlot> list = new ArrayList();
        for(Interval interval : intervals) {
            list.add(new TimeSlot(interval.start, 0));
            list.add(new TimeSlot(interval.end, 1));
        }

        Collections.sort(list, (a, b) -> a.time == b.time ? b.type - a.type : a.time - b.time);

        int res = 0, count = 0;
        for(TimeSlot curt : list) {
            if(curt.type == 0) count++;
            else if(curt.type == 1) count--;

            res = Math.max(res, count);
        }

        return res;
    }

    class TimeSlot {
        int time, type;
        TimeSlot(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
