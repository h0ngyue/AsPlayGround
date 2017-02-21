package com.github.h0ngyue.leetcode;

/**
 * Created by shuailongcheng on 21/02/2017.
 */

public class _31_NextPermutation {

    public static void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        int firstLess = nums.length - 2;
        while (firstLess >= 0 && nums[firstLess] >= nums[firstLess + 1]) {
            firstLess--;
        }
        if (firstLess < 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int subIndex = firstLess + 1;
            while (subIndex < nums.length && nums[subIndex] > nums[firstLess]) {
                subIndex++;
            }
            subIndex--;
            int tmp = nums[firstLess];
            nums[firstLess] = nums[subIndex];
            nums[subIndex] = tmp;
            reverse(nums, firstLess + 1, nums.length - 1);
        }
    }

    private static void reverse(int[] nums, int start, int end) {
        for (int i = 0; i <= (end - start) / 2; i++) {
            int tmp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = tmp;
        }
        return;
    }

    public static void test() {
        int[] nums = {5, 1, 1};
        nextPermutation(nums);
        System.out.println();
    }
}
