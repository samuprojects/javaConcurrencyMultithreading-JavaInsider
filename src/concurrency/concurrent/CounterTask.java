package concurrency.concurrent;
/*
* Como trabalhar o sincronismo de Threads utilizando o ExecutorService
*
* ao utilizar o que está disponível no pacote java.util.concurrent deixamos de utilizar o bloco synchronized com monitores
* para Lock com a implementação em ReentrantLock que permite uma thread com um lock poder entrar em outro bloco de código
* que necessite do mesmo lock (com uma mesma chave).
*
* */
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterTask implements Callable<Integer> {

    private int count;
    private final Lock lock = new ReentrantLock(); // assim como monitores o objeto Lock deve ser compartilhado entre todas as threads

    @Override
    public Integer call() throws InterruptedException {
        Thread.sleep(10);

        lock.lock();
        try {
            return ++count; // região crítica

        } finally { // mesmo na presença de exceção o lock será liberado
            lock.unlock(); // sempre fazer o unlock para evitar threads eternamente bloqueadas por falta de liberação do lock, por isso professor sugeriu finally

        }
    }
}
