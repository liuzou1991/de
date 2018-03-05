package com.soda.test.de;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 核心逻辑
 * 完成同花顺、同花、顺子三种牌型的比较，不考虑其它牌型（均视为比顺子更小）
 *
 * @author liuzhou
 *         create at 2018-03-05 19:50
 */
public class Algorithm {

    /**
     * 比大小的核心方法
     * 完成同花顺、同花、顺子三种牌型的比较，不考虑其它牌型（均视为比顺子更小）
     *
     * @param a 五张牌
     * @param b 另外五张牌
     * @return 正数为a比b大，0相同，负数为b比a大
     */
    public int compareCard(List<Card> a, List<Card> b) {
        if (a == null || b == null || a.size() != 5 || b.size() != 5) {
            throw new IllegalArgumentException("输入错误");
        }
        boolean aIsFlush = isFlush(a);
        boolean bIsFlush = isFlush(b);
        if (aIsFlush && !bIsFlush) {
            return 1;
        }
        if (!aIsFlush && bIsFlush) {
            return -1;
        }
        // 现在a与b要么均为同花，要么均不为同花，在当前牌型假设下，可以不再考虑花色问题
        // 构建排序后的Point列表（升序）
        List<Point> ap = a.stream().map(Card::getPoint).sorted(Point::compareTo).collect(Collectors.toList());
        List<Point> bp = b.stream().map(Card::getPoint).sorted(Point::compareTo).collect(Collectors.toList());
        boolean aIsStraight = isStraight(ap);
        boolean bIsStraight = isStraight(bp);
        if (aIsStraight && !bIsStraight) {
            return 1;
        }
        if (!aIsStraight && bIsStraight) {
            return -1;
        }
        // 此时要么都是顺子，要么都不是，为了方便，直接都当不是顺子处理
        // （也可单独处理顺子情形，因为顺子时多最多只需看最大的两张就可比较，当且仅当最大的为A时要看两张）
        return comparePoint(ap, bp);
    }

    // 判断是否同花
    private boolean isFlush(List<Card> cards) {
        // 此处私有方法，可保证一定是大小为5的输入
        Color color = null;
        for (Card card : cards) {
            if (color == null) {
                color = card.getColor();
                continue;
            }
            if (color != card.getColor()) {
                return false;
            }
        }
        return true;
    }

    // 判断是否是顺子，注意特例A2345为最小顺子，输入为升序列表
    private boolean isStraight(List<Point> sortedPoints) {
        List<Point> _A2345 = Arrays.asList(Point._A, Point._2, Point._3, Point._4, Point._5);
        if (sortedPoints.containsAll(_A2345)) {
            // 由于Point是枚举，每个实例都是单例，所以Point无须重写equals()
            // 如果全都包含，那么此为最小的顺子
            return true;
        }
        Point previous;
        Point current = null;
        for (Point point : sortedPoints) {
            previous = current;
            current = point;
            if (previous == null) {
                continue;
            }
            if (current.subtract(previous) != 1) {
                return false;
            }
        }
        return true;
    }

    // 不考虑牌型的条件下比较两组点数的大小，输入均为升序的列表，且长度为5
    private int comparePoint(List<Point> ap, List<Point> bp) {
        int result;
        for (int i = 4; i >= 0; i--) {
            result = ap.get(i).subtract(bp.get(i));
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

}
