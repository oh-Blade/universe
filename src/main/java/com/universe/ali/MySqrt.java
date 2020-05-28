package com.universe.ali;

/**
 * @Description
 * 已知 sqrt (2)约等于 1.414，要求不用 数学库，求 sqrt (2)精确到小数点后 10 位。
 * @Author naikuo
 * @Date 2020/2/8 7:42 PM
 */
public class MySqrt {

    public static void main(String[] args) {
        double low = 1.413;
        double high = 1.415;
        double mid = 1.414;

        while (high - low > 1e-10) {
            mid = (low + high) / 2.0;
            if (mid * mid < 2) {
                low = mid;
            }else{
                high = mid;
            }
        }

        System.out.println(mid);
        System.out.println(Math.sqrt(2));
    }
}
