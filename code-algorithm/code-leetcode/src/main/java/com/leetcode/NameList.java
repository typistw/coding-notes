package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
 * @author：jinsheng
 * @date：2021/03/06 16:02
 */
public class NameList {

    private static List<Character> list = new ArrayList();

    public static void main(String[] args){
        list.add('+');
        list.add('-');
        list.add('*');
        list.add('/');
        list.add('(');
        list.add(')');

        Scanner sc =  new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            Stack<Integer> numStack = new Stack<>();
            Stack<Character> opStack = new Stack<>();

            int left = 0;
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);

                if(!isOperation(c)){
                    if(i == str.length() - 1){
                        int num = Integer.valueOf(str.substring(left));
                        numStack.push(num);
                    }

                    continue;
                }

                String tempStr = str.substring(left, i);
                int num =0;
                if(tempStr.contains("-")){
                    num = 0;
                }else{
                    num = Integer.valueOf(tempStr);
                }
                numStack.push(num);
                left = i + 1;

                if(opStack.isEmpty()){
                    opStack.push(c);
                    continue;
                }

                // )
                if(c == ')'){
                    char temp = opStack.pop();
                    while(temp != '('){
                        int b = numStack.pop();
                        int a = numStack.pop();
                        numStack.push(calculate(a, b, temp));

                        temp = opStack.pop();
                    }

                }


                while (!opStack.isEmpty() && !isPriority(c, opStack.peek())){
                    int b = numStack.pop();
                    int a = numStack.pop();
                    numStack.push(calculate(a, b, opStack.pop()));
                }
                opStack.push(c);
            }

            while(!opStack.isEmpty()){
                char c = opStack.pop();
                int b = numStack.pop();
                int a = numStack.pop();

                int ret = calculate(a, b,c);
                numStack.push(ret);
            }
            System.out.println(numStack.pop());
        }
    }

    private static int calculate(int a , int b, char c){
        int sum = 0;
        switch(c){
            case '+':
                sum = a + b;
                break;
            case '-':
                sum = a - b;
                break;
            case '*':
                sum = a * b;
                break;
            case '/':
                sum = a / b;
                break;
        }
        return sum;
    }

    private static boolean isOperation(char c){
        return list.indexOf(c) >=0 ;
    }

    private static boolean isPriority(char current, char target){
        boolean has = false;
        switch(current){
            case '+':
            case '-':
                break;
            case '*':
            case '/':
                if(target == '+' || target == '-'){
                    has = true;
                }
                break;
            case '(':
                has = true;
                break;

        }

        return has;
    }
}
