package com.soda.test.de;

/**
 * 扑克
 *
 * @author liuzhou
 *         create at 2018-03-05 19:33
 */
public class Card {

    private Color color;
    private Point point;

    /**
     * 减少代码书写
     */
    public static Card of(Color color, Point point) {
        return new Card(color, point);
    }

    public Card() {
    }

    public Card(Color color, Point point) {
        this.color = color;
        this.point = point;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
