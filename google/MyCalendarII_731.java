package leetcode.google;

import java.util.*;

public class MyCalendarII_731 {

    public static void main(String[] args) {
        MyCalendarII_731 test = new MyCalendarII_731();
        test.book(10, 20);
        test.book(50, 60);
        test.book(10, 40);
        test.book(5, 15);
    }

    private TreeMap<Integer, Integer> events;
    public MyCalendarII_731() {
        events = new TreeMap();
    }

    public boolean book(int start, int end) {
        events.put(start, events.getOrDefault(start, 0) + 1);
        events.put(end, events.getOrDefault(end, 0) - 1);

        int count = 0;
        for(int key : events.keySet()) {
            count += events.get(key);
            if(count >= 3) {
                events.put(start, events.get(start) - 1);
                events.put(end, events.get(end) + 1);

                if(events.get(start) == 0) events.remove(start);
                if(events.get(end) == 0) events.remove(end);

                return false;
            }
        }
        return true;
    }
}
