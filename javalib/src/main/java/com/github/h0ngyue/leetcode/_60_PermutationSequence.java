package com.github.h0ngyue.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuailongcheng on 03/03/2017.
 */

public class _60_PermutationSequence {

    public static String kThSequence(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        for (int j = 0; j < k - 1; j++) {
            _31_NextPermutation.nextPermutation(nums);
        }

        StringBuffer sb = new StringBuffer();
        for (int a : nums) {
            sb.append(a);
        }

        System.out.print(sb.toString());
        return sb.toString();
    }

    // 康托编码思路
    public static String kThSequence2(int n, int k) {
        int kTmp = k - 1;
        int[] indexs = new int[n];
        indexs[n - 1] = 0;
        for (int i = 0; i < n - 1; i++) {
            int factorial = factorial(n - 1 - i);
            indexs[i] = kTmp / factorial;
            kTmp = (kTmp % factorial);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(indexs[i]));
            list.remove(indexs[i]);
        }
        return sb.toString();
    }

    public static int factorial(int n) {
        int ret = 1;
        for (int i = 2; i <= n; i++) {
            ret *= i;
        }
        return ret;
    }

    public static void test() {
        kThSequence2(3, 4);
    }
}
