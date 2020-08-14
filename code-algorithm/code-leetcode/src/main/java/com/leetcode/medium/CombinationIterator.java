package com.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 *Design an Iterator class, which has:
 *
 * A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
 * A function next() that returns the next combination of length combinationLength in lexicographical order.
 * A function hasNext() that returns True if and only if there exists a next combination.
 *
 *
 * Example:
 *
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
 *
 * iterator.next(); // returns "ab"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "ac"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "bc"
 * iterator.hasNext(); // returns false
 *
 *
 * Constraints:
 *
 * 1 <= combinationLength <= characters.length <= 15
 * There will be at most 10^4 function calls per test.
 * It's guaranteed that all calls of the function next are valid.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class CombinationIterator {

    public static void main(String[] args) {
        CombinationIterator obj = new CombinationIterator("abc", 2);
//        String param_1 = obj.next();
//        boolean param_2 = obj.hasNext();
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
    }

    private static List<String> queue;

    public CombinationIterator(String characters, int combinationLength) {
        queue = new LinkedList<>();
        getPermutations(new StringBuilder(), combinationLength, 0, characters);
    }

    private static void getPermutations(StringBuilder sb, int target, int idx, String chars) {
        if (sb.length() == target) {
            queue.add(sb.toString());
            return;
        }

        // building up the string here, calling the recursion, and then breaking down the string
        // to get all possible combinations

        for (int i = idx; i < chars.length(); i++) {
            sb.append(chars.charAt(i));
            getPermutations(sb, target,i + 1, chars);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String next() {
        String val = null;
        if(!queue.isEmpty()){
            val = queue.get(0);
            queue.remove(0);
        }
        return val;
    }

    public boolean hasNext() {
        return  !queue.isEmpty();
    }
}
