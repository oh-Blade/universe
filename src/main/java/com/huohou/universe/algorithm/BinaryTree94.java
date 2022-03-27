package com.huohou.universe.algorithm;

import com.huohou.universe.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author naikuoh
 * @DATE 2020/9/14 10:59
 */
public class BinaryTree94 {
    private List<Integer> list = new ArrayList<>();

    /**
     * 方法一：递归
     * 思路与算法
     *
     * 首先我们需要了解什么是二叉树的中序遍历：按照访问左子树——根节点——右子树的方式遍历这棵树，而在访问左子树或者右子树的时候我们按照同样的方式遍历，直到遍历完整棵树。因此整个遍历过程天然具有递归的性质，我们可以直接用递归函数来模拟这一过程。
     *
     * 定义 inorder(root) 表示当前遍历到 \textit{root}root 节点的答案，那么按照定义，我们只要递归调用 inorder(root.left) 来遍历 \textit{root}root 节点的左子树，然后将 \textit{root}root 节点的值加入答案，再递归调用inorder(root.right) 来遍历 \textit{root}root 节点的右子树即可，递归终止的条件为碰到空节点。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
}































