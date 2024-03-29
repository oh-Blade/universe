package com.huohou.universe.algorithm;

/**
 * @Description 24题
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author naikuo
 * @Date 2020/2/2 8:30 PM
 */
public class SwapPairs {
    //迭代
    public ListNode swapPairs(ListNode head) {

        ListNode node = new ListNode(0);
        node.next = head;

        ListNode t = node;

        while (head != null && head.next != null) {
            ListNode fir = head;
            ListNode sec = head.next;

            t.next = sec;
            fir.next = sec.next;
            sec.next = fir;

            t = fir;
            head = fir.next;
        }

        return node.next;

    }

    //递归
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode fir = head;
//        ListNode sec = head.next;
//
//        fir.next = swapPairs(sec.next);
//        sec.next = fir;
//
//        return sec;
//
//    }
}
