package com.epam.rd.autotasks;

public class Main {
    public static void main(String[] args) {
        DecrementingCarousel carousel = new DecrementingCarousel(7);

        carousel.addElement(20);
        carousel.addElement(30);
        carousel.addElement(10);

        CarouselRun run = carousel.run();
        System.out.println(run.isFinished());
        System.out.println(run.carousel.index);
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
        System.out.println(run.next());
    }
}
