package concurrency.concurrent;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppStringJoiner2 {

    public static void main(String[] args) throws InterruptedException {

        try (ExecutorService e = Executors.newSingleThreadExecutor()) {
            Future<String> future = e.submit(new StringJoinerCallable(List.of("A", "B", "C")));
            System.out.println(future.get());

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
