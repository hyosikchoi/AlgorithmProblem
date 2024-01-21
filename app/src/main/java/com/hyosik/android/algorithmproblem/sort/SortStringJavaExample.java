package com.hyosik.android.algorithmproblem.sort;

public class SortStringJavaExample {

    public static void main(String[] args) {
        String a = "abcd";
        String b = "abcd";

        System.out.println(System.identityHashCode("abcd"));
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));

        if(a == b) System.out.println("같습니다.");
        else System.out.println("다릅니다.");

        a += "e";
        b += "e";

        if(a == b) System.out.println("같습니다.");
        else System.out.println("다릅니다.");

    }

}
