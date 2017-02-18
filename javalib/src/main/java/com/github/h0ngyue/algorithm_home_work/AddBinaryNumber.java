package com.github.h0ngyue.algorithm_home_work;

/**
 * Created by shuailongcheng on 18/02/2017.
 */

public class AddBinaryNumber {

    public static byte[] add(byte[] a, byte[] b) {
        if (a.length != b.length || a.length == 0) {
            return null;
        }

        byte[] result = new byte[a.length + 1];

        boolean overflow = false;
        for (int i = a.length - 1; i >= 0; i--) {
            byte tmp = (byte) (a[i] + b[i] + (overflow ? 1 : 0));
            overflow = tmp >= 2;
            result[i + 1] = (byte) (tmp % 2);
        }
        result[0] = (byte) (overflow ? 1 : 0);
        return result;
    }

    public static void test() {
        byte[] a = {1, 0, 0, 1};
        byte[] b = {1, 0, 1, 1};

        byte[] add = add(a, b);
        System.out.println();
    }
}
