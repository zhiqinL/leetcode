package leetcode.google;

import java.util.*;

public class OptimalAccountBalancing_465 {
    public static void main(String[] args) {
        int[][] test = new int[][] {{0, 1, 10}, {2, 0, 5}};
        System.out.println(new OptimalAccountBalancing_465().minTransfers_2(test));
    }

//    public int minTransfers_1(int[][] transactions) {
//        Map<Integer, Integer> temp = new HashMap();
//        for(int[] tran : transactions) {
//            temp.put(tran[0], temp.getOrDefault(tran[0], 0) - tran[2]);
//            temp.put(tran[1], temp.getOrDefault(tran[1], 0) + tran[2]);
//        }
//
//        List<Integer> debt = new ArrayList();
//        for(int val : temp.values()) {
//            if (val != 0)
//                debt.add(val);
//        }
//
//        helper_1(debt, 0);
//        return res_1;
//    }
//
//    private int res_1 = Integer.MAX_VALUE;
//    private void helper_1(List<Integer> debt, int count) {
//        if(debt.size() == 0) {
//            res_1 = Math.min(res_1, count);
//            return;
//        }
//
//        if(count > res_1)  return;
//
//        int curt = debt.get(0);
//
//        for(int i = 1; i < debt.size(); i++) {
//            List<Integer> temp = new ArrayList();
//            int sum = curt + debt.get(i);
//
//            if(sum != 0) temp.add(sum);
//
//            for(int k = 1; k < debt.size(); k++) {
//                if(k == i) continue;
//                temp.add(debt.get(k));
//            }
//            helper_1(temp, count + 1);
//        }
//    }

    public int minTransfers_2(int[][] transactions) {
        Map<Integer, Integer> temp = new HashMap();
        for(int[] tran : transactions) {
            temp.put(tran[0], temp.getOrDefault(tran[0], 0) - tran[2]);
            temp.put(tran[1], temp.getOrDefault(tran[1], 0) + tran[2]);
        }

        List<Integer> positive = new ArrayList();
        List<Integer> negetive = new ArrayList();

        for(int val : temp.values()) {
            if(val > 0) positive.add(val);
            else if(val < 0) negetive.add(val);
        }

        helper_2(positive, negetive, 0);

        return res;
    }

    private int res = Integer.MAX_VALUE;
    private void helper_2(List<Integer> positive, List<Integer> negetive, int count) {
        if(positive.size() == 0 && negetive.size() == 0) {
            res = Math.min(res, count);
            return;
        }

        if(count >= res) return;

        int curtPos = positive.get(0);

        for(int i = 0; i < negetive.size(); i++) {
            int curtNeg = negetive.get(i);
            int posVal = Math.max(curtPos + curtNeg, 0);
            int negVal = Math.min(curtPos + curtNeg, 0);

            if(posVal == 0) positive.remove(0);
            else positive.set(0, posVal);

            if(negVal == 0) negetive.remove(i);
            else negetive.set(i, negVal);

            helper_2(positive, negetive, count + 1);

            if(posVal == 0) positive.add(0, curtPos);
            else positive.set(0, curtPos);

            if(negVal == 0) negetive.add(i, curtNeg);
            else negetive.set(i, curtNeg);
        }
    }
}
