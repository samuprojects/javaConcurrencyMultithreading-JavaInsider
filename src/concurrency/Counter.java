package concurrency;

public class Counter implements Runnable { // aplicação multithreading: contador

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.format("[%s] %d\n", Thread.currentThread().getName(), i); // toda thread pode ter um nome, principalmente na questão de logs

            try {
                Thread.sleep(100); // a cada impressão a thread dorme(estado bloqueio) por um determinado tempo (volta para Aguardando)
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
