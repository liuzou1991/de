package com.suda.test.de;

/**
 * 扑克
 *
 * @author liuzhou
 *         create at 2018-03-05 19:33
 */
public class Card {

    private Color color;
    private Point point;

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
