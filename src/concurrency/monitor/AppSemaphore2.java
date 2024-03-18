package concurrency.monitor;
/*
*
* O CountDownLatch cria uma espécie de barreira, funciona semelhante a um join, utilizado em situações em que um objeto deve esperar até
* determinada condição ser verdadeira, como, por exemplo, até que todas as threads terminem de executar. No caso do join espera todas terminarem
* e o CountDownLatch é como se fosse um contador regressivo que ao chegar em zero faz com que o processo continue, ou seja, não está
* necessariamente ligado a threads terminando sua execução.
*
* */
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

public class AppSemaphore2 {

    public static void main(String[] args) throws Exception {

        Semaphore semaphore = new Semaphore(1);
        CountDownLatch countDownLatch = new CountDownLatch(10); // instancia de CountDownLatch passando o mesmo número de threads para baixar o contador

        var threads = Stream
                .generate(() -> new Thread(new CounterThread(semaphore, countDownLatch)))
                .limit(10)
                .toList();

        threads.forEach(Thread::start);

        countDownLatch.await(); // chamada bloqueante que aguarda o countDownLatch ficar zerado

        System.out.println("Count: " + CounterThread.count);
    }

    private static class CounterThread implements Runnable {

        public static int count;

        private final Semaphore semaphore;
        private final CountDownLatch countDownLatch; // criando atributo para CountDownLatch para utilizar no construtor da classe CounterThread

        public CounterThread(Semaphore semaphore, CountDownLatch countDownLatch) {
            this.semaphore = semaphore;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {

            for (int i = 0; i < 10 ; i++) {
                try {
                    semaphore.acquire();
                    count++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            countDownLatch.countDown(); // quando terminar a thread diminui o contador
        }
    }
}
