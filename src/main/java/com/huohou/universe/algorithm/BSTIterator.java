package com.huohou.universe.algorithm;

import com.huohou.universe.base.TreeNode;

import java.util.ArrayList;

/**
 * @Description 173题
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * <p>
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * <p>
 * 示例：
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author naikuo
 * @Date 2020/2/5 4:04 PM
 */
public class BSTIterator {

    ArrayList<Integer> nodesSorted;
    int index = 0;


    public BSTIterator(TreeNode root) {

        this.nodesSorted = new ArrayList<>();
        this.index = -1;
        inorder(root);
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        this.inorder(root.left);
        this.nodesSorted.add(root.val);
        this.inorder(root.right);
    }


    /**
     * @return the next smallest number
     */
    public int next() {
        return this.nodesSorted.get(++index);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.index + 1 < this.nodesSorted.size();
    }
}
