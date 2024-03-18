package concurrency.concurrent;
/*
* ExecutorService com newFixedThreadPool passando o número de threads desejado
* Se for passado um número de tarefas superior ao número de threads passado ficará na fila aguardando
* Se quiser utilizar o número de core disponível no seu processador basta passar Runtime.getRuntime().availableProcessors()
*
* */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("ALL")
public class AppExecutors2 {
    public static void main(String[] args) {

        ExecutorService e = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        e.submit(() -> {
            System.out.println("Executing!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        e.submit(() -> {
            System.out.println("Executing");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        e.shutdown();
    }
}
