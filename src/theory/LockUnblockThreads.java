package theory;

@SuppressWarnings("ALL")
public class LockUnblockThreads {

    /*
    *
    * Dentro da região crítica é possível fazer com que uma thread seja bloqueada com o método wait()
    * quando isso ocorre a thread "dorme" devolvendo o lock ao monitor que libera para outra thread.
    * É importante que alguma outra thread tenha um notify() para liberar a thread que dorme senão ficará nesse estado bloqueada
    * Não é possível determinar qual thread será acordada com o notify() pois é o escalonador quem define isso.
    * Após uma thread ser acordada ela volta para o estado aguardando dentro da região crítica, porém, só volta a executar quando a thread
    * em execução terminar e devolver o lock ao monitor para que possa obter conforme gerenciamento do scheduler
    * Existe também o notifyAll que acorda todas as threads bloqueadas mas que só vão executar quando receberem o lock do monitor
    * Esses três métodos são de Object, ou seja, todos os objetos do Java o possuem e só podem ser utilizados dentro
    * de um bloco synchronized
    *
    *                 outras threads
    *                  aguardando
    *       |           |    |
    *       |           V    V
    *  _____|___________|________
    * |     |           |       |
    * |     |           |       |                   wait
    * |     V           V       |           Object  notify
    * |    Thread       Thread  |                   notifyAll
    * |    wait()     notify()  |
    * |                 |       |           bloco synchronized
    * |                 |       |
    * |                 |       |
    * |_________________|_______|
    *   Critical        |
    *    Region         V
    *                   fim, libera lock
    *                   p/ monitor
    *                   que entrega p/ thread
    *                   que acordou conforme schedule
    *
    *
    *
    * */
}
