package com.epam.rd.autotasks.max;

import java.util.Arrays;

public class MaxMethod {
    public static int max(int[] values) {
        int max = values[0];
        for (int x : values) {
            if (max < x)
                max = x;
        }
        return max;
    }


}


