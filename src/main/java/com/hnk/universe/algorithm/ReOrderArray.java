package com.hnk.universe.algorithm;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 示例1
 * 输入：
 * [1,2,3,4]
 * 复制
 * 返回值：
 * [1,3,2,4]
 * 复制
 * 示例2
 * 输入：
 * [2,4,6,5,7]
 * 复制
 * 返回值：
 * [5,7,2,4,6]
 */
public class ReOrderArray {
    public static int[] reOrderArray(int[] array) {
        Queue<Integer> odd = new ArrayDeque();
        Queue<Integer> even = new ArrayDeque();
        for (Integer i : array) {
            if (i % 2 == 0) {
                even.add(i);
            } else {
                odd.add(i);
            }
        }
        int i = 0;
        int oddSize = odd.size();
        for (; i < oddSize; i++) {
            array[i] = odd.poll();
        }
        int evenSize = even.size();
        for (; i < oddSize + evenSize; i++) {
            array[i] = even.poll();
        }
        return array;
    }

    public static void main(String[] args) {
        int[] ints = reOrderArray(new int[]{1, 2, 3, 4});
        System.out.println(ints);
    }
}
