package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @Description LinkedList和ArrayList到底谁快
 * @Author naikuo
 * @Date 2020/1/17 3:41 PM
 * <p>
 * 本代码测试环境
 * MacBook Pro (Retina, 15-inch, Mid 2015)
 * 处理器 2.2 GHz Intel Core i7
 * 内存 16GB 1600 MHz DDR3
 */
public class ArrayAndLinkedList {

    private static List<String> linkList = new LinkedList<>();
    private static List<String> arrayList = new ArrayList<>();


    public static String getRandomString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int number = random.nextInt(str.length());
            char charAt = str.charAt(number);
            sb.append(charAt);
        }
        return sb.toString();
    }

    /**********************插入*******************************/
    public static void initLinkList(int size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            linkList.add(getRandomString());
        }
        System.out.println("添加" + size + "个元素用时：" + (System.currentTimeMillis() - start));
    }

    public static void initArrayList(int size) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arrayList.add(getRandomString());
        }
        System.out.println("添加" + size + "个元素用时：" + (System.currentTimeMillis() - start));
    }

    /**
     * 插入频繁时用ArrayList
     */
//    public static void main(String[] args) {
//        initLinkList(1000);            //添加1000个元素用时：7    7    6
//        initArrayList(1000);           //添加1000个元素用时：7    6     6

//        initLinkList(10000);         //添加10000个元素用时：13   15    13
//        initArrayList(10000);       //添加10000个元素用时：13    14   14

//        initLinkList(100000);       //添加10000个元素用时：48   43   42
//        initArrayList(100000);      //添加10000个元素用时：43   47   43

//        initLinkList(1000000);     //添加10000个元素用时：388   389   360
//        initArrayList(1000000);    //添加10000个元素用时：260   263  263
//    }


    /*************************获取index**************************************/
    public static void getLinkList(int index) {
        long start = System.currentTimeMillis();
        linkList.get(index);
        System.out.println("获取LinkedList第" + index + "个元素用时：" + (System.currentTimeMillis() - start));
    }

    public static void getArrayList(int index) {
        long start = System.currentTimeMillis();
        arrayList.get(index);
        System.out.println("获取ArrayList第" + index + "个元素用时：" + (System.currentTimeMillis() - start));
    }

    /**
     * 结论查找频繁时用ArrayList
     */
//    public static void main(String[] args) {
//        initLinkList(10000);
//        getLinkList(2000);        //获取LinkedList第2000个元素用时：1   0    0
//        getLinkList(8000);        //获取LinkedList第8000个元素用时：0   1    0
//        initArrayList(10000);
//        getArrayList(2000);  //获取ArrayList第2000个元素用时：0    0    0
//        getArrayList(8000);  //获取ArrayList第2000个元素用时：0    0    0

//        initLinkList(1000000);
//        getLinkList(200000);        //获取LinkedList第200000个元素用时：15   8   7    6
//        getLinkList(1000000/2);     //获取LinkedList第200000个元素用时：16  15   15   13
//        getLinkList(800000);        //获取LinkedList第800000个元素用时：6    5   6    4
//        initArrayList(1000000);
//        getArrayList(200000);  //获取ArrayList第200000个元素用时：0   0   0
//        getArrayList(1000000/2);//获取ArrayList第200000个元素用时：0  0   0
//        getArrayList(800000);  //获取ArrayList第200000个元素用时：0   0   0
//    }


    /****************************删除index*************************************/
    public static void removeLinkList(int index) {
        long start = System.currentTimeMillis();
        linkList.remove(index);
        System.out.println("删除LinkedList第" + index + "个元素用时：" + (System.currentTimeMillis() - start));
    }

    public static void removeArrayList(int index) {
        long start = System.currentTimeMillis();
        arrayList.remove(index);
        System.out.println("删除ArrayList第" + index + "个元素用时：" + (System.currentTimeMillis() - start));
    }

    /**
     * 结论
     * remove(index)频繁时选择用ArrayList
     */
//    public static void main(String[] args) {
//        initLinkList(10000);
//        removeLinkList(2000);        //删除LinkedList第2000个元素用时：0
//        removeLinkList(8000);        //删除LinkedList第8000个元素用时：0
//        initArrayList(10000);
//        removeArrayList(2000);  //删除ArrayList第2000个元素用时：0
//        removeArrayList(8000);  //删除ArrayList第8000个元素用时：0
//
//        initLinkList(1000000);
//        removeLinkList(200000);        //删除LinkedList第200000个元素用时：6   6   6
//        removeLinkList(1000000 / 2);     //删除LinkedList第200000个元素用时：14  18   16
//        removeLinkList(800000);        //删除LinkedList第800000个元素用时：5    6   5
//        initArrayList(1000000);
//        removeArrayList(200000);      //删除ArrayList第200000个元素用时：1   1    0
//        removeArrayList(1000000 / 2); //删除ArrayList第500000个元素用时：0   0   0
//        removeArrayList(800000);      //删除ArrayList第800000个元素用时：0   0   0
//    }


    /*********************************删除object***************************************/
    public static void removeObjectLinkList(int size, int index) {

        String randomString = "";
        for (int i = 0; i < size; i++) {
            if (i != index) {
                linkList.add(getRandomString());
            } else {
                randomString = "flag" + getRandomString();
                linkList.add(randomString);
            }
        }
        long start = System.currentTimeMillis();
        linkList.remove(randomString);
        System.out.println("LinkedList删除*" + "元素用时：" + (System.currentTimeMillis() - start));
    }

    public static void removeObjectArrayList(int size, int index) {
        String randomString = "";
        for (int i = 0; i < size; i++) {
            if (i != index) {
                arrayList.add(getRandomString());
            } else {
                randomString = "flag" + getRandomString();
                arrayList.add(randomString);
            }
        }
        long start = System.currentTimeMillis();
        arrayList.remove(randomString);
        System.out.println("ArrayList删除*" + "元素用时：" + (System.currentTimeMillis() - start));
    }

    /**
     * remove(object)时 用ArrayList
     */
//    public static void main(String[] args) {
    //初始化10000，元素位于靠前位置2000
//        removeObjectLinkList(10000, 2000);              //LinkedList删除*元素用时：0
//        removeObjectArrayList(10000, 2000);             //ArrayList删除*元素用时：0
    //初始化10000，元素位于靠后位置8000
//        removeObjectLinkList(10000, 8000);    //LinkedList删除*元素用时：0    1
//        removeObjectArrayList(10000, 8000);  //ArrayList删除*元素用时：0    1

    //初始化1000000，元素位于靠前位置20000
//        removeObjectLinkList(1000000, 20000);              //LinkedList删除*元素用时：1    2     1
//        removeObjectArrayList(1000000, 20000);             //ArrayList删除*元素用时：1     1     1
    //初始化1000000，元素位于靠后位置800000
//        removeObjectLinkList(1000000, 800000);    //LinkedList删除*元素用时：16   27   16   27
//        removeObjectArrayList(1000000, 800000);  //ArrayList删除*元素用时：17    19    11    21
//    }
}
