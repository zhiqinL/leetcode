package leetcode;

import java.util.Arrays;
import java.util.*;

public class Heaters_475 {
    public static void main(String[] args) {
        int[] houses = new int[] {1, 2, 3, 4};
        int[] heaters = new int[] {1, 4};
        System.out.println(new Heaters_475().findRadius(houses, heaters));
    }

    public int findRadius(int[] houses, int[] heaters) {
//        Arrays.sort(houses); Arrays.sort(heaters);
//
//        int hoIndex = 0, heIndex = 0;
//        int res = 0;
//        while(hoIndex < houses.length && heIndex < heaters.length) {
//            if(houses[hoIndex] < heaters[heIndex]) {
//                res = Math.max(res, heaters[heIndex] - houses[hoIndex]);
//                hoIndex++;
//            } else if(houses[hoIndex] > heaters[heIndex]) {
//                if(heIndex + 1 >= heaters.length) {
//                    res = Math.max(res, houses[hoIndex] - heaters[heIndex]);
//                    hoIndex++;
//                } else if (heaters[heIndex + 1] < houses[hoIndex]) {
//                    heIndex++;
//                } else {
//                    res = Math.max(res, Math.max(houses[hoIndex] - heaters[heIndex], heaters[heIndex + 1] - houses[hoIndex]));
//                    hoIndex++;
//                }
//            } else
//                hoIndex++;
//        }
//        return res;

        TreeSet<Integer> set = new TreeSet();

        for(int heater : heaters) set.add(heater);

        int res = 0;
        for(int house : houses) {
            if(set.contains(house)) continue;
            Integer lower = set.lower(house);
            Integer higher = set.higher(house);

            if(lower == null && higher == null) continue;

            if(lower == null)
                res = Math.max(res, higher - house);
            else if(higher == null)
                res = Math.max(res, house - lower);
            else
                res = Math.max(res, Math.min(higher - house, house - lower));
        }

        return res;
    }

    public int findRadius_2(int[] houses, int[] heaters) {
        Arrays.sort(houses); Arrays.sort(heaters);

        int res = 0;
        int hoIndex = 0, heIndex = 0;
        while(hoIndex < houses.length && heIndex < heaters.length) {
            if(houses[hoIndex] <= heaters[heIndex]) {
                res = Math.max(res, heaters[heIndex] - houses[hoIndex]);
                hoIndex++;
            } else {
                if(heIndex + 1 >= heaters.length) {
                    res = Math.max(res, houses[hoIndex] - heaters[heIndex]);
                    hoIndex++;
                } else if(heaters[heIndex + 1] >= houses[hoIndex]) {
                    res = Math.max(res, Math.max(heaters[heIndex + 1] - houses[hoIndex], houses[hoIndex] - heaters[heIndex]));
                    hoIndex++;
                } else heIndex++;
            }
        }

        return res;
    }
}
