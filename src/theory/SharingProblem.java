package theory;

@SuppressWarnings("ALL")
public class SharingProblem {

    /*
    * O problema do código anterior é que o mesmo objeto SharedCounter ao ser acessado (HEAP) por múltiplas threads (concorrente) pode ter o valor
    * de alguma operação perdido nas trocas efetuadas pelo escalonador.
    * Isso ocorre porque o cont++, na linguagem alto nível, representa na execução, em baixo nível, várias outras instruções
    * (por exemplo essa uma linha do cont++ poderia ser umas quatro instruções que ao ser removida não conclui o processo).
    * Essa situação pode fazer com que a Thread2 do exemplo esteja em um cálculo e a Thread1 ao retomar de onde parou ainda retornar com o valor antigo
    * fazendo com que o valor atual se torne inconsistente porque atualizam o mesmo atributo (counter) do objeto (que é compartilhado (shared)).
    * Como esse atributo é vital para uma operação correta essa parte do código é chamada de região crítica.
    * É necessário identificar todas as regiões críticas do seu código para que estejam consistentes na presença de threads.
    * Se estiver tudo correto dizemos que é um código thread-safe, ou seja, opera normalmente diante de múltiplas threads.
    *
    *                       HEAP
    *
    *                   -----------------------------------
    *    T1 ----------\ |  SharedCounter                   |
    *                 |===>counter (atributo compartilhado)| ------------> Região Crítica
    *    T2 ----------/ |   for(...){                      |
    *                   |      ...                         |         ___
    *                   |    count++; ---------------------|----->  |  --------
    *                   |   }                              |        |  --------  <==== removido pelo escalonador
    *                   |__________________________________|        |  --------        antes de concluir todas
    *   /-->T1 -> |5| + 1 -> |6|                                    |  --------        as instruções
    *   \---T2 ->  5 + 1 -> |6|                                baixo|___
    *                                                          nível
    *
    * */
}
