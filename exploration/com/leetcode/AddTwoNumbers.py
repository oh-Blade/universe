#!/usr/local/bin python3
# -*- coding: utf-8 -*-
# ProjectName: universe
# Author: naikuo
# CreateTime: 2020/2/16 2:15 PM
# Description: 
# ----------------------------------
from com.leetcode import ListNode


class AddTwoNumbers(object):
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        out = ListNode(-1)
        s, carry, p, carry = 0, 0, out, 0

        while l1 or l2:
            val = l1.val if l1 else 0 + l2.val if l2 else 0 + carry
            s, carry = val % 10, val / 10

            l1, l2 = l1 if l1 else None, l2 if l2 else None
            p.next = ListNode(s)
            p = p.next
        if carry == 1:
            p.next = ListNode(1)

        return out.next

    def addTwoNumber(self, l1, l2):
        # 定义一个进位标志
        a, b, p, carry = l1, l2, None, 0
        while a or b:
            # a和b节点的值相加，如果有进位还要加上进位的值
            val = (a.val if a else 0) + (b.val if b else 0) + carry
            # 根据val判断是否有进位,不管有没有进位，val都应该小于10
            carry, val = val / 10 if val >= 10 else 0, val % 10
            p, p.val = a if a else b, val
            # a和b指针都前进一位
            a, b = a.next if a else None, b.next if b else None
            # 根据a和b是否为空，p指针也前进一位
            p.next = a if a else b
        # 不要忘记最后的边界条件，如果循环结束carry>0说明有进位需要处理这个条件
        if carry:
            p.next = ListNode(carry)
        # 每次迭代实际上都是将val赋给a指针的，所以最后返回的是l1
        return l1
