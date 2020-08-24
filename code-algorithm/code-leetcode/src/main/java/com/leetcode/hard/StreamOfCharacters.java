package com.leetcode.hard;

import java.util.*;

/**
 * Implement the StreamChecker class as follows:
 *
 * StreamChecker(words): Constructor, init the data structure with the given words.
 * query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
 *
 *
 * Example:
 *
 * StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
 * streamChecker.query('a');          // return false
 * streamChecker.query('b');          // return false
 * streamChecker.query('c');          // return false
 * streamChecker.query('d');          // return true, because 'cd' is in the wordlist
 * streamChecker.query('e');          // return false
 * streamChecker.query('f');          // return true, because 'f' is in the wordlist
 * streamChecker.query('g');          // return false
 * streamChecker.query('h');          // return false
 * streamChecker.query('i');          // return false
 * streamChecker.query('j');          // return false
 * streamChecker.query('k');          // return false
 * streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 *
 *
 * Note:
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 2000
 * Words will only consist of lowercase English letters.
 * Queries will only consist of lowercase English letters.
 * The number of queries is at most 40000.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class StreamOfCharacters {

    public static void main(String[] args) {
        StreamOfCharacters streamOfCharacters = new StreamOfCharacters(new String[]{"cd", "f", "kl"});
        System.out.println(streamOfCharacters.query('a'));
        System.out.println(streamOfCharacters.query('b'));
        System.out.println(streamOfCharacters.query('c'));
        System.out.println(streamOfCharacters.query('d'));
        System.out.println(streamOfCharacters.query('e'));
        System.out.println(streamOfCharacters.query('f'));
        System.out.println(streamOfCharacters.query('g'));
        System.out.println(streamOfCharacters.query('h'));
        System.out.println(streamOfCharacters.query('i'));
        System.out.println(streamOfCharacters.query('j'));
        System.out.println(streamOfCharacters.query('k'));
        System.out.println(streamOfCharacters.query('l'));

    }

    private Map<Integer, List<String>> wordLengthMap = new HashMap<>();
    private Map<Character, Set<Integer>> lastCharMap = new HashMap<>();
    private StringBuilder sb = new StringBuilder();
    private int wordMaxSize = 0;

    public StreamOfCharacters(String[] words) {
        for(int i = 0; i < words.length; i++){
            String str = words[i];
            int length = str.length();
            char lastChar = str.charAt(length - 1);

            if(wordLengthMap.containsKey(length)){
                wordLengthMap.get(length).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                wordLengthMap.put(length, list);
            }

            if(lastCharMap.containsKey(lastChar)){
                lastCharMap.get(lastChar).add(length);
            }else{
                Set<Integer> set = new TreeSet<>();
                set.add(length);
                lastCharMap.put(lastChar , set);
            }

            wordMaxSize = Math.max(wordMaxSize, str.length());
        }
    }



    public boolean query(char letter) {
        sb.append(letter);
        if(sb.length() > wordMaxSize){
            sb.deleteCharAt(0);
        }

        if(!lastCharMap.containsKey(letter)) {
            return false;
        }

        Set<Integer> lengthSet = lastCharMap.get(letter);
        for(Integer length : lengthSet){
            if(sb.length() < length)
                continue;

            String itemStr = sb.toString().substring(sb.length() - length);
            if(wordLengthMap.get(length).contains(itemStr))
                return true;
        }
        return false;
    }

}
