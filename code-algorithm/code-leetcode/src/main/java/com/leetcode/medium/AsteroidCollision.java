package com.leetcode.medium;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 *
 *
 * Example 1:
 *
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * Example 2:
 *
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * Example 3:
 *
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 * Example 4:
 *
 * Input: asteroids = [-2,-1,1,2]
 * Output: [-2,-1,1,2]
 * Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same direction never meet, so no asteroids will meet each other.
 *
 *
 * Constraints:
 *
 * 1 <= asteroids <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 *
 * @Auther: jinsheng.wei
 * @Description:
 */
public class AsteroidCollision {

    public static void main(String[] args) {
        int[] asteroids = {5,10,-5};
        int[] asteroids2 = {8,-8};
        int[] asteroids3 = {10,2,-5};
        int[] asteroids4 = {-2, -1,1,2};
        int[] asteroids5 = {-2, -2,1,-2};
        System.out.println(JSON.toJSONString(asteroidCollision(asteroids)));
        System.out.println(JSON.toJSONString(asteroidCollision(asteroids2)));
        System.out.println(JSON.toJSONString(asteroidCollision(asteroids3)));
        System.out.println(JSON.toJSONString(asteroidCollision(asteroids4)));
        System.out.println(JSON.toJSONString(asteroidCollision(asteroids5)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length == 0)
            return asteroids;

        List<Integer> list = new ArrayList<>();
        list.add(asteroids[0]);
        for(int i = 1 ; i < asteroids.length; i++){
            int val = asteroids[i];

            int idx = list.size() - 1;
            if (val < 0 && idx >= 0 && list.get(idx) > 0){
                while (!list.isEmpty()){
                    int preAsteroid = list.get(idx);
                    if(Math.abs(val) == preAsteroid){
                        list.remove(idx);
                        break;
                    }

                    int collisionRet = Math.abs(val) > preAsteroid ? val :preAsteroid;
                    list.remove(idx);
                    idx = list.size() - 1;

                    if(collisionRet < 0 && idx >= 0 && list.get(idx) > 0){
                        val = collisionRet;
                    }else{
                        list.add(collisionRet);
                        break;
                    }
                }
            }else{
                list.add(asteroids[i]);
            }
        }

        int[] retArr = new int[list.size()];
        for(int i = 0 ;i < list.size(); i ++){
            retArr[i] = list.get(i);
        }
        return retArr;
    }

}
