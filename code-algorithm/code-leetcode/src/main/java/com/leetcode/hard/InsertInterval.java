package com.leetcode.hard;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}}, intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}}, intervals3 ={{1,4}, {9,12},{19,22}}, intervals4= {{1,5}, {9, 12}},
            intervals5= {{3,5}, {12 ,15}};
        int[] newInterval = {2,5}, newInterval2 = {4, 8}, newInterval3 ={7,13}, newInterval4 = {0,4}, newInterval5 ={6,6};

        System.out.println(JSON.toJSONString(insert(intervals,newInterval)));
        System.out.println(JSON.toJSONString(insert(intervals2,newInterval2)));
        System.out.println(JSON.toJSONString(insert(intervals3,newInterval3)));
        System.out.println(JSON.toJSONString(insert(intervals4,newInterval4)));
        System.out.println(JSON.toJSONString(insert(intervals5,newInterval5)));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<Integer[][]> list = new ArrayList<>();
        int min = newInterval[0], max = newInterval[1];
        int mergeIndex = -1;
        Integer[][] mergeInterval = new Integer[1][2];
        mergeInterval[0][0] = min;
        mergeInterval[0][1] = max;

        boolean hasInterval = false;
        int rows = intervals.length;
        for(int i = 0; i < rows; i++){
            boolean hasRecode = false;
            if(intervals[i].length == 0)
                continue;

            int first = intervals[i][0], secondly = intervals[i][1];
            Integer[][] tempArr = new Integer[1][2];

            if(first <= min &&  min <= secondly){
                mergeIndex = i;
                mergeInterval[0][0] = first;
            }

            if(i == rows - 1 ){
                if(secondly > max && !hasInterval){
                    mergeInterval[0][1] = secondly;
                }
            }

            if( first >= max && !hasInterval){
                if(first > max){
                    if(i != 0)
                       mergeInterval[0][1] = Math.max(intervals[i-1][1], max);
                    else
                        mergeInterval[0][1] = max;
                }else{
                    mergeInterval[0][1] = secondly;
                }

                hasInterval = true;

            }

            if( secondly < min || first > max){
                hasRecode = true;
            }

            if(mergeIndex == -1 && first >= max){
                mergeIndex =  i;
                if(i != 0 && (intervals[i-1][1] >= max || (intervals[i-1][0] > min && intervals[i-1][1] <= max)) ){
                    mergeIndex =  i - 1;
                }
            }

            if(hasRecode ){
                tempArr[0][0] = first;
                tempArr[0][1] = secondly;
                list.add(tempArr);
            }

        }

        if(mergeIndex == -1){
            list.add(mergeInterval);
        }else{
            list.add(mergeIndex, mergeInterval);
        }

        int[][] retArray = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            Integer[][] temp = list.get(i);
            retArray[i][0] = temp[0][0];
            retArray[i][1] = temp[0][1];
        }

        return retArray;
    }

}
