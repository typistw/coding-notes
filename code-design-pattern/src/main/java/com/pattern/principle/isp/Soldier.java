package com.pattern.principle.isp;

/*
 * @author：jinsheng
 * @date：2023/03/04 21:59
 */
public class Soldier {

    private AbstractGun gun;

    public void setGun(AbstractGun gun){
        this.gun = gun;
    }

    public void killEnemy(){
        System.out.println("士兵开始杀人");
        gun.shoot();
    }
}
