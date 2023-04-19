package com.pattern.principle.lod;

import java.util.List;

/*
 * @author：jinsheng
 * @date：2023/03/05 17:09
 */
public class GroupLeader {
    private List<Girl> listGirl;

    public GroupLeader(List<Girl> listGirl){
        this.listGirl = listGirl;
    }

    public void countGirls(){
        System.out.println("女生人数是：" + this.listGirl.size());
    }
}
