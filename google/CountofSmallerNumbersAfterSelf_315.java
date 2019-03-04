package leetcode.google;

import java.util.*;

public class CountofSmallerNumbersAfterSelf_315 {
    public static void main(String[] args) {
        int[] test = new int[] {5, 2, 6, 1};
        for(int val : new CountofSmallerNumbersAfterSelf_315().countSmaller_2(test))
            System.out.print(val + ", ");
    }

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        Integer[] res = new Integer[len];
        List<Integer> sorted = new ArrayList();

        for(int i = len - 1; i >= 0; i--) {
            int curt = nums[i];
            int index = helper(sorted, curt);
            res[i] = index;
            sorted.add(index, curt);
        }

        return new ArrayList(Arrays.asList(res));
    }

    private int helper(List<Integer> sorted, int num) {
        int left = 0, right = sorted.size() - 1;
        if(sorted.size() == 0 || sorted.get(0) >= num) return 0;
        if(sorted.get(right) < num) return right + 1;

        while(left < right) {
            int mid = (left + right) / 2;
            if(sorted.get(mid) >= num) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    public List<Integer> countSmaller_2(int[] nums) {
        int len = nums.length;
        res = new Integer[len];
        index = new int[len];

        for(int i = 0; i < len; i++) {
            index[i] = i;
            res[i] = 0;
        }

        mergeSort(nums, 0, len - 1);

        return new ArrayList(Arrays.asList(res));
    }

    private void mergeSort(int[] nums, int left, int right) {
        if(left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, right, mid);
    }

    private Integer[] res;
    private int[] index;
    private void merge(int[] nums, int left, int right, int mid) {
        int lIndex = left, rIndex = mid + 1, tIndex = 0, count = 0;
        int[] temp = new int[right - left + 1];
        while(lIndex <= mid && rIndex <= right) {
            if(nums[index[lIndex]] > nums[index[rIndex]]) {
                temp[tIndex++] = index[rIndex++];
                count++;
            } else {
                temp[tIndex++] = index[lIndex];
                res[index[lIndex++]] += count;
            }
        }

        while(lIndex <= mid) {
            temp[tIndex++] = index[lIndex];
            res[index[lIndex++]] += count;
        }

        while(rIndex <= right)
            temp[tIndex++] = index[rIndex++];

        for(int i = 0; i < temp.length; i++)
            index[left + i] = temp[i];
    }
}
