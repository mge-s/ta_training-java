package com.epam.rd.autotasks.sequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        // Put your code here
        Scanner scnr = new Scanner(System.in);
        int max = 0;
        int min = 0;
        int currValue = 1;
        int counter = 0;

        while (currValue > 0 | currValue < 0) {
            currValue = scnr.nextInt();
            if (currValue == 0)
                break;
            else if (currValue < min)
                min = currValue;
            else if (currValue > max)
                max = currValue;

            counter++;
            if (counter == 1) {
                max = currValue;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
