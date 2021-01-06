package com.concurrency.chapter8;

import java.util.Set;

/**
 *  谜题框架
 *  定义：
 *      1、一个初始位置
 *      2、一个目标位置
 *      3、用于判断移动是否有效的规则集
 *  规则集：
 *      1、计算从指定位置开始的所有合法的移动
 *      2、每次移动的结果位置
 */
public interface Puzzle<P, M> {

    P initialPosition();

    boolean isGoal(P position);

    Set<M> legalMoves(P position);

    P move(P position, M move);
}
