package com.leetcode.medium;

/**
 *Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums) + " : " + maxAreaDynamic(nums));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        // 数组索引最为X轴  数组值作为Y轴， 两辆之间的面积计算： x轴值的距离， Y轴取较小值
        for(int x = height.length - 1; x >=0; x--){
            int y = height[x];
            for(int i = x - 1; i >=0; i--){
                int itemX = x - i;
                int itemY = y < height[i] ? y : height[i];
                int currentArea = itemX * itemY;
                maxArea = currentArea > maxArea ? currentArea : maxArea;
            }
        }

        return maxArea;
    }

    /**
     *   双指针法：
     *   面积受限制于较短的行， 两个指针，一个从头一个从尾开始， 每次移动较短方的指针
     * @param height
     * @return
     */
    public static  int maxAreaDynamic(int[] height){
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left <= right){
            int leftVal = height[left], rightVal = height[right];
            int xVal = right - left, yVal = leftVal < rightVal ? leftVal : rightVal;
            int area = xVal * yVal;
            if(leftVal < rightVal){
                left ++;
            }else{
                right --;
            }

            maxArea = area > maxArea ? area : maxArea;
        }
        return  maxArea;
    }

}
