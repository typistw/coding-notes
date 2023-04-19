package com.pattern.principle.lod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * @author：jinsheng
 * @date：2023/03/05 17:12
 */
public class Client {

    public static void main(String[] args) {
        List<Girl> listGirls = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            listGirls.add(new Girl());
        }

        Teacher teacher = new Teacher();
        teacher.commond(new GroupLeader(listGirls));

    }
}
