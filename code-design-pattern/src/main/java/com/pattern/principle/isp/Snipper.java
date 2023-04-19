package com.pattern.principle.isp;

/*
 * @author：jinsheng
 * @date：2023/03/04 23:11
 */
public class Snipper {

    private AUG aug;

    public void setGun(AUG aug){
        this.aug = aug;
    }

    public void killEnemy(){
        this.aug.zoomOut();
        this.aug.shoot();
    }
}
