package leetcode.uber;

import java.util.*;

public class InsertDeleteGetRandom_381 {
    private Map<Integer, Set<Integer>> map;
    private List<Integer> values;
    private Random random;
    public InsertDeleteGetRandom_381() {
        map = new HashMap();
        values = new ArrayList();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = true;
        int index = values.size();

        if(map.containsKey(val)) res = false;
        else map.put(val, new HashSet());

        values.add(val);
        map.get(val).add(index);

        return res;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int lIndex = values.size() - 1;
        int lVal = values.get(lIndex);
        Set<Integer> tIndexes = map.get(val);

        if(val == lVal) {
            tIndexes.remove(lIndex);
            values.remove(lIndex);
        } else {
            int tIndex = tIndexes.iterator().next();
            tIndexes.remove(tIndex);

            values.set(tIndex, lVal);
            values.remove(lIndex);

            Set<Integer> lIndexes = map.get(lVal);
            lIndexes.remove(lIndex);
            lIndexes.add(tIndex);
        }

        if(tIndexes.isEmpty()) map.remove(val);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int index = random.nextInt(values.size());
        return values.get(index);
    }
}
