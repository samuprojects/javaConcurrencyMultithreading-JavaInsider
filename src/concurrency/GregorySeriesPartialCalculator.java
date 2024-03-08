package concurrency;

import static concurrency.GregorySeriesCalculator.NUM_ITERATIONS;
import static concurrency.GregorySeriesCalculator.NUM_THREADS;


public class GregorySeriesPartialCalculator extends Thread { // mudou para Thread para facilitar start

    private final int id; // id da thread que vai de 0 até o que for determinado para quantidade de threads
    private final double[] partials;

    public GregorySeriesPartialCalculator(int id, double[] partials) {
        this.id = id;
        this.partials = partials;
    }

    @Override
    public void run() {

        double sum = 0.0; // para receber a somatória das parciais

        // i = id da thread; quantidade iteração na constante; incrementa com a quantidade de threads disponíveis
        for (int i = id; i < NUM_ITERATIONS; i += NUM_THREADS){ // isso fará com que nenhuma thread calcula na sequência da outra
            int s; // parte de cima da fórmula -1 elevado a n

            // matematicamente -1 elevado a qualquer coisa...
            if (i % 2 == 0) { // se for par = 1
                s = 1;
            } else { // se for ímpar = -1
                s = -1;
            }

            // parte de baixo da fórmula 2x i + 1, mas antes tem que dividir a parte de cima com a de baixo
            sum += (double) s / (2 * i + 1); // como s é um inteiro e 2 * i + 1 também resulta inteiro as casas decimais seriam truncadas, por isso casting para double
        }

        // no final a variável sum terá a soma de tudo que precisa ser atribuído ao array
        partials[id] = sum; // finaliza o cálculo das parciais
    }
}
