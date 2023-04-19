package com.pattern.principle.dip;

/*
 * @author：jinsheng
 * @date：2023/03/05 16:00
 */
public class BMW implements ICar{

    @Override
    public void run() {
        System.out.println("宝马汽车开始运行...");
    }
}
