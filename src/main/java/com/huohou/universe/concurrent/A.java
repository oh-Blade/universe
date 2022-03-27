package com.huohou.universe.concurrent;

import com.huohou.universe.base.TreeNode;

import java.util.HashMap;

/**
 * @author naikuoh
 * @DATE 2020/5/23 15:39
 */
public class A {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        System.out.println(map.getClass().getClassLoader());
        TreeNode node = new TreeNode(1);
        System.out.println(node.getClass().getClassLoader());
    }

}
