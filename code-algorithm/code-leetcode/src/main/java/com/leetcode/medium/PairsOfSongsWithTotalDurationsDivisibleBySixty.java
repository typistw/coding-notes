package com.leetcode.medium;

/**
 * You are given a list of songs where the ith song has a duration of time[i] seconds.
 *
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally,
 * we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 *
 * Example 1:
 *
 * Input: time = [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * Example 2:
 *
 * Input: time = [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class PairsOfSongsWithTotalDurationsDivisibleBySixty {

    public static void main(String[] args) {
        int[] nums  = {30,20,150,100,40};
        int[] nums2 = {269,230,318,468,171,158,350,60,287,27,11,384,332,267,412,478,280,303,242,378,129,131,164,467,345,146,264,332,276,479,284,433,117,197,430,203,100,280,145,287,91,157,5,475,288,146,370,199,81,428,278,2,400,23,470,242,411,470,330,144,189,204,62,318,475,24,457,83,204,322,250,478,186,467,350,171,119,245,399,112,252,201,324,317,293,44,295,14,379,382,137,280,265,78,38,323,347,499,238,110,18,224,473,289,198,106,256,279,275,349,210,498,201,175,472,461,116,144,9,221,473};
        System.out.println(numPairsDivisibleBy60(nums));
        System.out.println(numPairsDivisibleBy60(nums2));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        int[] nums = new int[60];
        for(int i = 0;i < time.length; i++){
            int mod = time[i] % 60;
            nums[mod] += 1;
        }

        int count = 0;
        for(int i = 1; i <= 29; i++){
            int pairsIdx = 60 - i;
            if(nums[i] > 0 && nums[pairsIdx] > 0){
                count += nums[i] * nums[pairsIdx];
            }
        }

        if(nums[0] >= 2){
            count += getFactorial(nums[0] - 1);
        }

        if(nums[30] >= 2){
            count += getFactorial(nums[30] - 1);
        }

        return count;
    }

    private static int getFactorial(int n){
        int num = 0;
        for(int i = 1; i <= n; i ++){
            num += i;
        }
        return num;
    }

}
