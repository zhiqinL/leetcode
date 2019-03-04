package leetcode.google.high_frequency;

import java.util.*;
import java.util.stream.Collectors;

public class BusRoutes_815 {
    public static void main(String[] args) {
        int[][] routes = new int[][] {{1, 2, 7}, {3, 6, 7}};
        System.out.println(new BusRoutes_815().numBusesToDestination(routes, 1, 6));
    }

    public int numBusesToDestination(int[][] routes, int S, int T) {
        Map<Bus, Set<Bus>> graph = new HashMap();
        Map<Integer, List<Bus>> stops = new HashMap();
        for(int[] route : routes) {
            Bus bus = new Bus(route);
            graph.put(bus, new HashSet());

            for(int stop : route) {
                if(!stops.containsKey(stop))
                    stops.put(stop, new ArrayList());
                stops.get(stop).add(bus);
            }
        }

        for(Bus curt : graph.keySet()) {
            for(int stop : curt.stations) {
                graph.get(curt).addAll(stops.get(stop));
            }
        }

        Queue<Bus> queue = new LinkedList();
        Set<Bus> hash = new HashSet();
        for(Bus bus : stops.get(S)) {
            queue.offer(bus);
            hash.add(bus);
        }

        int res = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Bus curt = queue.poll();
                if(curt.stations.contains(T)) return res;

                for(Bus next : graph.get(curt)) {
                    if(!hash.add(next)) continue;
                    queue.offer(next);
                }
            }
            res++;
        }
        return -1;
    }
}

class Bus {
    Set<Integer> stations;
    Bus(int[] stops) {
        stations = new HashSet();
        for(int stop : stops)
            stations.add(stop);
    }
}
