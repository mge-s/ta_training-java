package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int currValue = 1;
        int counter = 0;
        int summ = 0;

        while (currValue > 0 | currValue < 0) {
            currValue = scnr.nextInt();
            if (currValue == 0)
                break;
            summ+=currValue;

            counter++;

        }
        System.out.println(summ/counter);
    }

}