package com.epam.pattern;

import java.util.Random;

public class SortableArray {
    int [] array;
    boolean isSortable;

    public SortableArray(boolean isSortable) {
        generateArray();
        this.isSortable = isSortable;
    }

    public SortableArray(int[] array, boolean isSortable) {
        this.array = array;
        this.isSortable = isSortable;
    }

    private void generateArray() {
        Random random = new Random();
        int arrSize = random.nextInt(10000);
        array = new int[arrSize];
        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(100000);
        }
    }

    public int[] getArray() {
        return array;
    }
}
