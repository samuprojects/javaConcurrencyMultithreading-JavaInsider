package theory;

@SuppressWarnings("ALL")
public class ThreadBehavior {

    /*
    *
    * Tudo que fica no HEAP é compartilhado entre Threads, ou seja, todos os objetos.
    * Pode ocorrer, como visto na aula passada, duas Threads tentando acessar o mesmo objeto (race condition)
    *
    * Na stack (lembrando que quando a memória é disponibilizada para o Java é dividida em duas: HEAP e STACK) ficam as variavéis locais
    * criadas dentro de métodos. Os atributos de um objeto ficam com o objeto dentro do HEAP e a variável na stack possui uma referência do objeto no HEAP.
    *
    * Em relação as Threads cada uma tem sua stack, ou seja, a informação da stack fica dentro da própria Thread de forma que não existe compartilhamento de informação
    * de stack. Por isso não é preciso se preocupar com a presença de múltiplas threads em cenários onde as variavéis criadas são locais.
    *
    * PORÉM, atenção quando uma thread 1 com variável A e thread 2 com variável B, estiverem com a mesma referência de objeto no HEAP, daí pode haver inconsistências
    * e o acesso precisar ser sincronizado.
    *
    * Por isso deve se analisar cada cenário, por exemplo, se estiver trabalhando com variáveis de tipo primitivo então seguramente o dado está na stack, cada thread com o seu dado
    * Quando se trabalha apenas com variáveis locais seu código já é thread-safe. O problema maior é quando o HEAP entra na jogada porque os dados são compartilhados.
    *
    *
    *                               HEAP
    *  _____            ______________________________
    * |                 |     ____           ____    |
    * | T1              |    |   |          |   |    |
    * |---------------> |    |___|          |___|    |
    * | stack           |                            |
    * |_____            |                            |
    *                   |                            |
    *   _____           |                            |
     * |                |    ____           ____     |
     * | T2             |   |   |          |   |     |
     * |--------------> |   |___|          |___|     |
     * | stack          |                            |
     * |_____           |                            |
    *                   |____________________________|
    *
    *                                     ref local
    *                              T1  A ______
    *                                          \
    *                                           \> _______ mesmo Objeto no HEAP
    *                                           />
    *                              T2  B ------/
    *                                     ref local
    *
    *
    * */
}
