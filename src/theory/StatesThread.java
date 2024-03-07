package theory;

@SuppressWarnings("ALL")
public class StatesThread {

    /*
    *
    * Professor passou uma frase que gravou, ao chegar no tema de Threads, quando estudava para uma certificação Java, que é a seguinte:
    * "Quando se trata de Threads muito pouco é garantido."
    *
    * As Threads são controladas pelo Sistema Operacional por isso na programação Java não consegue muita coisa, porque grande parte do fluxo de execução das
    * Threads não está sob seu comando, não há garantia nem controle, por isso é necessário aprender a viver com isso.
    *
    * Por isso o professor apresentou um diagrama de estados para mostrar os estados que uma Thread passa na sua aplicação.
    *
    * O único passo que você controla é a criação da Thread. Após isso vai para o estado Aguardando, por isso nunca colocar, no código, uma Thread diretamente
    * em execução, porque isso quem faz é o escalonador (quem decide quem vai para execução e quem vai para o aguardando).
    * Outro passo que você controla também é o start para disponibiliza-la ao Aguardando e quando a Thread finaliza.
    *
    * O estado Bloqueada significa que não está executando e nem pronta para executar.
    * Existem 2 formas de bloquear uma Thread. Pode ser feito no código (wait) e uma vez bloqueada jamais volta para execução. Ao fim do bloqueio vai para Aguardando
    * A outra forma não depende de você mas ocorre dependendo de ações tomadas no código, por exemplo, se uma thread fizer uma operação de I/O (ação que não é executado
    * pelo processador) o próprio escalonador tira a thread do processamento e libera o CORE para outras threads executarem. Por exemplo um download ao concluir volta a thread
    * para o Aguardando (pelo próprio escalonador) para depois seguir com a execução novamente.
    *
    * Resumindo o bloqueio pode ser via código(wait) que necessita de uma outra Thread para desbloquear ou automaticamente via operação de IO.
    * O bloqueio via código é utilizado muitas vezes para sincronizar a operação de threads.
    *
    *
    *                            /-------------------Bloqueada
    *      fim operação IO     /                         ^
    *      fim bloqueio      /                           | operação I/O
    *                      /                             |  bloqueio via código
    *                    V   /____escalonador ______>\   |
    *  thread/---> Aguardando                         Executando
    *inicia/ start()         \<___escalonador ------/     |
    *    /                                                |
    * Criada                                              |
    *   new()                                             |
    *                                                   Finalizada
    * */
}
