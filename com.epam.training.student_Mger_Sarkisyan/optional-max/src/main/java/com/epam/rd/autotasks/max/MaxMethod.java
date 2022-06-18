package com.epam.rd.autotasks.max;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        ArrayList<Integer> array = new ArrayList<>();
        if(values == null || values.length == 0){
            return OptionalInt.empty();
        }
        for (int x : values) {
            array.add(x);
        }
        int max = Collections.max(array);

        return OptionalInt.of(max);
    }
}