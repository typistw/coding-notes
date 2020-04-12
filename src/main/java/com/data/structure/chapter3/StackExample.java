package com.data.structure.chapter3;

import org.springframework.util.StringUtils;

import java.util.*;

/*
 * @author：jinsheng
 * @date：2020/04/12 10:21
 */
public class StackExample {

    private static final List<Character> OPEN_SYMBOL_LIST = new ArrayList<Character>(){{
       add('(');
       add('[');
    }};

     private static final List<Character> CLOSE_SYMBOL_LIST = new ArrayList<Character>(){{
       add(')');
       add(']');
    }};

     private static  final Map<Character, Character> CLOSE_TO_OPEN_SYMBOL_MAP = new HashMap<Character, Character>(){{
        put(']', '[');
        put(')', '(');
     }};

    /**
     *  运算符号(包含优先级符号)
     */
     private static final List<Character> CALCULATING_SING_LIST = new ArrayList<Character>(){{
         add('+');
         add('-');
         add('*');
         add('/');
         add('(');
         add(')');
     }};

     private static final Character CALCULATING_SING_SPCIAL_OPEN_LIST = '(';

      private static final Character CALCULATING_SING_SPECIAL_CLOSE_LIST = ')';

    /**
     * 运算符优先级权重（数字越大权重越高）
     */
     private static final Map<Character,Integer> CALCULATING_SING_WEIGHT_MAP = new HashMap<Character, Integer>(){{
         put('+', 1);
         put('-', 1);
         put('*', 2);
         put('/', 2);
         put('(', 3);
         put(')', 3);
    }};

    /**
     * 平衡符号检测:
     *   1、做一个空栈， 读入字符直到文件末尾
     *   2、字符是一个开发符号('(', '[')，则推入栈中
     *   3、若字符是一个封闭符号(')', ']')：
     *      当栈空时报错
     *      否则，将栈顶元素弹出， 弹出的符号不是对应的开放符号，报错
     *   4、在文件末尾， 如果栈非空则报错
     *
     * @param val
     * @return
     */
    public static boolean checkBalanceSymbol(String val){
        if(StringUtils.isEmpty(val))
            return  false;

        Stack<Character> stack = new Stack<>();
        char[] charArr = val.toCharArray();
        for(int i = 0; i < charArr.length; i++){
            char currentlyChar =  charArr[i];
            if(OPEN_SYMBOL_LIST.contains(currentlyChar)){
                stack.push(currentlyChar);
            }

            if(CLOSE_SYMBOL_LIST.contains(currentlyChar)){
                if(stack.isEmpty())
                    return false;

                // 获取栈顶开放符号
                char openChar = stack.pop();
                // 通过开封闭符号获取开放符号
                char expectOpenChar = CLOSE_TO_OPEN_SYMBOL_MAP.get(currentlyChar);
                if(expectOpenChar != openChar){
                    return  false;
                }
            }
        }

        // 此处正确的情况栈中元素应该完全出栈
        if(stack.isEmpty())
            return true;

        return false;
    }

    /**
     * 标准表达式(或叫中缀表达式)转后缀表达式:
     *  1、读到一个操作数，直接放到输出中， 操作符入栈
     *  2、操作符入栈时， 若优先级低于或等于栈顶的优先级， 需要弹出栈顶符号(例外：除非是在处理一个')'符号时， 否则绝不从栈中移走'('符号)
     *  3、读到一个')'， 弹出栈顶元素直到'('（包含在弹出元素内） ， 括号丢弃， 不会放入输出中
     * @param expression
     * @return
     */
    public static String infixToPostfix(String expression){
        if(StringUtils.isEmpty(expression))
            return  expression;

        char[] charArr = expression.toCharArray();
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < charArr.length; i++){
            char tempItem  = charArr[i];
            if(CALCULATING_SING_LIST.contains(tempItem)){
                if(stack.isEmpty()){
                    stack.push(tempItem);
                }else{
                    char topChar;
                    // 括号操作符特殊处理
                    if(CALCULATING_SING_SPCIAL_OPEN_LIST == tempItem){
                        // 左侧括号符， 直接入栈
                        stack.push(tempItem);
                        continue;
                    }

                    if(CALCULATING_SING_SPECIAL_CLOSE_LIST == tempItem){
                        while (true){
                            // 右侧括号符，弹出栈顶元素到输出中， 直到左侧括号符(包含在弹出元素中, 不在输出数中)
                            topChar = stack.pop();
                            if(CALCULATING_SING_SPCIAL_OPEN_LIST == topChar){
                                break;
                            }else{
                                builder.append(topChar);
                            }
                        }
                        continue;
                    }

                    while (true){
                        // 比较当前操作符与栈顶操作符权重
                        topChar = stack.peek();

                        // 除非正在处理闭括号， 否则开括号不会从栈中弹出
                        if(topChar == CALCULATING_SING_SPCIAL_OPEN_LIST){
                            stack.push(tempItem);
                            break;
                        }

                        if(CALCULATING_SING_WEIGHT_MAP.get(tempItem) <= CALCULATING_SING_WEIGHT_MAP.get(topChar)){
                            // 当前小于等于栈顶操作符的优先级，出栈（即入栈的操作符优先级要大于栈顶的）
                            topChar = stack.pop();
                            builder.append(topChar);
                        }else{
                            stack.push(tempItem);
                            break;
                        }

                        if(stack.isEmpty()){
                            stack.push(tempItem);
                            break;
                        }

                    }
                }
            }else{
                builder.append(tempItem);
            }
        }

        while (!stack.isEmpty()){
            builder.append(stack.pop());
        }

        return  builder.toString();
    }

    /**
     * 后缀表达式计算
     *  1、遇到一个数入栈
     *  2、遇到一个计算符号，从栈中弹出两个数， 符号用于作用于两个数(第一个数， 符号，第二个数),结果入栈
     * @return
     */
    public static int postfixCalculating(String fixVal){
        char[] chaArr = fixVal.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < chaArr.length; i++){
            char tempChar = chaArr[i];
            if(CALCULATING_SING_LIST.contains(tempChar)){
                 int numX = stack.pop();
                 int numY = stack.pop();
                 int numZ = 0;
                 switch (tempChar){
                     case '+':
                         numZ = numX + numY;
                         break;
                     case '-':
                         numZ = numX - numY;
                         break;
                     case '*':
                         numZ = numX * numY;
                         break;
                     case '/':
                         numZ = numX / numY;
                         break;
                 }
                 stack.push(numZ);
            }else{
                int tempNUm = Character.getNumericValue(tempChar);
                stack.push(tempNUm);
            }
        }
        return stack.pop();
    }
}
