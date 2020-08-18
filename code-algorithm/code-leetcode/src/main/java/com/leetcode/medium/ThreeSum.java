package com.leetcode.medium;

import java.util.*;

/**
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {-2, 0, 1, 1, 2};
        int[] nums3 = {1,2, -2, -1};
        System.out.println(threeSum(nums) + " : " + threeSumII(nums));
        System.out.println(threeSum(nums2) + " : " +threeSumII(nums2));
        System.out.println(threeSum(nums3) + " : " + threeSumII(nums3));
    }

    public static  List<List<Integer>> threeSumII(int[] nums){
        Set<List<Integer>> retList = new HashSet<>();
        if(nums == null ||  nums.length == 0)
            return new ArrayList<>(retList);

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                int val = nums[i] + nums[j] + nums[k];
                if(val == 0){
                    List<Integer> itemList = new ArrayList<>();
                    itemList.add(nums[i]);
                    itemList.add(nums[j]);
                    itemList.add(nums[k]);
                    retList.add(itemList);
                    j ++;
                    k--;
                }else if(val > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }

        return new ArrayList<>(retList);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();

        List<Integer> positiveList = new ArrayList<>();
        List<Integer> negativeList = new ArrayList<>();


        Arrays.sort(nums);

        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val < 0) {
                negativeList.add(val);
            } else {
                if(val == 0){
                    zeroCount ++;
                }
                positiveList.add(val);
            }
        }

        List<Integer> twoSumPositiveList = new ArrayList<>();
        List<String> twoPositiveList = new ArrayList<>();
        List<Integer> twoSumNegativeList = new ArrayList<>();
        List<String> twoNegativeList = new ArrayList<>();

        for (int i = 0; i < positiveList.size() - 1; i++) {
            for(int j = i + 1; j < positiveList.size(); j++){
                int val = positiveList.get(i);
                int val2 = positiveList.get(j);

                twoSumPositiveList.add(val + val2);
                twoPositiveList.add( val + "," +val2 );
            }
        }

        for (int i = 0; i < negativeList.size() - 1; i++) {
            for(int j = i + 1; j < negativeList.size(); j++){
                int val = negativeList.get(i);
                int val2 = negativeList.get(j);

                twoSumNegativeList.add(val + val2);
                twoNegativeList.add(val + "," + val2);
            }
        }

        List<String> tripletList = new ArrayList<>();

        for(int j = 0; j < twoSumPositiveList.size(); j++){
            int key = twoSumPositiveList.get(j);

            for(int i = 0; i < negativeList.size(); i++){
                int val = negativeList.get(i);
                if(key + val == 0){
                    StringBuilder sb = new StringBuilder();
                    sb.append(val).append(",");

                    String[] itemArray = twoPositiveList.get(j).split(",");
                    int itemVal = Integer.valueOf(itemArray[0]), itemVAl2 = Integer.valueOf(itemArray[1]);
                    sb.append(Math.min(itemVal, itemVAl2)).append(",");
                    sb.append(Math.max(itemVal, itemVAl2));

                    if(!tripletList.contains(sb.toString())){
                        tripletList.add(sb.toString());
                    }
                }

                if(key + val > 0){
                    break;
                }
            }
        }

        for(int j = 0; j < twoSumNegativeList.size(); j++){
            int key = twoSumNegativeList.get(j);

            for(int i = 0; i < positiveList.size(); i ++){
                int val = positiveList.get(i);
                if(key + val == 0){
                    StringBuilder sb = new StringBuilder();

                    String[] itemArray = twoNegativeList.get(j).split(",");
                    int itemVal = Integer.valueOf(itemArray[0]), itemVAl2 = Integer.valueOf(itemArray[1]);

                    sb.append(Math.min(itemVal, itemVAl2)).append(",");
                    sb.append(Math.max(itemVal, itemVAl2)).append(",");

                    sb.append(val);

                    if(!tripletList.contains(sb.toString())){
                        tripletList.add(sb.toString());
                    }
                }

                if(key + val > 0){
                    break;
                }
            }
        }

       for(String item : tripletList){
           String[] strArry = item.split(",");
           List<Integer> itemList = new ArrayList<>();
           for(int i = 0; i < strArry.length; i++){
               itemList.add(Integer.valueOf(strArry[i]));
           }
           retList.add(itemList);
       }

       if(zeroCount >= 3){
           List<Integer> itemList = new ArrayList<Integer>(){{
               add(0);
               add(0);
               add(0);
           }};
           retList.add(itemList);
       }

       return retList;
    }
}
