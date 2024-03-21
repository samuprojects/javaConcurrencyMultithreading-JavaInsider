package concurrency.core;

import java.util.stream.DoubleStream;

public class GregorySeriesCalculator {

    public static final int NUM_ITERATIONS = 100000;
    public static final int NUM_THREADS = Runtime.getRuntime().availableProcessors(); // para trazer o número de threads disponibilizadas para a JVM pelo S.O.


    // vai coordenar as threads
    public double calculate() throws InterruptedException {

        double[] partials = new double[NUM_THREADS]; // array para receber valores das threads com tamanho baseado na qtd de threads

        GregorySeriesPartialCalculator[] threads = new GregorySeriesPartialCalculator[NUM_THREADS]; // criação das threads

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new GregorySeriesPartialCalculator(i, partials);
            threads[i].start(); // cada thread começa o cálculo
        }

        for (GregorySeriesPartialCalculator thread : threads) { // alterado para enhanced-for por sugestão IDE
            thread.join(); // deixar a thread principal que chamou join aguardando a outra terminar, que é para concluir o cálculo
        }

        return DoubleStream.of(partials).sum() * 4; // StreamAPI para somar tudo e multiplicar conforme a formula
    }
}
