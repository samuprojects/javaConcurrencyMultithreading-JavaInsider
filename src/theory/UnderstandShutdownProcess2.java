package theory;

@SuppressWarnings("ALL")
public class UnderstandShutdownProcess2 {

    /*
    *
    * Como funciona o processo de finalização do ExecutorService parte2
    *
    * Se o timeout do awaitTermination() expirar antes do retorno acontecer o processo da thread do pool é abortado.
    * Por isso esse método retorna um booleano para indicar se as threads terminaram antes do tempo máximo (true) ou não (false).
    *
    * O professor sugeriu aproveitar isso para criar um mecanismo de controle e encerramento total do ExecutorService
    * onde se não terminaram as tarefas chama o shutdownNow() para encerrar imediatamente
    * E se a thread foi interrompida por alguém e lançar uma exceção também chama o shutdownNow() no catch
    *
    * Dessa forma a aplicação seguirá o seguinte fluxo:
    * vai encerrar a possibilidade de receber novas threads com o shutdown();
    * depois tenta finalizar as threads amigavelmente dentro do tempo estipulado no awaitTermination();
    * caso não termine vai encerrar "na marra" com o shutdownNow();
    * e caso a thread bloqueada no awaitTermination() foi interrompida por alguma outra thread também vai encerrar imediatamente
    *
    * Outra forma de fazer isso (como em AppExecutorShutdown) e com menor quantidade de código (como em AppExecutorShutdown2)
    * é simplesmente utilizando um try-with-resources.
    * Isso porque a partir do JAVA 19 o ExecutorService é um AutoCloseable.
    * O código executará da mesma forma que o anterior porém bem mais simples.
    *
    *
    * */
}
