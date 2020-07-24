package com.hnk.universe.leetCode;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * @Description 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @Author naikuo
 * @Date 2019/11/26 11:20 AM
 */
public class LetterCombinations {

    static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    static List<String> output = new ArrayList<String>();

    public static void backtrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            output.add(combination);
        } else {
            String digit = nextDigits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }
    }

    public static List<String> letterCombinations(String digits) { //23
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }


    public static List<String> letterCombinations1(String digits) {

        if (digits == null || "".equals(digits)) {
            return new ArrayList<>();
        }

        String[] split = digits.split("");
        String s = phone.get(split[0]);
        List<String> out = Arrays.asList(s.split(""));

        List<String> zu = new ArrayList<>();

        for (int i = 1; i < split.length; i++) {
            String aZu = phone.get(split[i]);
            List<String> temp = new ArrayList<>();
            for (String o : out) {
                for (int j = 0; j < aZu.length(); j++) {
                    temp.add(o + aZu.charAt(j));
                }
            }
            out = temp;
        }
        return out;
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        System.out.println(strings.toString());

    }
}
