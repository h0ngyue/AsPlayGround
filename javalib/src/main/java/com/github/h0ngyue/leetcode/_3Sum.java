package com.github.h0ngyue.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shuailongcheng on 16/02/2017.
 */

public class _3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (map.containsKey(nums[i]))
            }
        }
    }
}
