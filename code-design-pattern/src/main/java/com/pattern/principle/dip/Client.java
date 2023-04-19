package com.pattern.principle.dip;

/*
 * @author：jinsheng
 * @date：2023/03/05 16:01
 */
public class Client {

    public static void main(String[] args) {
        IDriver zhangSan = new Driver();
        ICar benz = new Benz();

        zhangSan.driver(benz);
    }
}
