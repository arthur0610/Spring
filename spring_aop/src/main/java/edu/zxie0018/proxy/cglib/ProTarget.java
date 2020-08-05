package edu.zxie0018.proxy.cglib;

public class ProTarget {
    public void beforePro() {
        System.out.println("before...");
    }

    public void afterPro() {
        System.out.println("after");
    }
}
