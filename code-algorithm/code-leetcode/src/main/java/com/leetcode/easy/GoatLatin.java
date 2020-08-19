package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 *
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 *
 *
 * Example 1:
 *
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 *
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 *
 * Notes:
 *
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class GoatLatin {

    public static void main(String[] args) {
        String str = "I speak Goat Latin";
        String str2 = "The quick brown fox jumped over the lazy dog";
        System.out.println(toGoatLatin(str));
        System.out.println(toGoatLatin(str2));
    }

    public static String toGoatLatin(String S) {
        if (S == null || S.equals("")) {
            return S;
        }

        String[] baseNums = {"a", "ma"};
        List<Character> characters = new ArrayList<Character>() {{
            add('a');
            add('i');
            add('o');
            add('u');
            add('e');
            add('A');
            add('I');
            add('O');
            add('U');
            add('E');
        }};

        StringBuilder sb  = new StringBuilder();
        String[] strArray = S.split(" ");
        for(int i = 0 ; i < strArray.length; i++){
            String itemStr = strArray[i];
            if(characters.contains(itemStr.charAt(0))){
                sb.append(itemStr);
            }else{
                char firstChar =  itemStr.charAt(0);
                itemStr = itemStr.substring(1);
                sb.append(itemStr).append(firstChar);
            }

            sb.append(baseNums[1]);

            int loop = i + 1;
            while (loop > 0){
                sb.append(baseNums[0]);
                loop -- ;
            }

            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


}
