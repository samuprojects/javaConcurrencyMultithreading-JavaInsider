package concurrency.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*
* Criar classe Printer com método printDocument() para representar uma impressora única compartilhada entre threads
* Somente uma thread pode imprimir por vez, as demais devem aguardar
*
*
* */
public class ExPrinter {

    public static void main(String[] args) {

        Printer printer = new Printer();

        try (ExecutorService e = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 10; i++) {
                int currentIndex = i;
                e.submit(() -> printer.printDocument("Document " + (currentIndex + 1)));
            }
        }
    }

    private static class Printer {

        private final Lock lock = new ReentrantLock();

        public void printDocument(String document) {
            lock.lock();
            try {
                System.out.println("Printing: " + document);

                try {
                    Thread.sleep((long) (Math.random() * 5000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
