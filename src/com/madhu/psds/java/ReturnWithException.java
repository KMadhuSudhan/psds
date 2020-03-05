package com.madhu.psds.java;


import java.util.ArrayList;
import java.util.List;

public class ReturnWithException {
    public static void main(String[] args) {
        ReturnWithException returnWithException = new ReturnWithException();
        List<Integer> arr = new ArrayList<>();
        returnWithException.check(arr);

    }

    public void check(List<Integer> arr) {
        InnerClass innerClass = new InnerClass();
        InnerClass.Test1 innerClassY = innerClass.new Test1();
        System.out.println(innerClassY.str());
        try {
            System.out.println("try check");
            return;
        } catch (Exception io) {
            System.out.println("Exception check");
        } finally {
            System.out.println("finally check");
        }
    }
}
