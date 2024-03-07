package concurrency;

/*
* Para bloquear a thread principal até que outras threads finalizem pode usar o join() para isso
* O join faz com que a thread que o chamou fique bloqueada até o termino da nova thread
*
* */

import java.util.stream.Stream;

public class AppCounter3 {

    public static void main(String[] args) {

        SharedCounter2 c = new SharedCounter2();

        var threads = Stream
                .generate(() -> new Thread(c)) // generate permite criar vários elementos
                .limit(2) // limitado ao numero informado de Thread
                .toList(); // para converter em uma lista

        threads.forEach(Thread::start); // para cada thread chama o start

        threads.forEach(t -> { // para cada thread vai chamar um join
            try {
                t.join(); // fazendo com que todas as threads terminem para depois a principal
            } catch (InterruptedException e) { // tratamento da exceção lançada pelo join
                throw new RuntimeException(e);
            }
        });

        System.out.println("Total: " + c.getCounter()); // resultado com erro ao adicionar sleep
    }
}
