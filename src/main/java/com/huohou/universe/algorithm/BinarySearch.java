package com.huohou.universe.algorithm;

/**
 * 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 *
 * @author naikuoh
 * @DATE 2020/7/28 10:19
 */
public class BinarySearch {

    /**
     * 正序数组
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchAsc(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
            if (target == nums[mid]) {
                return mid;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (right >= left) {
            int temp = (right + left) >> 2;
            if (nums[temp] == target) {
                return temp;
            } else if (nums[temp] > target) {
                right = temp - 1;
            } else {
                left = temp + 1;
            }
        }
        return -1;
    }


    /**
     * 倒序数组，查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchDesc(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int mid = 0;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(searchAsc(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(searchDesc(new int[]{12, 9, 5, 3, 2, 0, -1}, 2));
    }
}
