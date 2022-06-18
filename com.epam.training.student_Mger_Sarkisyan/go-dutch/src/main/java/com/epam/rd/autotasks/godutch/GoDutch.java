package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        //Write code here
        Scanner scann = new Scanner(System.in);
        int bill = scann.nextInt();
        int quantity = scann.nextInt();
        if (bill <0) {
            System.out.println("Bill total amount cannot be negative");
        } else if (quantity <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else {

            double summ = ((double) bill + ((double) bill * 0.1)) / quantity;
            System.out.println((int)summ);
        }
    }
}
