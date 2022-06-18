package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0),
    NE(45),
    E(90),
    SE(135),
    S(180),
    SW(225),
    W(270),
    NW(315);

    Direction(final int degrees) {

        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        Direction result = null;
        for (Direction dir : Direction.values()) {
            if (dir.degrees == degrees || degrees % 360 == dir.degrees || degrees + 360 == dir.degrees) {
                result = dir;
            }
        }
        return result;
    }

    public static Direction closestToDegrees(int degrees) {
        int idx = 0;
        Direction result = null;
        if (degrees >= 0) {
            int deg = Math.abs(degrees % 360);
            int distance = Math.abs(N.degrees - deg);
            for (Direction dir : Direction.values()) {
                int cdistance = Math.abs(dir.degrees - deg);
                if (cdistance < distance) {
                    idx = dir.ordinal();
                    distance = cdistance;
                }
            }
            result = Direction.values()[idx];
        }
        if (degrees < 0) {
            degrees = 360 - Math.abs(degrees);
            int deg = Math.abs(degrees % 360);
            int distance = Math.abs(N.degrees - deg);
            for (Direction dir : Direction.values()) {
                int cdistance = Math.abs(dir.degrees - deg);
                if (cdistance < distance) {
                    idx = dir.ordinal();
                    distance = cdistance;
                }
            }
            result = Direction.values()[idx];
        }
        return result;
    }

    public Direction opposite() {

        switch (this) {
            case N:
                return S;
            case E:
                return W;
            case S:
                return N;
            case NE:
                return SW;
            case SE:
                return NW;
            case W:
                return E;
            case SW:
                return NE;
            case NW:
                return SE;
            default:
                throw new Error();
        }
    }

    public int differenceDegreesTo(Direction direction) {
        int dif = 0;
        if (this.degrees >= direction.degrees) {
            dif = this.degrees - direction.degrees;
            if (dif > 180) {
                dif = dif % 360;
                if (dif > 180)
                    dif = Math.abs((dif - 360));
            }
            return dif;
        } else {
            dif = direction.degrees - this.degrees;
            if (dif > 180) {
                dif = dif % 360;
                if (dif > 180)
                    dif = Math.abs((dif - 360));
            }
            return dif;
        }

    }
}
