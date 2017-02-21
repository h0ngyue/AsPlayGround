package com.github.h0ngyue.leetcode;

/**
 * Created by shuailongcheng on 21/02/2017.
 */

public class _27_RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void test() {
        int[] nums = {3,2,2,3};
        int cnt = removeElement(nums, 3);
        System.out.println();
    }
}
