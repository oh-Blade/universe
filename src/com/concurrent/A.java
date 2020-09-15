package com.concurrent;

/**
 * @author naikuoh
 * @DATE 2020/5/23 15:39
 */
public class A {
    public void method(){
        synchronized (this){
            System.out.println("A");
        }
    }
}
