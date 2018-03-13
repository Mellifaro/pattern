package com.epam.pattern;

import java.util.concurrent.BlockingQueue;

public class Producer {
    private final BlockingQueue<SortableArray> queue;
    private final String name;

    public Producer(BlockingQueue<SortableArray> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    public void generateArray(){
        SortableArray array = new SortableArray(true);
        queue.add(array);
        System.out.println(name + " generated array: " + array.toString());
    }
}
