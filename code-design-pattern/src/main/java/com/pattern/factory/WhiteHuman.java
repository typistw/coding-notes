package com.pattern.factory;

/*
 * @author：jinsheng
 * @date：2023/04/09 15:54
 */
public class WhiteHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("白色人种的皮肤是白色的");
    }

    @Override
    public void talk() {
        System.out.println("白色人种会说话，一般都是单字节");
    }
}
