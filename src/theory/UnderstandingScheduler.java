package theory;

@SuppressWarnings("ALL")
public class UnderstandingScheduler {

    /*
    *
    * Bugs que envolvem aplicações multithreads são difíceis de detectar e encontrar a causa do problema por isso requer muita atenção na construção da aplicação
    *
    * O Escalonador é um pedaço de software dentro de um Sistema Operacional que tem o papel de colocar as coisas para executar, ou seja, deixar os processadores ocupados
    * Se, por exemplo, tem a disposição 2 processadores (ou 2 core, o que conta são os cores, pode haver 1 processador com 4 cores por exemplo), o escalonador vai
    * direcionar essa quantidade de tarefas para execução.
    *
    * Ele também gerencia as Threads, no exemplo de 4 Threads para 2 Core, faz um Time Share mandando a Thread 1 para um Core, e a Thread 2 para o outro Core.
    * Após um tempo ele tira essas Threads e escolhe outras duas, e assim repetidamente. Para quem está de fora a impressão é de tudo acontece ao mesmo tempo. Mas
    * na verdade, esse Time Share (também conhecido como Time Slicing, Fatia do Tempo) é tão rápido que passa a impŕessão de simultâneo.
    * Mesmo que seja apenas 1 Core o mecanismo do escalonador consegue te fazer acreditar que são várias Threads ao mesmo tempo.
    * Ou seja, não é necessário ter o mesmo número de Threads para o mesmo número de Core.
    *
    * O importante é saber que quando o escalonador tira uma thread para colocar outra para executar isso é chamado de troca de contexto (Context Switching).
    * Isso tem um custo computacional, que é mandar a Thread parar tudo que está fazendo, salvar o estado dela com todas as informações daquele ponto da execução,
    * e tirar da execução, outra é colocada, o estado dela é restaurado para continuar de onde parou e começa a executar, e isso repetidamente para cada Thread.
    *
    * Apesar de ser na ordem dos nanossegundos o uso intenso desse mecanismo de troca de contexto pode resultar em perda de performance.
    * Por isso várias Threads numa aplição não refletem necessariamente num programa mais rápido, pode acontecer, principalmente quando envolve IO, mas não é garantido.
    *
    * Como programador Java não há nada que se possa fazer nesse cenário a não ser preparar a aplicação para um cenário multithread e poder usar da melhor forma otimizando o programa.
    *
    *   Thread 1 <---\
    *   Thread 2 <-\  \   (scheduler) /------->CORE
    *               ------Escalonador
    *   Thread 3 <-/  /       ^      \------->CORE
    *   Thread 4 <---/        |             Processador
    *     ...                 |
    *                         |
    *   Context            Time Share
    *   Switching
    *
    * */
}
