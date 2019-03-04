package leetcode.google;

import java.util.*;

public class MinimumAreaRectangle_939 {
    public int minAreaRect(int[][] points) {
//        Map<Integer, List<Integer>> rows = new TreeMap();
//        for(int[] point : points) {
//            rows.computeIfAbsent(point[0], f -> new ArrayList()).add(point[1]);
//        }
//
//        int res = Integer.MAX_VALUE;
//        Map<String, Integer> map = new HashMap();
//        for(int row : rows.keySet()) {
//            List<Integer> cols = rows.get(row);
//
//            for(int i = 0; i < cols.size(); i++) {
//                int col1 = cols.get(i);
//
//                for(int j = i + 1; j < cols.size(); j++) {
//                    int col2 = cols.get(j);
//                    String curt = Math.min(col1, col2) + "," + Math.max(col1, col2);
//
//                    if(map.containsKey(curt)) {
//                        int height = row - map.get(curt);
//                        int width = Math.max(col1, col2) - Math.min(col1, col2);
//                        res = Math.min(res, width * height);
//                    }
//
//                    map.put(curt, row);
//                }
//            }
//        }
//        return res == Integer.MAX_VALUE ? 0 : res;

        Set<String> hash = new HashSet();
        for(int[] point : points)
            hash.add(point[0] + "," + point[1]);

        int len = points.length, res = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++) {
            int[] p1 = points[i];

            for(int j = i + 1; j < len; j++) {
                int[] p2 = points[j];

                if(p1[0] != p2[0] && p1[1] != p2[1]) {
                    String temp1 = p1[0] + "," + p2[1];
                    String temp2 = p2[0] + "," + p1[1];

                    if(hash.contains(temp1) && hash.contains(temp2)) {
                        res = Math.min(res, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                    }
                }
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
