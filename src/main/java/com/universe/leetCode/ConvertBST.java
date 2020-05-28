package com.universe.leetCode;

import com.universe.base.TreeNode;

import java.util.Arrays;

/**
 * @Classname com.universe.leetCode.ConvertBST
 * @Description TODO
 * @DATE 2019/11/11 23:01
 * @Created by Administrator
 */
public class ConvertBST {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rh = getHeight(root.right);
        int lh = getHeight(root.left);
        return lh + rh;
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    }

    public static int[] maxSubArray(int[] nums) {
        int[] out = new int[nums.length];
        int ans = nums[0];
        int sum = 0;
        int i = 0;
        for(int num: nums) {
            if(sum > 0) {
//                out[i++] = num;
                sum += num;
            } else {
                i = 0;
                out[i++] = num;
                sum = num;
            }
            if(sum>ans){
                out[i++] = num;
            }
//            ans = Math.max(ans, sum);
        }
        return out;
    }

    public static void main(String[] args) {
        int[] ints = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(Arrays.toString(ints));
    }

}
