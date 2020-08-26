package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(generateParenthesis(3)));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n > 0){
            generateOneByOne("", list, n , n);
        }

        return  list;
    }

    private static void generateOneByOne(String subStr, List<String> list, int left,int right){
        if(left > right)
            return;

        if(left > 0){
            generateOneByOne(subStr +"(", list, left - 1, right);
        }
        if(right > 0){
            generateOneByOne(subStr +")", list, left, right -1);
        }

        if(left == 0 &&  right == 0){
            list.add(subStr);
            return;
        }
    }

}
