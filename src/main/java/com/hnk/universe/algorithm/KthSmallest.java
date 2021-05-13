package com.hnk.universe.algorithm;

import com.hnk.universe.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 面试题 003 给定一个二叉搜索树(BST)，找到树中 第 K 小的节点
 * @Author naikuo
 * @Date 2020/2/8 8:01 PM
 */
public class KthSmallest {

    List<Integer> list = new ArrayList<>();
    int k = 8;

    public int kthSmallest(TreeNode root) throws Exception {

        if(list.size() == k){
            return root.val;
        }

        if (root != null) {
            kthSmallest(root.left);
            list.add(root.val);
            kthSmallest(root.right);
        }

        throw new Exception("没有K个节点");


    }
}
