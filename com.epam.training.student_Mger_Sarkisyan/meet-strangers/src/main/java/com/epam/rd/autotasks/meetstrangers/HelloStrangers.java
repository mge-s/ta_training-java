package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".
        Scanner scann = new Scanner(System.in);
        int number = scann.nextInt();
        String name;
        ArrayList<String> array = new ArrayList<>();
        if (number > 0) {
            for (int i = 0; i < number; i++) {
                Scanner scann1=new Scanner(System.in);
                name = scann1.nextLine();
                array.add(name);
            }
            for (String s : array) {
                System.out.println("Hello, " + s);
            }
        } else if (number < 0) {
            System.out.println("Seriously? Why so negative?");
        } else {
            System.out.println("Oh, it looks like there is no one here");
        }

    }
}
