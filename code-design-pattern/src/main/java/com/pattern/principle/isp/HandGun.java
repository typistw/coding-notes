package com.pattern.principle.isp;

/*
 * @author：jinsheng
 * @date：2023/03/04 16:40
 */
public class HandGun extends AbstractGun{

    @Override
    public void shoot() {
        System.out.println("手枪射击...");
    }
}
