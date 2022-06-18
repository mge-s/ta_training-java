package com.epam.rd.autotasks;

import java.util.Arrays;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        char[] ch = shot.toCharArray();
        int letter = ch[0] - 64;
        int index = (Integer.parseInt(String.valueOf(ch[1])) - 1) * 8 + letter;
        int n = 64 - index;
        long currentShot = 1L<< n;
        shots = shots | currentShot;
        return (ships & currentShot) != 0;
    }

    public String state() {

        char water = '.';
        char miss = '×';
        char ship = '☐';
        char hit = '☒';
        String str = String.format("%64s", Long.toBinaryString(ships)).replace(" ", "0");
        char[] ch1 = str.toCharArray();

        String str2 = String.format("%64s", Long.toBinaryString(shots)).replace(" ", "0");
        char[] ch2 = str2.toCharArray();

        char[] ch3 = new char[64];
        for (int i = 0; i <= ch1.length - 1; i++) {
            if (ch1[i] == '1' && ch2[i] == '1') {
                ch3[i] = hit;
            }
            if (ch1[i] == '1' && ch2[i] == '0') {
                ch3[i] = ship;
            }
            if (ch1[i] == '0' && ch2[i] == '1') {
                ch3[i] = miss;
            }
            if (ch1[i] == '0' && ch2[i] == '0') {
                ch3[i] = water;
            }
        }
        String st = String.valueOf(ch3);
        for (int i = 8; i < ch3.length; i = i + 8 + 1) {
            st= st.substring(0, i) + '\n' + st.substring(i);
        }
        return st;
    }
}
