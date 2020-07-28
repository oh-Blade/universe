package com.hnk.universe.algorithm;

/**
 * @Classname com.universe.leetCode.MaxArea
 * @Description TODO
 * @DATE 2019/10/27 20:20
 * @Created by Administrator
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
