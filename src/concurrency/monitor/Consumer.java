package concurrency.monitor;

import java.util.Queue;

@SuppressWarnings("ALL")
public class Consumer extends Thread {

    private final String name;
    private final Queue<Integer> queue;

    public Consumer(String name, Queue<Integer> queue) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            consume();

            try { // colocado sleep fora do synchronized porque ele trava o lock e não permite outras threads rodarem
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void consume() {
        synchronized (queue) { // usando a fila como monitor por estar compartilhada entre todos
            while (queue.isEmpty()) { // optado por while para evitar o Spurious wakeup (testar se a condição que fez dormir ainda é válida)
                System.out.format("%s stopped\n", name);
                try {
                    queue.wait(); // permanece dormindo dependendo do teste do while
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            int value = queue.poll(); // consumir puxando a informação da fila
            System.out.format("%s consumed: %d\n", name, value); // impressão do valor consumido
            queue.notifyAll(); // após consumo avisa todos os possíveis produtores que estão dormindo para produzir
        }
    }
}
