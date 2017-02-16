package com.github.h0ngyue.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuailongcheng on 16/02/2017.
 */

public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                ret[0] = map.get(target - numbers[i]);
                ret[1] = i;
                break;
            }
            map.put(numbers[i], i);
        }

        return ret;
    }

    public static void test() {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.print(ints);
    }


}
