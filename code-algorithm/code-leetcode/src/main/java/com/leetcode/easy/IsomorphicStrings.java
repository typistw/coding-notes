package com.leetcode.easy;

import java.util.*;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "egg", t = "add";
        String s2 = "foo", t2 = "bar";
        String s3 = "paper", t3 = "title";
        String s4 = "ab", t4 = "aa";
        System.out.println(isIsomorphic(s, t) + " : " + isIsomorphicTwo(s, t));
        System.out.println(isIsomorphic(s2, t2)+ " : " + isIsomorphicTwo(s2, t2));
        System.out.println(isIsomorphic(s3, t3)+ " : " + isIsomorphicTwo(s3, t3));
        System.out.println(isIsomorphic(s4, t4)+ " : " + isIsomorphicTwo(s4, t4));
    }

    public static boolean isIsomorphic(String s, String t) {
        List<Character> listCharS = new ArrayList<>();
        List<Character> listCharT = new ArrayList<>();

        List<Integer> listCountS = new ArrayList<>();
        List<Integer> listCountT =  new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char valS = s.charAt(i);
            char valT = t.charAt(i);

            updateOrderIndexAndCount(listCharS, listCountS, valS);
            updateOrderIndexAndCount(listCharT, listCountT, valT);

            int idxS = listCharS.indexOf(valS);
            int idxT = listCharT.indexOf(valT);
            if ( idxS != idxT ||  !listCountS.get(idxS).equals(listCountT.get(idxT)) ) {
                return false;
            }

        }
        return true;
    }

    public static boolean isIsomorphicTwo(String s, String t){
        int length = s.length();
        int[] arrayS = new int[256];
        int[] arrayT = new int[256];

        for(int i = 0; i < length; i++){
            if(arrayS[s.charAt(i)] != arrayT[t.charAt(i)]){
                return  false;
            }

            arrayS[s.charAt(i)] = arrayT[t.charAt(i)] = i + 1;
        }
        return true;
    }

    private static void updateOrderIndexAndCount(List<Character> characterList, List<Integer> countList, char c){
        if(characterList.contains(c)){
            int index  = characterList.indexOf(c);
            int count = countList.get(index) + 1;
            countList.add(index, count);
        }else{
            characterList.add(c);
            countList.add(0);
        }
    }

}
