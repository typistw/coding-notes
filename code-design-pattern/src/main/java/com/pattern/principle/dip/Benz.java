package com.pattern.principle.dip;

/*
 * @author：jinsheng
 * @date：2023/03/05 15:59
 */
public class Benz implements ICar{

    @Override
    public void run() {
        System.out.println("奔驰汽车开始运行...");
    }
}
