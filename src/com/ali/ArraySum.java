package com.ali;

import java.util.Arrays;

/**
 * @Description 给定一个整数数组和一个整数，返回两 个数组的索引，这两个索引指向的数字的加和等于指定 的整数。需要最优的算法，分析算法的空间和时间复杂 度。
 * @Author naikuo
 * @Date 2020/2/9 7:44 PM
 */
public class ArraySum {

    public static int[] arraySum(int[] array, int n) {
        int[] out = new int[2];

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == n) {
                    out[0] = i;
                    out[1] = j;
                    return out;
                }
            }

        }
        return out;
    }

    public static void main(String[] args) {
        int[] i = {1, 2, 3, 4, 5, 6};
        int n = 8;
        int[] ints = arraySum(i, n);
        System.out.println(Arrays.toString(ints));
    }

}
