package concurrency.core;

@SuppressWarnings("ALL")
public class SharedCounter2 implements Runnable {

    private int counter; // para guardar o valor do contador atual

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) { // vai iterar 100x incrementando o contador
            counter++;
            try {
                Thread.sleep(10); // apenas com o sleep evidenciou um problema no algoritmo que não está preparado para mais de uma thread
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getCounter() {
        return counter;
    }
}

