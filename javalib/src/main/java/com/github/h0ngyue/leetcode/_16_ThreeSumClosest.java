package com.github.h0ngyue.leetcode;

import java.util.Arrays;

/**
 * Created by shuailongcheng on 19/02/2017.
 */

public class _16_ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int ret = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int tmpSum = nums[low] + nums[high] + nums[i];
                boolean isCloseer = Math.abs(min) > Math.abs(tmpSum - target);
                if (isCloseer) {
                    min = Math.abs(tmpSum - target);
                    ret = tmpSum;
                }
                if (tmpSum == target) {
                    return target;
                } else if (tmpSum > target) {
                    high--;
                } else {
                    low++;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return ret;
    }


    public static void test() {
        int[] arr = {1, 1, 1, 0};
        int ret = threeSumClosest(arr, 100);
        System.out.println();
    }
}
