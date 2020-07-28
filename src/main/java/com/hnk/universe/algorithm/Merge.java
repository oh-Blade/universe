package com.hnk.universe.algorithm;

/**
 * @Classname com.universe.leetCode.Merge
 * @Description TODO
 * @DATE 2019/11/4 23:30
 * @Created by Administrator
 */
public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
       int start2 = 0;
       int start1 = 0;
       while (start2<n){
           if(nums2[start2]<nums1[start1]){
               setAeeay(nums1,start1);
               nums1[start1] = nums2[start2];
               start2++;
           }else{
               start1++;
           }
       }
    }
    public static void setAeeay(int[] arr,int start){
        for(int i=arr.length-1;i>start;i--){
            arr[i]=arr[i-1];
        }
    }

    public static void main(String[] args) {
        int[] a = {1,4,5,6};
        setAeeay(a,1);
        System.out.println(a);
    }
}
