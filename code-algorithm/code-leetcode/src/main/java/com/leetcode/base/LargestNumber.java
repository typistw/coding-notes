package com.leetcode.base;

import java.util.*;

/**
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {16,128,12};
        int[] nums2 = {3, 30, 34, 5, 9};
        int[] nums3 = {9682,928};
        int[] nums4 = {8247,824};
        System.out.println(largestNumber(nums));
        System.out.println(largestNumber(nums2));
        System.out.println(largestNumber(nums3));
        System.out.println(largestNumber(nums4));
    }

    public static String largestNumber(int[] nums) {
       HashMap< Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ;i < nums.length; i++){
            int val = nums[i], prefixVal = val;
            while (prefixVal > 9){
                prefixVal /= 10;
            }

            if(map.containsKey(prefixVal)){
                List<Integer> list = map.get(prefixVal);
                sort(list, val);
            }else{
                List<Integer> tempList = new ArrayList<>();
                tempList.add(val);
                map.put(prefixVal, tempList);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            List<Integer> list = map.get(i);

            if(list != null && !list.isEmpty()){
                if(i == 0 && sb.length() == 0){
                    sb.append(0);
                    break;
                }

                for(Integer val : list){
                    sb.append(val);
                }
            }
        }
        return sb.toString();
    }

    private static void sort(List<Integer> list, int val){
        for(int i = 0; i < list.size(); i ++){
            int tempVal = list.get(i);
            int tempLength = String.valueOf(tempVal).length(), valLength = String.valueOf(val).length();

            if(tempLength == valLength ){
                if(val >= tempVal){
                    list.add(i, val);
                    return;
                }else{
                    continue;
                }
            }

            String longStr =  String.valueOf(Math.max(tempVal, val));
            String sortStr  = String.valueOf(Math.min(tempVal, val));

            int index = sortStr.length();
            boolean hasLongMaxSort = false;
            //  last char
            char compareChar = sortStr.charAt(index - 1);
            boolean hasCompareLast = false;

            for(int j = 0; j < sortStr.length(); j++){
                if(longStr.charAt(j) > sortStr.charAt(j)){
                    hasLongMaxSort = true;
                    break;
                }

                if(longStr.charAt(j) < sortStr.charAt(j)){
                    break;
                }

                if( j == sortStr.length() - 1 && longStr.charAt(j) == sortStr.charAt(j) ){
                    hasCompareLast = true;
                }
            }

            //  sortStr last char compare longStr char
            if(!hasLongMaxSort && hasCompareLast){
                if(compareChar < longStr.charAt(index) && longStr.charAt(index) > longStr.charAt(0)){
                    hasLongMaxSort = true;
                }
            }


            if(hasLongMaxSort){
                if(valLength > tempLength){
                    list.add(i, val);
                    return;
                }
            }else{
                if(valLength < tempLength){
                    list.add(i, val);
                    return;
                }
            }

        }

        list.add(val);
    }
}
