package com.hnk.universe.algorithm;

import com.hnk.universe.base.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description 1038题
 * 给出二叉搜索树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键小于节点键的节点。
 * 节点的右子树仅包含键大于节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @Author naikuo
 * @Date 2020/2/5 7:03 PM
 */
public class BstToGst {
    Deque<TreeNode> stack = new ArrayDeque<>();
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        middleIterator(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            sum = pop.val + sum;
            pop.val = sum;
        }
        return root;
    }

    public void middleIterator(TreeNode root) {
        if (root != null) {
            middleIterator(root.left);
            stack.push(root);
            middleIterator(root.right);
        }
    }

}
