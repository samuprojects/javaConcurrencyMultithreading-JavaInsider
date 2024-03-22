package theory;

@SuppressWarnings("ALL")
public class WhenToUseThreads {

    /*
    * Se tiver uma thread que não faz I/O mas é pesada, deixar executar sozinho,
    * ou no máximo, quantidade de threads igual ao número de core disponíveis para a jvm
    * acima disso o Context Switch vai prejudicar o desempenho da aplicação consideravelmente.
    *
    * Caso tenha somente 1 core, no cenário onde há I/O, ainda vale a pena ter o contexto multi thread
    * porque as operações de I/O não utilizam o processador fazendo com que essas threads saiam do processamento
    *
    * Em todos os cenários o professor recomendou fazer testes.
    *
    * Por exemplo num cenário de computação pesada, criar o processo, fazer suportar multi thread,
    * e testar (Benchmarking) com um número de threads = ao core do processador, anotar os resultados (tempos),
    * depois dobrar o número de threads verificar resultados, depois reduzir e testar novamente, no intuito de
    * descobrir, para a arquitetura da sua aplicação, qual o valor ideal de threads para executar sua aplicação.
    *
    *
    * CENÁRIO #1                                   SOMENTE 1 CORE, PODE FICAR OCIOSO
    *              BLOCKED                          ___________
    *               ^  |               externo      |   ____  |
    *               |  v      I/O     _______       |  | C |  |
    *              Thread  ------->   | /// |       |  ----   |
    *                      <------    | /// |       |_________|
    *                                 |_____|
    *
    * ------------------------------------------------------------------------------------
    * CENÁRIO #2
    *              WAITING           CONTEXT          COMPUTACIONAL AJUSTAR POR TESTES
    *               ^  |             SWITCH           ____________
    *               |  v              _______        |  |T|   |T| |       |
    *              Thread -------->  | Math |        |            |       |
    *                                |   .  |        | |T|   |T|  |       |
    *                                |   .  |        |____________|       v
    *                                |   .  |                           Para não cair desempenho
    *                                |______|
    *
    * */
}
