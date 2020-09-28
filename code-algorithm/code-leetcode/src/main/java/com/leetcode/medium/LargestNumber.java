package com.leetcode.medium;

import java.util.*;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * Example 1:
 * <p>
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 * <p>
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {16, 128, 12};
        int[] nums2 = {3, 30, 34, 5, 9};
        int[] nums3 = {9682, 928};
        int[] nums4 = {8247, 824};
        int[] nums5 = {2281, 2};
        int[] nums6 = {216, 2};
        int[] nums7 = {8831, 8};
        System.out.println(largestNumber(nums));
        System.out.println(largestNumber(nums2));
        System.out.println(largestNumber(nums3));
        System.out.println(largestNumber(nums4));
        System.out.println(largestNumber(nums5));
        System.out.println(largestNumber(nums6));
        System.out.println(largestNumber(nums7));
    }

    public static String largestNumber(int[] nums) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            List<String> tempList = new ArrayList<>();
            map.put(i, tempList);
        }

        for (int i = 0; i < nums.length; i++) {
            String val = String.valueOf(nums[i]);
            int prefixVal = val.charAt(0) - '0';
            List<String> list = map.get(prefixVal);
            sort(list, val);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            List<String> list = map.get(i);

            if (list != null && !list.isEmpty()) {
                if (i == 0 && sb.length() == 0) {
                    sb.append(0);
                    break;
                }

                for (String val : list) {
                    sb.append(val);
                }
            }
        }
        return sb.toString();
    }

    private static void sort(List<String> list, String val) {
        /*
        * String s1 = "9";
         String s2 = "31";
        String case1 =  s1 + s2; // 931
        String case2 = s2 + s1; // 319
        case1 is greater than case2
        * */
        for (int i = 0; i < list.size(); i++) {
            String str1 = val + list.get(i);
            String str2 = list.get(i) + String.valueOf(val);
            if (str1.compareTo(str2) > 0) {
                list.add(i, val);
                return;
            }
        }

        list.add(val);
    }
}
