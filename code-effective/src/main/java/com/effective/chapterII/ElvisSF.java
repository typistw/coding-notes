package com.effective.chapterII;

/*
 * 静态方法实现单实例
 * @author：jinsheng
 * @date：2022/08/14 17:53
 */
public class ElvisSF {

    private static final ElvisSF INSTANCE = new ElvisSF();

    private ElvisSF(){}

    public static ElvisSF getInstance(){
        return INSTANCE;
    }

    public void leaveTheBuilding(){

    }
}
