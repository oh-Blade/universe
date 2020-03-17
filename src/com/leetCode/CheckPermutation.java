package com.leetCode;

import java.util.Arrays;

/**
 * @Classname CheckPermutation
 * @Description 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 * @DATE 2020/3/17 17:30
 * @Created by Administrator
 */
public class CheckPermutation {

    /**
     * 执行用时 :
     * 2 ms
     * 在所有 Java 提交中击败了 5.66%的用户
     * 内存消耗 :
     * 37.3 MB
     * , 在所有 Java 提交中击败了100.00%的用户
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String[] s1Array = s1.split("");
        Arrays.sort(s1Array);
        String[] s2Array = s2.split("");
        Arrays.sort(s2Array);
        int i = 0;
        while (i < s1Array.length) {
            if (!s1Array[i].equals(s2Array[i])) {
                return false;
            }
            i++;
        }
        return true;
    }

    /**
     * 执行用时 :
     * 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :
     * 37.2 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkPermutation2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        return String.valueOf(c1).equals(String.valueOf(c2));
    }

}
