package com.universe.leetCode;

import java.util.Arrays;

public class Main {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] nums = new int[len];

        if(len1 == 0){
            return getMedia(nums2);
        }
        if(len2 == 0){
            return getMedia(nums1);
        }

        for (int i = 0; i < len; i++) {
            if (i < len1) {
                nums[i] = nums1[i];
            }else{
                nums[i] = nums2[i-len1];
            }
        }
        Arrays.sort(nums);
        return getMedia(nums);
    }

    private double getMedia(int[] nums1) {
        if (isEvenNum(nums1.length)) {
            return (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0;
        } else {
            return nums1[(nums1.length - 1) / 2];
        }
    }

    private boolean isEvenNum(int num) {
        int remainder = num % 2;
        if (remainder == 1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        double a = 5;
        System.out.println(a / 2);
    }

//    public  String[] spellchecker(String[] wordlist, String[] queries) {
//        List<String> tar = new ArrayList();
//        dong:
//        for (int i = 0; i < queries.length; i++) {
//            for (int j = 0; j < wordlist.length; j++) {
//                if (queries[i].length() != wordlist[j].length()) {
//                    tar.add("");
//                    continue dong;
//                }
//                if (queries[i].equals(wordlist[j])) {
//                    tar.add(wordlist[j]);
//                    continue dong;
//                }
//            }
//
//            for (int j = 0; j < wordlist.length; j++) {
//                if (queries[i].toLowerCase().equals(wordlist[j].toLowerCase())) {
//                    tar.add(wordlist[j]);
//                    continue dong;
//                }
//            }
//
//            for (int j = 0; j < wordlist.length; j++) {
//                String query = get(queries[i].toLowerCase());
//                String word = get(wordlist[j].toLowerCase());
//                if (query.toLowerCase().equals(word.toLowerCase())) {
//                    tar.add(wordlist[j]);
//                    continue dong;
//                }
//            }
//            tar.add("");
//
//        }
//
//        String[] array = new String[tar.size()];
//        return tar.toArray(array);
//    }
//
//    public  String get(String string){
//        char[] chars = string.toCharArray();
//        StringBuilder builder = new StringBuilder();
//        for(char c:chars){
//            builder.append(isVowel(c)?"*":c);
//        }
//        return builder.toString();
//    }
//    public  boolean isVowel(char c) {
//        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
//    }u


}
