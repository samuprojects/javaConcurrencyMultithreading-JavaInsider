package concurrency.monitor;

/*
* Para exemplificar o uso e sincronização de Threads foi demonstrado um jogo de corrida de sapos onde:
* alguns sapos farão 3 coisas: pular, descansar e avisar que fez isso como se fosse uma estatística para acompanhamento durante o jogo.
* Fica no loop até percorrer a distância máxima pelo primeiro sapo que ultrapassar o limite definido, depois o segundo e terceiro lugares.
* A distância do pulo e o tempo de descanso serão aleatórios para deixar o jogo dinâmico.
* Cada sapo será uma thread (da classe Frog criada).*
*
* */

public class FrogRace {

    private static final int NUM_FROGS = 5;

    private static final int MAX_DISTANCE = 500;

    public static void main(String[] args) {

        Frog[] frogs = new Frog[NUM_FROGS];

        for (int i = 0; i < frogs.length; i++) {
            frogs[i] = new Frog("Frog_" + (i + 1), MAX_DISTANCE);
            frogs[i].start();
        }

    }
}
