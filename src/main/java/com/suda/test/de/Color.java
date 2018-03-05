package com.suda.test.de;

/**
 * 花色枚举
 *
 * @author liuzhou
 *         create at 2018-03-05 19:36
 */
public enum Color {

    SPADE("黑桃"),
    HEART("红桃"),
    DIAMOND("方块"),
    CLUB("梅花"),
    ;

    private String name;

    Color(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                '}';
    }
}
