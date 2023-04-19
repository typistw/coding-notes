package com.pattern.principle.isp;

/*
 * @author：jinsheng
 * @date：2023/03/04 16:43
 */
public class MachineGun extends AbstractGun{
    @Override
    public void shoot() {
        System.out.println("机枪扫射...");
    }
}
