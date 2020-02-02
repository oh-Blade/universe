package com.leetCode;

/**
 * @Description 2
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @Author naikuo
 * @Date 2020/1/1 9:21 AM
 */
public class ListNodeSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode p = l1, q = l2, curr = node;
        int currency = 0;
        while (p != null || q != null) {
            int m = p == null ? 0 : p.val;
            int n = q == null ? 0 : q.val;
            int sum = m + n + currency;
            currency = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (currency == 1) {
            curr.next = new ListNode(1);
        }
        return node.next;
    }


}

