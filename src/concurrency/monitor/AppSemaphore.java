package concurrency.monitor;
/*
* Semaphore é um dispositivo da programação concorrente com objetivo de permitir ou bloquear
* a execução de threads de acordo com regras definidas pelo programador
* Faz parte do pacote java.util.concurrent
* Permite controlar quantas threads podem passar por ele.
* Quando uma thread entra no semaphore aberto ele fecha e outra thread tem que aguardar abrir novamente (que é quando a primeira thread sai)
* Para usar o semaphore identificar onde é a região crítica (nesse exemplo o count++)
* acquire() para entrar na região crítica / release() para sair
* Se esquecer de dar o release nunca outras threads poderão entrar.
*
* Quando um semaphore tem permits = 1 é considerando um semáforo de exclusão mútua,
* só um pode passar por vez, e por isso pode substituir um monitor.
* Nesse sentido o semaphore também pode receber o nome de Mutex.
* */
import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

public class AppSemaphore {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1); // criando Semaphore única para visibilidade pelas threads informando quanto será permitido passar

        var threads = Stream
                .generate(() -> new Thread(new CounterThread(semaphore)))
                .limit(10)
                .toList(); // criação das threads

        threads.forEach(Thread::start); // inicializando cada uma

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }); // colocando todas para aguardarem

        System.out.println("Count: " + CounterThread.count); // exibe o valor do contador final
    }

    private static class CounterThread implements Runnable { // thread que será criada várias vezes no main

        public static int count; // variável estática para que todos enxerguem o mesmo contador, será acessada por todas as threads no count++

        private final Semaphore semaphore;

        public CounterThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {

            for (int i = 0; i < 10 ; i++) { // as threads vão incrementar 10x o contador ao mesmo tempo (resultado esperado = 100)
                try {
                    semaphore.acquire(); // reduz 1 permits de Semaphore que no exemplo fica 0 e por isso se chegar outra thread não pode entrar
                    count++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally { // optado por usar o finally para garantir que mesmo na presença de exceção o permits do Semaphore seja liberado
                    semaphore.release(); // liberação do permits do semaphore
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
