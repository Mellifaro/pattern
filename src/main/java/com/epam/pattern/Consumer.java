package com.epam.pattern;

import com.epam.pattern.sorts.ISort;
import com.epam.pattern.sorts.SortFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class Consumer {
    private SortFactory sortFactory = new SortFactory();
    private BlockingQueue<SortableArray> queue;
    private final Map<String, ISort> sorts = new HashMap<>();
    private final String name;

    public Consumer(BlockingQueue<SortableArray> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    public void sortArrayFromQueue() throws InterruptedException {
        SortableArray sortableArray = queue.take();
        StringBuilder builder = new StringBuilder();
        int[] array = sortableArray.getArray();
        int[] sortedArray = null;

        if(sortableArray.isSortable){
            sortedArray = sortFactory.getSort(array.length).sort(array);
        }
        builder.append(name).append(" sorted array: ").append(Arrays.toString(sortedArray)).append("\n");
        System.out.println(builder.toString());
    }
}
