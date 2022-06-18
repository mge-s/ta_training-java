package com.epam.rd.autotasks;

public class DecrementingCarousel {
    boolean run_on = false;
    static int capacity;
    static int[] array;
    int index = 0;

    public DecrementingCarousel(int capacity) {
        DecrementingCarousel.capacity = capacity;
        array = new int[capacity];
    }

    public boolean addElement(int element) {

        if (index < capacity && element > 0 && !run_on) {
            array[index] = element;
            index++;
            return check(array, element);
        }
        return false;
    }

    public boolean check(int[] arr, int value) {
        boolean exist = false;
        for (int var : arr) {
            if (var == value) {
                exist = true;
                break;
            }
        }
        return exist;
    }


    public CarouselRun run() {

        if (!run_on) {
            run_on = true;
            return new CarouselRun();
        }

        return null;
    }
}

