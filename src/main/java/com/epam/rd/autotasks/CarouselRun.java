package com.epam.rd.autotasks;

public class CarouselRun {
    private int currentIndex;
    private final int countElements;
    private final int[] array;
    private final Object className;
    private int limit = 1;
    public CarouselRun(int[] arr, int count, Object className) {
        this.currentIndex = 0;
        this.className = className;
        if (count != 0){
            this.array = new int[count];
            System.arraycopy(arr, 0, array, 0, count);
        }else {
            this.array = arr;
        }
        this.countElements = count;
    }
    public CarouselRun(int[] arr, int count, Object className, int actionLimit) {
        this.currentIndex = 0;
        this.className = className;
        this.limit = actionLimit;
        if (count != 0){
            this.array = new int[count];
            System.arraycopy(arr, 0, array, 0, count);
        }else {
            this.array = arr;
        }
        this.countElements = count;
    }

    public int next() {
        if (className.equals("com.epam.rd.autotasks.DecrementingCarouselWithLimitedRun")){
            return nextWithLimit();
        }else {
            return nextD();
        }
    }
    private int nextWithLimit(){
        if (currentIndex < countElements && limit > 0) {
            while (currentIndex < countElements && array[currentIndex] <= 0) {
                currentIndex++;
            }
            if (currentIndex < countElements && array[currentIndex] >= 1) {
                int temp = array[currentIndex];
                array[currentIndex++]--;
                limit--;
                return temp;
            }
        }
        // Reset index to the beginning if currentIndex reached the end
        currentIndex = 0;

        // Check if there are non-zero elements from the beginning
        while (currentIndex < countElements && array[currentIndex] <= 0) {
            currentIndex++;
        }
        if (currentIndex < countElements && array[currentIndex] >= 1 && limit > 0) {
            int temp = array[currentIndex];
            array[currentIndex++]--;
            limit--;
            return temp;
        }
        // No non-zero elements found
        return -1;
    }
    private int nextD(){
        if (currentIndex < countElements) {
            while (currentIndex < countElements && array[currentIndex] == 0) {
                currentIndex++;
            }
            if (currentIndex < countElements) {
                return array[currentIndex++]--;
            }
        }
        // Reset index to the beginning if currentIndex reached the end
        currentIndex = 0;

        // Check if there are non-zero elements from the beginning
        while (currentIndex < countElements && array[currentIndex] == 0) {
            currentIndex++;
        }
        if (currentIndex < countElements) {
            return array[currentIndex++]--;
        }
        // No non-zero elements found
        return -1;
    }
    private boolean hasNext() {
        for (int i : array){
            if (i != 0){
                return true;
            }
        }return false;
    }
    public boolean isFinished() {
        if (limit <= 0){
            return true;
        }
        return !hasNext();
    }

}
