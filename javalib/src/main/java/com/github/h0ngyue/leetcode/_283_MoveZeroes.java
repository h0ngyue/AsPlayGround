package com.github.h0ngyue.leetcode;

/**
 * Created by shuailongcheng on 21/02/2017.
 */

public class _283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}