package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        String str = "23";
        System.out.println(JSON.toJSONString(letterCombinations(str)));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return list;
        }

        Map<Character, List<Character>> map = new HashMap<>();
        initBaseMap(map);

        recurse(digits, list, "", map, 0);

        return list;
    }

    private static  void recurse(String digits, List<String> result, String temp, Map<Character, List<Character>> map, int index){
        if(index == digits.length()){
            result.add(temp);
        }else {
            List<Character> chars = map.get(digits.charAt(index));
            for(int i = 0; i < chars.size(); i++){
                recurse(digits, result, temp + chars.get(i), map, index + 1);
            }
        }

    }

    private static void initBaseMap(Map<Character, List<Character>> map) {
        char[] chars = {'2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 0; i < chars.length; i++) {
            char val = chars[i];
            List<Character> itemList = new ArrayList<>();
            switch (val) {
                case '2':
                    itemList.add('a');
                    itemList.add('b');
                    itemList.add('c');
                    map.put(val, itemList);
                    break;
                case '3':
                    itemList.add('d');
                    itemList.add('e');
                    itemList.add('f');
                    map.put(val, itemList);
                    break;
                case '4':
                    itemList.add('g');
                    itemList.add('h');
                    itemList.add('i');
                    map.put(val, itemList);
                    break;
                case '5':
                    itemList.add('j');
                    itemList.add('k');
                    itemList.add('l');
                    map.put(val, itemList);
                    break;
                case '6':
                    itemList.add('m');
                    itemList.add('n');
                    itemList.add('o');
                    map.put(val, itemList);
                    break;
                case '7':
                    itemList.add('p');
                    itemList.add('q');
                    itemList.add('r');
                    itemList.add('s');
                    map.put(val, itemList);
                    break;
                case '8':
                    itemList.add('t');
                    itemList.add('u');
                    itemList.add('v');
                    map.put(val, itemList);
                    break;
                case '9':
                    itemList.add('w');
                    itemList.add('x');
                    itemList.add('y');
                    itemList.add('z');
                    map.put(val, itemList);
                    break;
            }
        }
    }

}
