package com.epam.pattern;

import com.epam.pattern.sorts.BubbleSort;
import com.epam.pattern.sorts.ISort;
import com.epam.pattern.sorts.InsertionSort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class Consumer {
    private static final String INSERTION_SORT = "Insertion sort";
    private static final String BUBBLE_SORT = "Bubble sort";
    private static final String QUICK_SORT = "Quick sort";

    private BlockingQueue<SortableArray> queue;
    private final Map<String, ISort> sorts = new HashMap<>();
    private final String name;

    public Consumer(BlockingQueue<SortableArray> queue, String name) {
        this.queue = queue;
        this.name = name;
        sorts.put(INSERTION_SORT, new InsertionSort());
        sorts.put(BUBBLE_SORT, new BubbleSort());
        sorts.put(QUICK_SORT, new BubbleSort());
    }

    public void sortArrayFromQueue() throws InterruptedException {
        SortableArray sortableArray = queue.take();
        StringBuilder builder = new StringBuilder();
        int[] array = sortableArray.getArray();
        int[] sortedArray = null;

        if(sortableArray.isSortable){
            if(array.length < 11){
                sortedArray = sorts.get(INSERTION_SORT).sort(array);
                builder.append(name).append(" sorted array: ").append(sortableArray.toString()).append(" with inserton sort: ");
            }else if(array.length < 100){
                sortedArray = sorts.get(BUBBLE_SORT).sort(array);
                builder.append(name).append(" sorted array: ").append(sortableArray.toString()).append(" with bubble sort: ");
            }else{
                sortedArray = sorts.get(QUICK_SORT).sort(array);
                builder.append(name).append(" sorted array: ").append(sortableArray.toString()).append(" with quick sort: ");
            }
        }
        builder.append(Arrays.toString(sortedArray)).append("\n");
        System.out.println(builder.toString());
    }
}
