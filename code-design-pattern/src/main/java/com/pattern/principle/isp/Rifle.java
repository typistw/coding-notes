package com.pattern.principle.isp;

/*
 * @author：jinsheng
 * @date：2023/03/04 16:42
 */
public class Rifle extends AbstractGun{

    @Override
    public void shoot() {
        System.out.println("步枪射击...");
    }
}
