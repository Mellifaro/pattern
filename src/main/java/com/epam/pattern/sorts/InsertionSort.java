package com.epam.pattern.sorts;

public class InsertionSort implements ISort{
    @Override
    public int[] sort(int[] array) {
        int i, key, j;
        for (i = 1; i < array.length; i++)
        {
            key = array[i];
            j = i-1;

       /* Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position */
            while (j >= 0 && array[j] > key)
            {
                array[j+1] = array[j];
                j = j-1;
            }
            array[j+1] = key;
        }
        return array;
    }
}
