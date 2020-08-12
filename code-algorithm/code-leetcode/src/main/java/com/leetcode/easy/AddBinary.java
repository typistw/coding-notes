package com.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: jinsheng.wei
 * @Description:
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int minSize = Math.min(a.length(), b.length());
        List<Character> list = new LinkedList<>();

        boolean hasAdvance = false;
        char zeroChar = '0', ontChar = '1';
        for(int i = minSize - 1; i >= 0; i++){
            int val = a.charAt(i) ;
            int val2 = b.charAt(i);

            if(val == zeroChar && val2 == zeroChar){
                if(hasAdvance){
                    list.add(ontChar);
                }else{
                    list.add(zeroChar);
                }
                hasAdvance = false;
            }else if(val ==  ontChar && val2 == ontChar){
                hasAdvance = true;
                list.add(zeroChar);
            }else{
                if(hasAdvance){
                    list.add(zeroChar);
                }else{
                    list.add(ontChar);
                    hasAdvance = false;
                }
            }
        }



        StringBuilder sb = new StringBuilder();
        return "";
    }


}
