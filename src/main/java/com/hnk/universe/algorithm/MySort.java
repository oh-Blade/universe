package com.hnk.universe.algorithm;

/**
 * 题目描述
 * 给定一个数组，请你编写一个函数，返回该数组排序后的形式。
 * 输入
 * [5,2,3,1,4]
 * 返回值
 * [1,2,3,4,5]
 */
public class MySort {

    public int[] MySort (int[] arr) {
        quickSort(arr , 0 , arr.length-1);
        return arr;
    }
    public void quickSort(int[] list, int left, int right) {
        if (left < right) {
            // 分割数组，找到分割点
            int point = partition(list, left, right);
            // 递归调用，对左子数组进行快速排序
            quickSort(list, left, point - 1);
            // 递归调用，对右子数组进行快速排序
            quickSort(list, point + 1, right);
        }
    }

    /**
     * 分割数组，找到分割点
     */
    public int partition(int[] list, int left, int right) {
        // 用数组的第一个元素作为基准数
        int first = list[left];
        while (left < right) {
            while (left < right && list[right] >= first) {
                right--;
            }

            // 交换
            swap(list, left, right);

            while (left < right && list[left] <= first) {
                left++;
            }

            // 交换
            swap(list, left, right);
        }
        // 返回分割点所在的位置
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 冒泡
     */
    public static int[] bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
    
}
