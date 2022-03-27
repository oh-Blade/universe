package com.huohou.universe.algorithm;

import com.huohou.universe.base.TreeNode;

/**
 * @Description TODO
 * @Author naikuo
 * @Date 2020/2/6 3:45 PM
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        } else {
            if (Math.abs(depth(root.right) - depth(root.left)) > 1) {
                return false;
            } else {
                return isBalanced(root.right) && isBalanced(root.left);
            }
        }
    }

    public int depth(TreeNode root) {
        return root == null ? 0 : (Math.max(depth(root.right), depth(root.left))) + 1;
    }
}
