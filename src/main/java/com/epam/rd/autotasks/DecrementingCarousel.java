package com.epam.rd.autotasks;

public class DecrementingCarousel {
    protected final int[] array;
    protected int index;
    protected boolean running;
    public DecrementingCarousel(int capacity) {
        this.array = new int[capacity];
        for (int i = 0; i < capacity; i++){
            array[i] = 0;
        }
        this.index = 0;
        this.running = false;
    }

    public boolean addElement(int element){
        if (element <= 0 || index == array.length || running){
            return false;
        }else {
            array[index] = element;
            index++;
            return true;
        }
    }
    public CarouselRun run(){
        if (running){
            return null;
        }
        running = true;
        return new CarouselRun(array, index, getClassName());
    }

    protected Object getClassName(){
        return getClass().getName();
    }
}
