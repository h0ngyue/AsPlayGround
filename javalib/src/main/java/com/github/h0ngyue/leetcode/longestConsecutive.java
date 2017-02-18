package com.github.h0ngyue.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by shuailongcheng on 16/02/2017.
 */

public class longestConsecutive {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int longest = 0;
        for (int n : nums) {
            if (!set.contains(n)) {
                continue;
            }
            set.remove(n);
            int j = n - 1;
            int length = 1;
            while (set.contains(j)) {
                set.remove(j);
                j--;
                length++;
            }
            int i = n + 1;
            while (set.contains(i)) {
                set.remove(i);
                i++;
                length++;
            }
            longest = Math.max(length, longest);
        }
        return longest;
    }

    public static void test() {
//        new int[]{100, 4, 200, 1, 3, 2, 23, 5, 11231, 6, 123, 7};
//        int ret = longestConsecutive(nums);
        System.out.println();
    }
}
