package com.universe.sort;

import java.util.Arrays;

/**
 * @Description 插入排序
 * @Author naikuo
 * @Date 2020/2/10 4:24 PM
 */
public class InsertSort {
    public static void insertSort(int[] a) {

        for (int i = 1; i < a.length; i++) {

            int temp = a[i];

            int j = i;
            while (j > 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            if (i != j) {
                a[j] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        insertSort(new int[]{1, 2, 6, 4, 7, 3});
    }
}
