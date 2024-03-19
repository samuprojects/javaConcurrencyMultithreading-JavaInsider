package concurrency.concurrent;
/*
* ExecutorService com newCachedThreadPool permite utilizar quantas threads desejar
* A implementação padrão é de 0 threads e conforme envia objetos Runnable para dentro do pool vai reutilizar o que já existe
* e que estejam disponíveis ou cria uma thread nova para atender a solicitação.
* Ou seja, esse pool cresce indefinidamente e caso alguma thread não seja utilizada em até 60 segundos é removida do pool.
*
* */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("ALL")
public class AppExecutors3 {
    public static void main(String[] args) {

        ExecutorService e = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            e.submit(() -> {
                System.out.println("Executing!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }

        e.shutdown();
        }
    }