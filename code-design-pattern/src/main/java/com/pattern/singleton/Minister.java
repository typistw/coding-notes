package com.pattern.singleton;

/*
 * @author：jinsheng
 * @date：2023/04/09 15:30
 */
public class Minister {

    public static void main(String[] args) {
        for( int day=0; day <3; day++){
            Emperor emperor = Emperor.getInstance();
            emperor.say();
        }
    }
}
