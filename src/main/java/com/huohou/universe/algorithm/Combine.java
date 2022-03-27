package com.huohou.universe.algorithm;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description 77
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入: n = 4, k = 3
 * 输出:
 * [
 * [2,3,4],
 * [1,2,3],
 * [1,2,4],
 * [1,3,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author naikuo
 * @Date 2019/12/7 11:50 PM
 */
public class Combine {
    private List<List<Integer>> output = new LinkedList<>();
    private int n;
    private int k;

    public void backtrack(int first, LinkedList<Integer> curr) {
        // if the combination is done
        if (curr.size() == k) {
            output.add(new LinkedList(curr));
        }

        for (int i = first; i < n + 1; ++i) {

            curr.add(i);

            backtrack(i + 1, curr);

            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return output;
    }

    @Test
    public void testCombine() {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);

    }

}
