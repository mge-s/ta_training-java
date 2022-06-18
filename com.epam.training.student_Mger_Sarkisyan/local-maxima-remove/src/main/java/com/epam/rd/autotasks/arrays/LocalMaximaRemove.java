package com.epam.rd.autotasks.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array) {

        //put your code here
        List<Integer> list = new ArrayList<Integer>();
        if (array[0] <= array[1]) {
            list.add(array[0]);
        }
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1] || array[i] <= array[i - 1]) {
                list.add(array[i]);
            }
        }
        if (array[array.length - 2] >= array[array.length - 1]) {
            list.add(array[array.length - 1]);
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
        // throw new UnsupportedOperationException();
    }
}
