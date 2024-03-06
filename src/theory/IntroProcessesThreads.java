package theory;

@SuppressWarnings("ALL")
public class IntroProcessesThreads {

    /*
    *
    *       Threads                                                _________________
    *                                                             |    quad core   |
    * Disco                                                       |   |  |  |  |   |
    *  |_|                        _ _ _ _ _ _ _ _ _               |________________|
    *  _____                    /                  \
    * |  \\|   JVM            /                     \
    * |    |   -->        PROCESSO  -->  RAM         \-> ---------------
    * |____|                 |      <--  RAM           | linha execução |
    *  .class                |                         | principal      | 2 ou mais =
    *                        V                         | 1  -           | <--
    *                      PROCESSADOR                 | 2  -           | <-- multithread
    *                                                  | 3  -           | <--
    *                                                  |________________|
    *                                                   só uma =
    *                                                    SINGLE THREAD
    *
    *  No single thread o processo vai seguindo conforme as linhas de código, mas no multithread
    *  As outras threads não precisam executar o mesmo código necessariamente, o importante é saber que
    *  existe outra linha de execução simultânea à principal e isso muda completamente o funcionamento da aplicação.
    *  Isso tem seus benefícios, que serão vistos posteriormente, porém, também traz diversos desafios
    *  Porque muitas vezes executar código de maneira concorrente entre mais de uma thread, se esse código não
    *  estiver preparado pra esse ambiente, no contexto multithread, poderá resultar em inconsistências.
    *
    * */
}
