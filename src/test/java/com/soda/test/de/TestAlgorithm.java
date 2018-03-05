package com.soda.test.de;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.soda.test.de.Card.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 使用junit5编写单元测试
 *
 * @author liuzhou
 *         create at 2018-03-05 21:23
 */
class TestAlgorithm {

    private static List<Card> flushAndStraight1;
    private static List<Card> flushAndStraight2;
    private static List<Card> flush1;
    private static List<Card> flush2;
    private static List<Card> straight1;
    private static List<Card> straight2;

    // 为了安全，其实应该全定义为final的静态属性，使用静态初始化块进行初始化，此处是想展示一下@BeforeAll的用法
    @BeforeAll
    static void init() {
        // 初始化数据
        flushAndStraight1 = Collections.unmodifiableList(
                Arrays.asList(
                        of(Color.SPADE, Point._3),
                        of(Color.SPADE, Point._A),
                        of(Color.SPADE, Point._4),
                        of(Color.SPADE, Point._2),
                        of(Color.SPADE, Point._5)
                )
        );
        flushAndStraight2 = Collections.unmodifiableList(
                Arrays.asList(
                        of(Color.SPADE, Point._J),
                        of(Color.SPADE, Point._A),
                        of(Color.SPADE, Point._K),
                        of(Color.SPADE, Point._10),
                        of(Color.SPADE, Point._Q)
                )
        );
        flush1 = Collections.unmodifiableList(
                Arrays.asList(
                        of(Color.SPADE, Point._K),
                        of(Color.SPADE, Point._A),
                        of(Color.SPADE, Point._4),
                        of(Color.SPADE, Point._2),
                        of(Color.SPADE, Point._5)
                )
        );
        flush2 = Collections.unmodifiableList(
                Arrays.asList(
                        of(Color.SPADE, Point._K),
                        of(Color.SPADE, Point._A),
                        of(Color.SPADE, Point._4),
                        of(Color.SPADE, Point._2),
                        of(Color.SPADE, Point._6)
                )
        );
        straight1 = Collections.unmodifiableList(
                Arrays.asList(
                        of(Color.SPADE, Point._3),
                        of(Color.HEART, Point._A),
                        of(Color.SPADE, Point._4),
                        of(Color.SPADE, Point._2),
                        of(Color.SPADE, Point._5)
                )
        );
        straight2 = Collections.unmodifiableList(
                Arrays.asList(
                        of(Color.SPADE, Point._J),
                        of(Color.SPADE, Point._A),
                        of(Color.DIAMOND, Point._K),
                        of(Color.SPADE, Point._10),
                        of(Color.SPADE, Point._Q)
                )
        );
    }

    @Test
    void testIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> Algorithm.compareCard(flushAndStraight1, new ArrayList<>()));
    }

    @Test
    void testFlushAndStraight() {
        assertEquals(0, Algorithm.compareCard(flushAndStraight1, flushAndStraight1));
        assertEquals(-1, Algorithm.compareCard(flushAndStraight1, flushAndStraight2));
        assertEquals(1, Algorithm.compareCard(flushAndStraight2, flushAndStraight1));
    }
}
