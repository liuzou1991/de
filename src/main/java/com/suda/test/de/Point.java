package com.suda.test.de;

/**
 * 点数，命名不太规范
 *
 * @author liuzhou
 *         create at 2018-03-05 19:40
 */
public enum Point {

    _A("A", 1),
    _2("2", 2),
    _3("3", 3),
    _4("4", 4),
    _5("5", 5),
    _6("6", 6),
    _7("7", 7),
    _8("8", 8),
    _9("9", 9),
    _10("10", 10),
    _J("11", 11),
    _Q("12", 12),
    _K("13", 13),
    ;

    private String name;
    private int number;

    Point(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Point{" +
                "name='" + name + '\'' +
                '}';
    }

    public int compare(Point o) {
        if (this == o) {
            return 0;
        }
        if (this == _A) {
            return 1;
        }
        if (o == _A) {
            return -1;
        }
        return this.number - o.number;
    }
}
