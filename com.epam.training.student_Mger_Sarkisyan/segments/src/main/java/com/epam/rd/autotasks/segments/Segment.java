package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    double x1;
    double x2;
    double y1;
    double y2;

    public Segment(Point start, Point end) {
        if (start == null || end == null)
            throw new IllegalArgumentException();
        if (start.getY() == end.getY() && start.getX() == end.getX())
            throw new IllegalArgumentException();
        x1 = start.getX();
        y1 = start.getY();
        x2 = end.getX();
        y2 = end.getY();
    }

    double length() {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    Point middle() {
        double x = (x1 + x2) / 2;
        double y = (y1 + y2) / 2;
        return new Point(x, y);
    }

    Point intersection(Segment another) {

        Point p = null;
        double d = (x1 - x2) * (another.y1 - another.y2) - (y1 - y2) * (another.x1 - another.x2);
        if (d != 0) {
            double v1x = y1 - x1;
            double v1y = y2 - y1;
            double v2x = another.x1 - x1;
            double v2y = another.y1 - y1;
            double v3x = another.x2 - x1;
            double v3y = another.y2 - y1;
            double v4x = another.x2 - another.x1;
            double v4y = another.y2 - another.y1;
            double v5x = x2 - another.x1;
            double v5y = y2 - another.y1;
            double v6x = x1 - another.x1;
            double v6y = y1 - another.y1;

            double x = ((x1 * y2 - y1 * x2) * (another.x1 - another.x2) - (x1 - x2) * (another.x1 * another.y2 - another.y1 * another.x2)) / d;
            double y = ((x1 * y2 - y1 * x2) * (another.y1 - another.y2) - (y1 - y2) * (another.x1 * another.y2 - another.y1 * another.x2)) / d;


            double coord1 = v1x * v2y - v1y * v2x;
            double coord2 = v1x * v3y - v1y * v3x;
            double coord3 = v4x * v5y - v4y * v5x;
            double coord4 = v4x * v6y - v4y * v6x;

            if (coord1 * coord2 <= 0 && coord3 * coord4 <= 0)
                p = new Point(x, y);

        }
        return p;
    }
}