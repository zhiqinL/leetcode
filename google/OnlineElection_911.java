package leetcode.google;

import java.util.*;

public class OnlineElection_911 {

    private TreeMap<Integer, Integer> map;
    public OnlineElection_911(int[] persons, int[] times) {
        map = new TreeMap();
        int[] counts = new int[persons.length + 1];

        int leader = -1, count = 0;
        for(int i = 0; i < persons.length; i++) {
            int person = persons[i];
            int time = times[i];

            counts[person]++;

            if(counts[person] >= count) {
                leader = person;
                count = counts[person];
            }

            map.put(time, leader);
        }
    }

    public int q(int t) {
        Integer lower = map.floorKey(t);
        if(lower == null) return -1;

        return map.get(lower);
    }
}
