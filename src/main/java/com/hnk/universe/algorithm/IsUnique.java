package com.hnk.universe.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname IsUnique
 * @Description 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * @DATE 2020/3/17 16:58
 * @Created by Administrator
 */
public class IsUnique {

    public boolean isUnique(String astr) {

        Map<Character,String> map = new HashMap<>();

        for(int i=0;i<astr.length();i++){
            if(map.containsKey(astr.charAt(i))){
                return false;
            }else{
                map.put(astr.charAt(i),"");
            }
        }
        return true;
    }
}
