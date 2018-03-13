package com.epam.pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    private static final BlockingQueue<SortableArray> queue = new ArrayBlockingQueue<>(10000);

    public static void main(String[] args) {
        List<Producer> producers = new ArrayList<Producer>();
        Collections.addAll(producers, new Producer(queue, "Producer A"), new Producer(queue, "Producer B"));

        List<Consumer> consumers = new ArrayList<>();
        Collections.addAll(consumers, new Consumer(queue, "Consumer A"), new Consumer(queue,"Consumer B"), new Consumer(queue, "Consumer C"),
                new Consumer(queue, "Consumer D"), new Consumer(queue, "Consumer E"), new Consumer(queue, "Consumer F"));

        producers.forEach(producer ->
            new Thread(() -> {
                while (true){
                    producer.generateArray();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start()
        );

        consumers.forEach(consumer ->
            new Thread(() -> {
                while (true) {
                    try {
                        consumer.sortArrayFromQueue();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start()
        );

    }
}
