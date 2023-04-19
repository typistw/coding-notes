package com.pattern.principle.isp;

/*
 * @author：jinsheng
 * @date：2023/03/04 23:09
 */
public class AUG extends Rifle{

    public void zoomOut(){
        System.out.println("通过望远镜观察敌人");
    }

    @Override
    public void shoot(){
        System.out.println("AUG射击...");
    }
}
