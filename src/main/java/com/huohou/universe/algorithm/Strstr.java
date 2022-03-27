package com.huohou.universe.algorithm;

/**
 * @Description 28题
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author naikuo
 * @Date 2020/3/1 1:58 PM
 */
public class Strstr {
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int begin = 0;
        int end = begin + needle.length();
        while (end<=haystack.length()){
            if(needle.equals(haystack.substring(begin,end))){
                return begin;
            }else{
                begin++;
                end++;
            }
        }
        return -1;
    }
}
