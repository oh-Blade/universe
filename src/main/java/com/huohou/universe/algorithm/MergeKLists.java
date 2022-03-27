package com.huohou.universe.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description 23题
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author naikuo
 * @Date 2020/1/22 10:27 PM
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        List<Integer> value = new ArrayList<>();

        for (ListNode list : lists) {
            ListNode node = list;
            while (node != null) {
                value.add(node.val);
                node = node.next;
            }
        }

        Collections.sort(value);

        ListNode head = new ListNode(0);

        ListNode point = head;

        int i = 0;

        while (i < value.size()) {
            point.next = new ListNode(value.get(i));
            point = point.next;
            i++;
        }

        return head.next;
    }
}
