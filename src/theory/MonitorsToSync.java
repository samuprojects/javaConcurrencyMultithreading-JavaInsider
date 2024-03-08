package theory;

@SuppressWarnings("ALL")
public class MonitorsToSync {

    /*
    *
    * Existem códigos que na presença de várias threads podem resultar em inconsistência quando elas fazem leitura e alteração
    * das informações compartilhadas ao mesmo tempo
    *
    * A Critical Region é uma área que não pode ser executada por múltiplas threads. Precisa ter acesso sincronizado.
    * Como os exemplos anteriores dos contadores.
    *
    * Para entender o tema o professor sugeriu um cenário onde a região crítica é como uma sala, onde o acesso é controlado por um segurança (monitor)
    * que possui uma única chave (key) na mão. Essa chave é entregue para a Thread que deseja fazer o acesso e executar o código dessa região crítica.
    * Enquanto essa Thread1 que entrou estiver executando, se chegar uma Thread2 para pedir a key o monitor vai responder que não tem e é bloqueada
    * Fica aguardando a vez dela até que a Thread1 saia e devolva a chave ao monitor que libera a chave à Thread2 automatticamente.
    * O mecanismo de escanolamento de Threads do Java faz toda essa gestão e garante que somente uma thread entre na região crítica
    * Se existirem várias threads não é possível garantir a ordem de quem vai entrar por isso fica a cargo do escalonador.
    *
    * Trazendo para a terminologia do Java
    * Segurança = monitor
    * Key = lock
    *
    * Para acessar uma região crítica a thread precisa de um lock de um monitor, após o acesso e execução devolve o lock para o monitor que
    * disponibiliza para outra thread
    *
    * Monitor no Java é = um Objeto, ou seja, qualquer objeto do java pode ser usado como monitor, logo, qualquer objeto do Java possui um lock que pode ser utilizado.
    *
    *
    *                  monitor ╭────────╮         Threads aguardando
    *                    o     │        │         1   2   3
    *              chave/|\      região │         |   |   |
    *                   / \    │ crítica│         V   V   V
    *                          ╰────────╯         __________
    *                                             | LOCK   |
    *                                             ----------
    *                                              v  (uma thread por vez)
    *                                             ╭────────╮
    *                                             │        │
    *                                             │        │
    *                                             │   CODE │
    *                                             ╰────────╯
    *
    * */
}
