package com.leetcode.easy;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 *
 *
 * Constraints:
 *
 * s consists only of printable ASCII characters.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ValidPalindrome {


    public static void main(String[] args) {
        char c = '0', c2 = '9', c3 ='a', c4 ='z' , c5 = 'A', c6 = 'Z';
        String str = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome(str2));

    }

    public  static boolean isPalindrome(String s) {
        if(null == s || s.equals(""))
            return true;

        int left = 0, right = s.length() - 1;
        char[] characters = s.toCharArray();
        while (left < right){
            if(!hasAlphanumeric(characters[left])){
                left ++;
                continue;
            }

            if(!hasAlphanumeric(characters[right])){
                right --;
                continue;
            }

            String leftVal = String.valueOf(characters[left]);
            String rightVal = String.valueOf(characters[right]);
            if(!leftVal.equalsIgnoreCase(rightVal)){
                return  false;
            }

            left ++;
            right --;
        }

        return true;
    }

    private static boolean hasAlphanumeric(char charVal){
        int currnet = Integer.valueOf(charVal);
        if( ( currnet >= 48 && currnet <=57) || ( currnet >= 97 && currnet <= 122) || (currnet >= 65 && currnet <= 90)){
            return true;
        }

        return false;
    }
}
