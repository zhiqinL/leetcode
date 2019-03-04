package leetcode.google;

import java.util.*;

public class MyCalendarI_729 {
//    private TreeMap<Integer, Integer> events;
//
//    public MyCalendarI_729() {
//        events = new TreeMap();
//    }
//
//    public boolean book(int start, int end) {
//        Integer lower = events.lowerKey(start);
//        Integer higher = events.higherKey(start);
//
//        if((lower == null || events.get(lower) <= start) && (higher == null || end <= higher)) {
//            events.put(start, end);
//            return true;
//        }
//
//        return false;
//    }

    private TreeSet<Event> events;
    public MyCalendarI_729() {
        events = new TreeSet<Event>((a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
    }

    public boolean book(int start, int end) {
        Event curt = new Event(start, end);
        Event lower = events.floor(curt);
        Event higher = events.ceiling(curt);

        if(lower != null && lower.end > curt.start) return false;
        if(higher != null && higher.start < curt.end) return false;

        events.add(curt);

        return true;
    }

    class Event {
        int start, end;

        Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
