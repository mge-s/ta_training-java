package com.epam.rd.autotasks;

public class CarouselRun {

    int position = 0;

    public int next() {
        int count = 0;
        while (count < DecrementingCarousel.array.length && DecrementingCarousel.array[position %= DecrementingCarousel.array.length] <= 0) {
            position++;
            count++;
        }
        if (count == DecrementingCarousel.array.length) return -1;
        return DecrementingCarousel.array[position++]--;
    }


    public boolean isFinished() {
        for (int var: DecrementingCarousel.array) {
            if (var > 0) return false;
        }
        return true;
    }

}
