package concurrency.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class AppExecutorShutdown {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService e = Executors.newSingleThreadExecutor();

        e.submit(() -> {
            System.out.println("Task...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Task ended");
        });

        e.shutdown();
        //List<Runnable> pendingTasks = e.shutdownNow();

        System.out.println("Shutdown initiated...");

        e.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("The end!");
    }
}
