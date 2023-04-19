package com.pattern.principle.lod;

/*
 * @author：jinsheng
 * @date：2023/03/05 17:09
 */
public class Teacher {
    /**
     * 发布命令，清点女生
     * @param groupLeader
     */
    public void commond(GroupLeader groupLeader){
        groupLeader.countGirls();
    }
}
