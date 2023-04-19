package com.pattern.principle.isp;

/*
 * @author：jinsheng
 * @date：2023/03/04 22:51
 */
public class Client {

    public static void main(String[] args) {
        Soldier sanmao = new Soldier();
        // 给士兵一支枪
        sanmao.setGun(new Rifle());
        sanmao.killEnemy();

        // 产生一个狙击手
        Snipper damao = new Snipper();
        damao.setGun(new AUG());
        damao.killEnemy();
    }
}
