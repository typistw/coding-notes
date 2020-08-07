package com.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: jinsheng.wei
 * @Date: 2020/8/7 10:37
 * @Description:
 */
public class TestDaliy {

    @Test
    public void executeTest(){
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(JSON.toJSONString(findDuplicates(nums)));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) {
                list.add(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        return  list;
    }

}
