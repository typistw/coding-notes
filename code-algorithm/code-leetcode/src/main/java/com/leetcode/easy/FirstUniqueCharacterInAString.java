package com.leetcode.easy;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.


Note: You may assume the string contains only lowercase English letters.
 *
 * @author：jinsheng
 */
public class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String s = "leetcode", s2 = "loveleetcode";
        System.out.println(firstUniqChar(s));
        System.out.println(firstUniqChar(s2));
    }

    public static int firstUniqChar(String s) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        Map<Integer, Integer> mapIdx = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++){
            int key = s.charAt(i) - 'a';
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key, 1);
                mapIdx.put(key, i);
            }
        }

        for(Map.Entry item : map.entrySet()){
            int value = (int)item.getValue();
            if (value == 1){
                return mapIdx.get(item.getKey());
            }
        }
        return  -1;
    }
}
