package com.hnk.universe.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 向有序链表中添加元素，使之依然有序，查找应插入的位置
 *
 * @author naikuoh
 * @DATE 2020/7/28 15:16
 */
public class ListSearchIndex {

    /**
     * 在升序链表中中查找目标值插入位置
     * 时间复杂度：O(logn)，其中 n 为list的长度。
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     *
     * @param list
     * @param target
     * @return
     */
    public static int searchAsc(List<Double> list, double target) {
        int n = list.size();
        int left = 0;
        int right = n - 1;
        int ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= list.get(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 在降序链表中中查找目标值插入位置
     * 时间复杂度：O(logn)，其中 n 为list的长度。
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     *
     * @param list
     * @param target
     * @return
     */
    public static int searchDesc(List<Double> list, double target) {
        int left = 0;
        int right = list.size() - 1;
        int ans = 0;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= list.get(mid)) {
                ans = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        List<Double> list = new ArrayList<>();
        list.add(99d);//0
        list.add(90d);//1
        list.add(85d);//2
        list.add(72d);//3
        list.add(70d);//4
        list.add(45d);//5
        list.add(30d);//6
        list.sort((o1, o2) -> {
            if (o1 < o2) {
                return 1;
            } else {
                return -1;
            }
        });
        System.out.println("desc");
        int search = searchDesc(list, 72d);
        System.out.println(search);

        System.out.println("asc");

        list.sort((o1, o2) -> {
            if (o1 < o2) {
                return -1;
            } else {
                return 1;
            }
        });
        System.out.println(searchAsc(list, 31d));
    }
}
