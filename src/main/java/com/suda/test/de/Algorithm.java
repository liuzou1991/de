package com.suda.test.de;

import java.util.List;

/**
 * 核心逻辑
 *
 * @author liuzhou
 *         create at 2018-03-05 19:50
 */
public class Algorithm {

    public boolean compare(List<Card> a, List<Card> b) {
        if (a == null || b == null || a.size() != 5 || b.size() != 5) {
            throw new IllegalArgumentException("输入错误");
        }
        boolean aIsTonghua = isTonghua(a);
        boolean bIsTonghua = isTonghua(b);
    }

    private boolean isTonghua(List<Card> cards) {
        if (cards == null || cards.size() < 2) {
            throw new IllegalArgumentException("输入错误");
        }
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

}
