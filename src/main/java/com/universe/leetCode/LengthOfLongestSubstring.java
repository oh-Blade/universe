package com.universe.leetCode;

/**
 * @Description 3题
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Author naikuo
 * @Date 2020/2/11 5:39 PM
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }

        String target = "";

        String mid = "";

        for (int i = 0; i < s.length(); i++) {
            String is = String.valueOf(s.charAt(i));
            if (mid.contains(is)) {

                if (mid.length() > target.length()) {
                    target = mid;
                }
                mid = mid.substring(mid.indexOf(is) + 1) + is;
            } else {
                mid = mid + is;
            }
        }
        return Math.max(mid.length(), target.length());
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("vddfc"));
    }
}
