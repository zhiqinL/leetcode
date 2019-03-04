package leetcode.google;

import java.util.*;

public class KthLargestElementinanArray_215 {
    public static void main(String[] args) {
        int[] test = new int[] {3, 2, 1, 5, 6, 4};
        new KthLargestElementinanArray_215().findKthLargest(test, 2);
    }

    public int findKthLargest(int[] nums, int k) {
        random = new Random();
        int res = quickSelect(nums, 0, nums.length - 1, k);
        for(int num : nums) System.out.print(num + ", ");
        return res;
    }

    private Random random;
    private int quickSelect(int[] nums, int left, int right, int k) {
        if(left >= right) return nums[left];

        int pivotIndex = random.nextInt(right - left + 1) + left;

        int res = partition(nums, left, right, pivotIndex);
        System.out.println(res);
        if(res == k - 1) return nums[res];
        else if(res > k - 1) return quickSelect(nums, left, res - 1, k);
        else return quickSelect(nums, res + 1, right, k);
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);

//        int storeIndex = left;
//
//        for(int i = left; i <= right; i++) {
//            if(nums[i] > pivot) {
//                swap(nums, storeIndex, i);
//                storeIndex++;
//            }
//        }
//
//        swap(nums, storeIndex, right);

        int lIndex = left, rIndex = right - 1;
        while(lIndex < rIndex) {
            if(nums[lIndex] <= pivot) {
                swap(nums, lIndex, rIndex);
                rIndex--;
            } else lIndex++;
        }

        if(nums[lIndex] > pivot) lIndex++;

        swap(nums, lIndex, right);

        return lIndex;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
