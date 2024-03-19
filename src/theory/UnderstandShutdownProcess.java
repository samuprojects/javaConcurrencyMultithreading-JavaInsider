package theory;

@SuppressWarnings("ALL")
public class UnderstandShutdownProcess {

    /*
    *
    * Como funciona o processo de finalização do ExecutorService
    *
    * Após enviar uma tarefa para a thread do ExecutorService com o submit(), a thread principal imediatamente executa o shutdown();
    * O shutdown() não bloqueia esperando a tarefa terminar, ele simplesmente instrui o ExecutorService de que não pode mais receber tarefas.
    * Tanto que se testar enviando uma nova tarefa após o shutdown() haverá uma exceção informando um RejectedExecutionException
    * por tentar submeter uma tarefa à um pool de threads que já foi encerrado.
    * As tarefas que já estão em execução são concluídas normalmente e amigavelmente.
    *
    * Existe também o shutdownNow() que encerra o pool de threads imediatamente incluindo as tarefas em execução.
    * O shutdownNow() retorna uma lista de Runnable das tarefas que estavam no aguardo para execução
    * (não inclui as que estavam em execução e foram interrompidas).
    * Essas filas que estavam em espera podem ser retomadas conforme decisão do programador em um outro pool de threads, por exemplo.
    *
    * Existe também o método awaitTermination() que pode ser chamado após um shutdown() para bloquear
    * a thread em execução e o ExecutorService encerrar seu trabalho. Para isso deve passar dois parâmetros
    * indicando quanto tempo máximo será aguardado para esse bloqueio. (professor optou por lançar para fora a exceção desse método)
    * Dessa forma a thread principal ficará sincronizada executando seu código final após a thread do pool.
    *
    * */
}
