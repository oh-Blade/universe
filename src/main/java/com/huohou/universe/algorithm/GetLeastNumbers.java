package com.huohou.universe.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 描述
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 * 示例1
 * 输入：
 * [4,5,1,6,2,7,3,8],4
 * 复制
 * 返回值：
 * [1,2,3,4]
 */
public class GetLeastNumbers {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || k <= 0) {
            return new ArrayList<>();
        }
        if (k > input.length) {
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(input[0]);
        for (int i = 1; i < input.length; i++) {
            if (i < k) {
                int n = 0;
                while (n < list.size() && input[i] > list.get(n)) {
                    n++;
                }
                list.add(n, input[i]);
            } else {
                if (input[i] < list.get(k - 1)) {
                    list.remove(k - 1);
                    int n = 0;
                    while (n < list.size() && input[i] > list.get(n)) {
                        n++;
                    }
                    list.add(n, input[i]);
                }
            }
        }
        return list;
    }
    public static ArrayList<Integer> GetLeastNumbersByQueue(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int j : input) {
            if (maxHeap.size() != k) {
                maxHeap.offer(j);
            } else if (maxHeap.peek() > j) {
                maxHeap.poll();
                maxHeap.offer(j);
            }
        }
        result.addAll(maxHeap);
        return result;
    }
}
