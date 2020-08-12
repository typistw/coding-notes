package com.leetcode.challenge.twenty.august.weektwo;

/**
 *Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 *
 * Example:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 *              received 3, 0, 6, 1, 5 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class HIndx {

    public static void main(String[] args) {
        int[] nums = {3,0,6,1,5};
        int[] nums2 = {};
        int[] nums3 = {0};
        int[] nums4 = {0, 0};
        int[] nums5 = {100};
        int[] nums6 = {11, 15};
        int[] nums7 = {1, 2};
        int[] nums8 = {0, 1, 1};
        int[] nums9 = {1, 2, 2};
        int[] nums10 = {1, 1, 1};
        int[] nums11 = {6,3,10,8,2,10,3,5,10,5,3};
        System.out.println(hIndex(nums));
        System.out.println(hIndex(nums2));
        System.out.println(hIndex(nums3));
        System.out.println(hIndex(nums4));
        System.out.println(hIndex(nums5));
        System.out.println(hIndex(nums6));
        System.out.println(hIndex(nums7));
        System.out.println(hIndex(nums8));
        System.out.println(hIndex(nums9));
        System.out.println(hIndex(nums10));
        System.out.println(hIndex(nums11));
    }

    public static int hIndex(int[] citations) {
        if(citations.length == 0 )
            return 0;

        int[] tempArr = new int[citations.length];
        for(int i = 0; i < citations.length; i++){
            int val = citations[i];
            if(i == 0){
                tempArr[i] = val;
            }else{
                int insetIndx = i;
                for(int j = i - 1; j >=0; j--){
                    if(val > tempArr[j]){
                        tempArr[j + 1] = tempArr[j];
                        insetIndx = j;
                    }
                }
                tempArr[insetIndx] = val;
            }
        }

       int index = 0;
        for(; index < tempArr.length; index ++){
            if(tempArr[index] <= index){
                break;
            }
        }

        return  index;
    }
}
