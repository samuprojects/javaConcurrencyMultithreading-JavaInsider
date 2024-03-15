package concurrency.monitor;

import java.util.Queue;

@SuppressWarnings("ALL")
public class Producer extends Thread {

    private final String name;
    private final Queue<Integer> queue;
    private final int queueSize;

    public Producer(String name, Queue<Integer> queue, int queueSize) {
        this.name = name;
        this.queue = queue;
        this.queueSize = queueSize;
    }

    @Override
    public void run() {

        int counter = 0;
        while (true) {
            produce(counter++);

            try { // colocado sleep fora do synchronized porque ele trava o lock e não permite outras threads rodarem
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void produce(int value) {
        synchronized (queue) { // usando a fila como monitor por estar compartilhada entre todos
            while (queue.size() == queueSize) { // optado por while para evitar o Spurious wakeup (testar se a condição que fez dormir ainda é válida)
                System.out.format("%s stopped\n", name);
                try {
                    queue.wait(); // permanece dormindo dependendo do teste do while
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            queue.offer(value); // produção na fila
            System.out.format("%s produced: %d\n", name, value); // impressão do valor produzido
            queue.notifyAll(); // após produção avisa todos os possíveis consumidores que estão dormindo para consumir
        }
    }
}
