package com.pattern.factory;

/*
 * @author：jinsheng
 * @date：2023/04/09 15:52
 */
public class YellowHuman implements Human{

    @Override
    public void getColor() {
        System.out.println("黄色人种的皮肤是黄色的");
    }

    @Override
    public void talk() {
        System.out.println("黄色人种会说话，一般说的都是双字节");
    }
}
