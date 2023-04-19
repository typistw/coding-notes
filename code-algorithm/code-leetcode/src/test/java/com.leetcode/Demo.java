package com.leetcode;

/*
 * @author：jinsheng
 * @date：2022/02/26 20:17
 */
public class Demo {

    public static void main(String[] args) {
        String s = "/nmame/test/aaa.csv";
        String[] arra= s.split("/");
        String fileName = arra[arra.length -1];
        String[] arrayName= fileName.split("\\.");
        System.out.println(arrayName[0] + " : " + arrayName[1]);
        System.out.println("输入1， 得到:" + getN(1));
        System.out.println("输入2， 得到:" + getN(2));
        System.out.println("输入3， 得到:" + getN(3));
        System.out.println("输入100， 得到:" + getN(100));

        int a[]= new int[5];
        System.out.println(a[1]);

    }

    private static int getN(int n){
        if(n < 1)
            return 0;
        if(n ==1)
            return 4;
        return getN(n-1) + 3;
    }
}

