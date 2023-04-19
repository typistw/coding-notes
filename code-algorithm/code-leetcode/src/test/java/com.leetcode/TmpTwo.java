package com.leetcode;

/*
 * @author：jinsheng
 * @date：2022/07/10 21:42
 */
public class TmpTwo extends Tmp{

    private final static Integer b=2;

    public static void main(String[] args) {
    }

    private void a(){}

    private void b(){
        this.a();
    }

    private static void c(){

    }

    private static  void d(){
        c();
    }
}
