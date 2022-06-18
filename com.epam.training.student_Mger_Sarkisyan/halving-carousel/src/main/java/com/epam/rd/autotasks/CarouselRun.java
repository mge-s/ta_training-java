package com.epam.rd.autotasks;

public class CarouselRun {
    private int index;
    private final int[] array;
    DecrementingCarousel carousel;
    private boolean isFinished;

    public CarouselRun(int[] array, DecrementingCarousel carousel) {
        this.array = array;
        this.carousel = carousel;
        if(array.length == 0 || array[index] ==0)
            isFinished = true;
    }


    public void setNextIndex(){
        int count = 0;
        do{
            count++;
            index = (index + 1) % array.length;
            if(array[index] != 0)
                return;
        } while(count <= array.length);
        isFinished = true;
        index = -1;
    }

    public int next(){
        if(isFinished){
            return -1;
        } else {
            int element = array[index];
            array[index] = carousel.valueOperation(array[index]);
            setNextIndex();
            return element;
        }
    }


    public boolean isFinished() {

        return isFinished;
    }

}
