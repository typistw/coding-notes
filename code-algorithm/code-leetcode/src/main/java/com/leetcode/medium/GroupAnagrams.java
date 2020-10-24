package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lower-case English letters.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs2 = {""};
        String[] strs3 = {"a"};
        System.out.println(JSON.toJSONString(groupAnagrams(strs)) + " : " + JSON.toJSONString(groupAnagrams2(strs)));
        System.out.println(JSON.toJSONString(groupAnagrams(strs2)) + " : " + JSON.toJSONString(groupAnagrams2(strs2)));
        System.out.println(JSON.toJSONString(groupAnagrams(strs3)) + " : " + JSON.toJSONString(groupAnagrams2(strs3)));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i ++){
            int size = strs[i].length();
            if(map.containsKey(size)){
                map.get(size).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(size, list);
            }
        }

        List<List<String>> retList = new ArrayList<>();
        for(Integer key : map.keySet()){
            List<String> itemList = map.get(key);

            while (!itemList.isEmpty()){
                Iterator iterator = itemList.iterator();
                String word = (String) iterator.next();
                iterator.remove();
                List<String> list = new ArrayList<>();
                list.add(word);

                Iterator tempIterator = itemList.iterator();
                while (tempIterator.hasNext()){
                    int[] array = initArray(word);
                    String tempWord = (String) tempIterator.next();
                    boolean isAnagram = true;
                    for(int i = 0 ; i < tempWord.length(); i++){
                        int idx = tempWord.charAt(i) - 'a';
                        array[idx] -= 1;
                        if(array[idx] < 0){
                            isAnagram = false;
                            break;
                        }
                    }

                    if(isAnagram){
                        list.add(tempWord);
                        tempIterator.remove();
                    }
                }

                retList.add(list);
            }
        }

        return retList;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0 ; i < strs.length; i++){
            int[] arr = new int[26];
            String str = strs[i];
            for(int j = 0; j < str.length(); j++){
                arr[str.charAt(j) - 'a'] += 1;
            }

            String strKey = Arrays.toString(arr);
            if(map.containsKey(strKey)){
                map.get(strKey).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(strKey, list);
            }
        }

        return new ArrayList<>(map.values());
    }

    private static int[] initArray(String word){
        int[] array = new int[26];
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            array[idx] += 1;
        }

        return array;
    }

}
