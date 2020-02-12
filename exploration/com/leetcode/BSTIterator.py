#!/usr/local/bin python3
# -*- coding: utf-8 -*-
# ProjectName: universe
# Author: naikuo
# CreateTime: 2020/2/12 10:56 PM
# Description: 
# ----------------------------------
from com.leetcode import TreeNode


class BSTIterator:

    def __init__(self, root: TreeNode):
        self.nodes_sorted = []
        self.index = -1
        self._inorder(root)

    def _inorder(self, root):
        if not root:
            return

        self._inorder(root.left)
        self.nodes_sorted.append(root.val)
        self._inorder(root.right)

    def next(self) -> int:
        self.index += 1
        return self.nodes_sorted[self.index]

    def has_next(self) -> bool:
        return self.index + 1 < len(self.nodes_sorted)
