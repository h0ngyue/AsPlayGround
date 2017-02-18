package com.github.h0ngyue.leetcode;

import java.util.Timer;

/**
 * Created by shuailongcheng on 16/02/2017.
 */

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int id = 0;
        for (int n : nums) {
            if (id < 2 || n > nums[id-2]) {
                nums[id++] = n;
            }
        }
        return id;
    }


    public static void test() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int ret = removeDuplicates(nums);
        System.out.println();
    }
}
