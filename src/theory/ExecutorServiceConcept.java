package theory;
@SuppressWarnings("ALL")
public class ExecutorServiceConcept {

    /*
     * A partir desse ponto será abordado o tema Threads em alto nível começando pelo conceito de ExecutorService
     * Até o momento foi visto a implementação de Runnable ou herança de Thread para criação de threads.
     * O ExecutorService é um recurso do Java que permite abstrair o conceito de Threads para não se preocupar com a criação das mesmas.
     * Isso permite utilizar threads que já existem, pois foram criadas previamente de uma determinada forma.
     *
     * Uma forma de criar ExecutorServices de forma simples é utilizando métodos estáticos da classe Executors do pacote java.util.concurrent
     * buscando pelo newSingleThreadExecutor teremos um ExecutorService capaz de executar uma coisa de cada vez em uma thread
     * para executar uma tarefa basta chamar o submit e passar como parâmetro um Runnable podendo ser uma instancia de uma classe criada
     * que implementa a interface Runnable ou até uma expressão lambda
     * Como o ExecutorService fica executando, para encerrá-lo basta chamar o método shutdown.
     *
     * É possível passar mais de uma tarefa, porém, ele tem uma espécie de fila de espera que não permite enviar mais threads do que o ExecutorService é
     * capaz de executar.
     *
     *
     * */
}
