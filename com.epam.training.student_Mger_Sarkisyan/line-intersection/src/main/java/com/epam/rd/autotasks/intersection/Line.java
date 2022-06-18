package com.epam.rd.autotasks.intersection;

public class Line {
    int k;
    int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        int x;
        int y;
        int k1 = this.k;
        int b1 = this.b;
        int k2 = other.k;
        int b2 = other.b;
        if (k1 == k2) {
            return null;
        }
        x = (b2 - b1) / (k1 - k2);
        y = k1 * x + b1;
        return new Point(x,y);
    }

}
