package leetcode.google.high_frequency;

import java.util.*;

public class EvaluateDivision_399 {
    public static void main(String[] args) {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "c"}};

        EvaluateDivision_399 test = new EvaluateDivision_399();
        for(double value : test.calcEquation_1(equations, values, queries))
            System.out.println(value);
    }

    private int[] parents;
    private double[] records;

    public double[] calcEquation_1(String[][] equations, double[] values, String[][] queries) {
        Map<String, Integer> index = new HashMap();

        int length = 0;
        for(String[] equation : equations) {
            if(!index.containsKey(equation[0]))
                index.put(equation[0], length++);

            if(!index.containsKey(equation[1]))
                index.put(equation[1], length++);
        }

        parents = new int[length];
        records = new double[length];

        for(int i = 0; i < length; i++) {
            parents[i] = i;
            records[i] = 1;
        }

        for(int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            union(index.get(equation[0]), index.get(equation[1]), values[i]);
        }

        double[] res = new double[queries.length];
        for(int i = 0; i < res.length; i++) {
            String[] query = queries[i];
            if(!index.containsKey(query[0]) || !index.containsKey(query[1])) res[i] = -1;
            res[i] = getValue(index.get(query[0]), index.get(query[1]));
        }
        return res;
    }

    private int find(int val) {
        if(parents[val] == val) return val;

        int parent = find(parents[val]);
        records[val] *= records[parent];
        parents[val] = parent;
        return parent;
    }

    private void union(int a, int b, double value) {
        int a_parent = find(a), b_parent = find(b);
        if(a_parent == b_parent) return;

        parents[b_parent] = parents[a_parent];
        records[b_parent] = records[a] * value / records[b];
    }

    private double getValue(int a, int b) {
        if(find(a) != find(b)) return -1;

        return records[b] / records[a];
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap();

        for(int index = 0; index < equations.length; index++) {
            String[] equation = equations[index];

            String left = equation[0], right = equation[1];
            if(!map.containsKey(left)) map.put(left, new HashMap());
            map.get(left).put(right, values[index]);

            if(!map.containsKey(right)) map.put(right, new HashMap());
            map.get(right).put(left, 1 / values[index]);
        }

        double[] res = new double[queries.length];

        for(int i = 0; i < queries.length; i++)
            res[i] = calculate(map, queries[i]);

        return res;
    }

    private double calculate(Map<String, Map<String, Double>> map, String[] query) {
        String left = query[0], right = query[1];

        if(!map.containsKey(left) || !map.containsKey(right)) return -1.0;
        if(left.equals(right)) return 1.0;

        Queue<String> queue = new LinkedList();
        Queue<Double> result = new LinkedList();
        Set<String> visited = new HashSet();

        queue.offer(left);
        result.offer(1.0);
        visited.add(left);

        while(!queue.isEmpty()) {
            String label = queue.poll();
            double value = result.poll();
            if(label.equals(right)) return value;

            Map<String, Double> next = map.get(label);
            for(String next_label : next.keySet()) {
                if(visited.add(next_label)) {
                    double next_val = next.get(next_label) * value;
                    queue.offer(next_label);
                    result.offer(next_val);
                }
            }
        }
        return -1.0;
    }
}
