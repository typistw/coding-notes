package com.pattern.singleton;

/*
 * @author：jinsheng
 * @date：2023/04/09 15:28
 */
public class Emperor {

    private static  final Emperor emperor = new Emperor();

    private Emperor(){}

    public static Emperor getInstance(){
        return  emperor;
    }

    public static void say(){
        System.out.println("我是皇帝某某某...");
    }
}
