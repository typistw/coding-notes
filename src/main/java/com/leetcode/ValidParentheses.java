package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * 描述：
 *     给定一个仅包含 '(', ')', '{' , '}', '[', ']' 的字符串，判定输入的字符串是否有效
 *     有效字符串定义如下：
 *     1、打开的括号必须被相对应的括号关闭
 *     2、打开的括号必须被正确的关闭
 *  example 1:
 *      input: "()"
 *      output : tru
 *  example 2:
 *      input: "()[]{}"
 *      output: true
 *  example 3:
 *      input: "(]"
 *      output false
 *  example 4:
 *      input: "([)]"
 *      output: false
 *  example 5:
 *      input: "{[]}"
 *      output: true
 *
 * @author：jinsheng
 * @date：2019/04/20 13:36
 */
public class ValidParentheses {

    private static Map<Character, Integer> prefixMap = new HashMap<Character, Integer>() {{
        put('(', 1);
        put('{', 2);
        put('[', 3);
    }};

    private static Map<Character, Integer> suffixMap = new HashMap<Character, Integer>() {{
        put(')', 1);
        put('}', 2);
        put(']', 3);
    }};

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    private static boolean isValid(String s) {
        if (null == s || s.equals(""))
            return true;

        char[] characters = s.toCharArray();
        // 关闭符合在第一个， 直接返回
        if(suffixMap.containsKey(characters[0])) {
            return false;
        }

        Stack<Character> characterStack = new Stack<>();
        characterStack.push(characters[0]);

        boolean hasValid = true;
        for (int i = 1; i < characters.length; i++) {
            // 如果是关闭符号，则与栈顶的元素做匹配， 否则入栈
            if (suffixMap.containsKey(characters[i])){
                // 栈为null， 遇到关闭字符，false
                if(characterStack.isEmpty()){
                    hasValid = false;
                    break;
                }

                char target = characterStack.pop();
                // 关闭符号与栈顶不匹配， false
                if(!suffixMap.get(characters[i]).equals(prefixMap.get(target))){
                    hasValid = false;
                    break;
                }
            }else{
                characterStack.add(characters[i]);
            }
        }

        // 完全匹配栈将为空栈
        if(hasValid && characterStack.isEmpty())
            return  true;

        return false;
    }

}
