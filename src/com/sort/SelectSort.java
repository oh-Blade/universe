package com.sort;

import java.util.Arrays;

/**
 * @Description 选择排序
 *
 * @Author naikuo
 * @Date 2020/2/10 3:55 PM
 */
public class SelectSort {

    public static void selectSort(int[] a) {
        int in, out, min;
        for (out = 0; out < a.length - 1; out++) {
            min = out;
            for (in = out; in < a.length; in++) {
                if (a[in] < a[min]) {
                    min = in;
                }
            }
            int temp = a[out];
            a[out] = a[min];
            a[min] = temp;
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        selectSort(new int[]{1,2,6,4,7,3});
    }

}
