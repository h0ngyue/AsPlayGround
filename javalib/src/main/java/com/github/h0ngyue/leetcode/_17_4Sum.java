package com.github.h0ngyue.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuailongcheng on 20/02/2017.
 */

public class _17_4Sum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ret = new ArrayList<>();

        if (nums.length < 4) {
            return ret;
        }

        for (int i = 0; i < nums.length - 3; i++) {
            threeSum(nums[i], nums, i + 1, target - nums[i], ret);
            while ((i < nums.length - 3) && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return ret;
    }

    private static void threeSum(int x1, int[] nums, int start, int target,
            List<List<Integer>> ret) {
        for (int i = start; i < nums.length - 2; i++) {
            twoSum(x1, nums[i], nums, i + 1, target - nums[i], ret);

            while ((i < nums.length - 2) && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }

    private static void twoSum(int x1, int x2, int[] nums, int start, int target,
            List<List<Integer>> ret) {
        int low = start;
        int high = nums.length - 1;

        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                ret.add(Arrays.asList(x1, x2, nums[low], nums[high]));
                low++;
                high--;

                while (low < nums.length - 1 && nums[low] == nums[low - 1]) {
                    low++;
                }
                while (high > 0 && nums[high] == nums[high + 1]) {
                    high--;
                }
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }
    }

    public static void test() {
        int[] s = {-5, -2, -2, -2, 0, 0};
        List<List<Integer>> lists = fourSum(s, -9);
        System.out.println();
    }

}
