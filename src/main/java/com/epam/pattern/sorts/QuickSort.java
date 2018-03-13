package com.epam.pattern.sorts;

public class QuickSort implements ISort {
    @Override
    public int[] sort(int[] array) {
        quickSort(array, 0, array.length -1);
        return array;
    }

    private void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int opora = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}
