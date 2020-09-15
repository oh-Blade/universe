package com.hnk.universe.base;

/**
 * @Description java代码块执行顺序
 * @Author naikuo
 * @Date 2020/2/21 8:37 PM
 */
public class ExecutionSequence {
    public static void main(String[] args) {
        B b = new B();
    }
}

class A {
    public static String strStaticA = "静态属性A";

    public String stra = "非静态属性A";

    static {
        System.out.println("静态代码块A");
    }

    {
        System.out.println("非静态代码块A");
    }

    public A() {
        System.out.println("构造方法A");
    }
}

class B extends A {
    public static String strStaticB = "静态属性B";

    public String strb = "非静态属性B";

    static {
        System.out.println("静态代码块B");
    }

    {
        System.out.println("非静态代码块B");
    }

    public B() {
        System.out.println("构造方法B");
    }
}


