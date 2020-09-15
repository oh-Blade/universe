package com.leetCode;

/**
 * @author naikuoh
 * @Description
 * @DATE 2020/5/10 17:40
 */
public class ReplaceSpaces {
    public static String replaceSpaces(String S, int length) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String s = String.valueOf(S.charAt(i));
            if (" ".equals(s)) {
                builder.append("%20");
            }else {
                builder.append(s);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String mrJohnSmith = replaceSpaces("Mr John Smith    ", 13);
        System.out.println(mrJohnSmith);

    }
}
