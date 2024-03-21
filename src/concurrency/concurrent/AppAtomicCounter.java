package concurrency.concurrent;
/*
* Existem Classes no Java que permitem trabalhar com tipos primitivos de forma atômica
* No caso do int temos a Classe AtomicInteger, todas as outras começam com Atomic e fazem parte do pacote java.util.concurrent
* Com o atributo counter na região crítica do incremento trocamos pelo equivalente ao counter++ com o getAndIncrement()
* A partir daí a thread que acessar a região crítica deverá concluir toda sua operação sem interferência das outras garantindo a consistência
* e resolvendo o problema da concorrência.
*
* */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class AppAtomicCounter {

    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        try (ExecutorService e = Executors.newFixedThreadPool(15)) {
            List<Future<?>> futures = new ArrayList<>();

            for (int i = 0; i < 15; i++) {
                futures.add(
                        e.submit(
                                () -> {
                                    for (int j = 0; j < 100; j++) {
                                        counter.getAndIncrement();
                                        sleep();
                                    }
                                }
                        )
                );
            }

            for (var future : futures) {
                wait(future);
            }

            System.out.println("Counter = " + counter);
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void wait(Future<?> future) {
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
