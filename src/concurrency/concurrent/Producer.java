package concurrency.concurrent;

import java.util.concurrent.Callable;

@SuppressWarnings("ALL")
public class Producer implements Callable<Void> {

    private final String name;
    private final ItemsQueue queue;

    public Producer(String name, ItemsQueue queue) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public Void call() throws InterruptedException {
        int counter = 0;
        while (true) {
            queue.produce(name, counter++);
            Thread.sleep(300);
        }
    }
}
