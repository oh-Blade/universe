package com.huohou.universe.algorithm;

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
 * 原因：342 + 665 = 1007
 * @Author naikuo
 * @Date 2020/1/1 9:21 AM
 */
public class ListNodeSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode outNode = new ListNode(0);

        ListNode l1temp = l1;
        ListNode l2temp = l2;
        ListNode curry = outNode;
        int commit = 0;
        while (l1temp != null || l2temp != null) {
            int value = (l1temp != null ? l1temp.val : 0) + (l2temp != null ? l2temp.val : 0) + commit;
            commit = value / 10;
            curry.next = new ListNode(value % 10);
            curry = curry.next;

            l1temp = l1temp != null ? l1temp.next : null;
            l2temp = l2temp != null ? l2temp.next : null;
        }
        if (commit == 1) {
            curry.next = new ListNode(1);
        }
        return outNode.next;

    }


}

