package com.epam.pattern.sorts;

public class BubbleSort implements ISort {
    @Override
    public int[] sort(int[] array) {
        for(int i = 0; i < array.length; i++){
            for(int j = i; j < array.length; j++){
                if(array[i] > array[j]){
                    int swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }
            }
        }
        return array;
    }
}
