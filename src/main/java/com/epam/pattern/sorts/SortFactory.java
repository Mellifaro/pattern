package com.epam.pattern.sorts;

/**
 * Created by Viktor_Skapoushchenk on 3/15/2018.
 */
public class SortFactory {
    private final ISort quickSort = new QuickSort();
    private final ISort insertionSort = new InsertionSort();
    private final ISort bubbleSort = new BubbleSort();

    public ISort getSort(int size){
        if(size < 11){
            return insertionSort;
        }else if(size < 100){
            return bubbleSort;
        }else{
            return quickSort;
        }
    }
}
