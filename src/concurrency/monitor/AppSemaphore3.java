package concurrency.monitor;
/*
* Simulação de carros chegando a uma fronteira com quantidades de cabines limitados
* utilizando o recurso Semaphore do Java para controle dos carros (threads) que chegam por vez
*
* */
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class AppSemaphore3 {

    public static void main(String[] args) throws Exception {

        Semaphore semaphore = new Semaphore(3); // indica que só tem 3 cabines para atendimento dos carros

        IntStream
                .range(0, 10) // gerar intervalo de números inteiros
                .mapToObj(i -> new Car(i + 1, semaphore)) // mapeando elemento para objeto Car passando valor gerado como id + 1
                .forEach(Thread::start); // para objeto criado chama o método start

    }

    private static class Car extends Thread {
    private final int id;
    private final Semaphore semaphore;

    public Car(int id, Semaphore semaphore) {
        this.id = id;
        this.semaphore = semaphore;
    }

        @Override
        public void run() {
            try {
                System.out.format("[%d] Chegou à fronteira\n", id);

                semaphore.acquire(); // bloqueia a thread que não encontrar vaga na cabine

                System.out.format("[%d] Checagem iniciada\n", id);
                Thread.sleep((int) (Math.random() * 8000));
                System.out.format("[%d] Checagem terminada\n", id);

                semaphore.release(); // libera a vaga para outro carro (thread)

                System.out.format("[%d] Boa viagem!\n", id);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}