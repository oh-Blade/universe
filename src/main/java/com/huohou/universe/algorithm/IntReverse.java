package com.huohou.universe.algorithm;

/**
 * @Classname com.universe.leetCode.IntReverse   7
 * @Description TODO
 * @DATE 2019/10/27 19:45
 * @Created by Administrator
 */
public class IntReverse {
    public static int reverse(int x) {
        StringBuilder builder = new StringBuilder();
        builder.append(x);
        if (x > 0) {
            Long aLong = Long.valueOf(builder.reverse().toString());
            if (aLong > Integer.MAX_VALUE) {
                return 0;
            } else {
                return Math.toIntExact(aLong);
            }
        } else if (x < 0) {
            builder.reverse().substring(0, builder.length() - 1);
            Long aLong = -Long.valueOf(builder.reverse().toString());
            if (aLong < Integer.MIN_VALUE) {
                return 0;
            } else {
                return Math.toIntExact(aLong);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
