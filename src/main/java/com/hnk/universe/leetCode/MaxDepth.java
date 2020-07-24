package com.hnk.universe.leetCode;

import com.hnk.universe.base.TreeNode;

/**
 * @Description 104题
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @Author naikuo
 * @Date 2020/2/6 10:52 AM
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

    }
}
