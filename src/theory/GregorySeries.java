package theory;

@SuppressWarnings("ALL")
public class GregorySeries {

    /*
    *
    *  Série de Gregory - é utilizada para calcular o valor de π (pi)
    *  π     ∞     (-1)n
    *  _  =  Σ     ______
    *  4     n=0   2n+1
    *
    * A fórmula é pi sobre 4 é = a um Somatório de n de 0 ao ∞ (infinito),
    * de -1 elevado a n, dividido por 2n + 1
    *
    * O n é a variável principal desse somatório.
    *
    * Como o n começa em 0 e vai até o infinito, então basicamente você escolhe quantas iterações a série vai fazer
    * O que diferencia entre fazer mais ou menos iterações está na precisão do valor de pi que se obterá no final do cálculo
    * (quanto mais séries fizer será mais preciso e com mais casas decimais).
    * Para cada uma dessas variações de n devemos executar a fórmula -1 elevado a n, dividido por 2n + 1
    * Por exemplo: se n for 10 vai repetir a fórmula 10x e depois soma o resultado (somar essas partes)
    * Após calcular a fórmula do outro lado da expressão que ficou o pi sobre 4 (π/4), passa o 4 multiplicando no outro lado
    * assim obtém o valor de pi
    *
    * Em programação geralmente a primeira solução a ser pensada para a série de Gregory é de uma forma sequencial
    * utilizando um algoritmo com for entre cada uma das iterações do somatório, calcula a fórmula, vai somando e no final obtém a resposta. Vai funcionar.
    *
    * Porém, é possível utilizar uma programação multithread para obter uma aceleração na velocidade do cálculo, porque dependendo
    * de quantas vezes for iterar, ao invés de apenas uma thread sequencial fazendo tudo, pode quebrar isso e deixar múltiplas threads fazendo
    * o trabalho.
    *
    * Como tudo isso é um somatório tanto faz executar a primeira com a quinta, ou qualquer ordem entre as parciais, o importante é calcular tudo.
    * Por isso podemos fazer com que cada uma das threads faça o cálculo parcial, e quando todas terminarem, realizar a soma seguido da
    * multiplicação por 4 para a resposta final.
    *
    * A ideia é ter um número de Threads igual ao número de Core que temos no processador, ou outro número fixo que escolher.
    * Só não pode ser acima do número de Core do processador, pois como essa é uma operação computacionalmente intensiva
    * não obterá um ganho de velocidade no cálculo. Isso ocorre porque a CPU estará muito ocupada e com threads acima do disponível no processador
    * a troca de contexto vai aumentar o tempo de execução devido a saída de uma thread e entrada de outra no lugar.
    *
    * Para que as coisas funcionem como esperado é preciso disponibilizar um mecanismo para que cada thread armazene sua resposta em algum lugar.
    * O professor optou por um array de várias posições, onde cada uma delas vai receber o resultado do cálculo de cada thread.
    * Exemplo caso tenha 6 threads
    *  |T1|T2|T3|T4|T5|T6|
    *   0  1  2  3  4  5
    *
    * Isso é bom porque vai eliminar o ambiente de concorrência entre as threads (mesmo que todas enxerguem o mesmo array)
    * uma vez que cada uma delas vai mexer apenas no seu slot. Ou seja, vão escrever no mesmo array ao mesmo tempo, porém, em lugares diferentes.
    *
    * E quanto ao valor de n o professor optou por cada thread fazendo uma sequencia desse valor conforme exemplo a seguir
    * Thread 0 -> séries 0 - 6 - 12...
    * Thread 1 -> séries 1 - 7 - 13...
    * Thread 2 -> séries 2 - 8 - 14...
    * Thread 3 -> séries 3 - 9 - 15...
    * Thread 4 -> séries 4 - 10 - 16...
    * Thread 5 -> séries 5 - 11 - 17...
    * ...
    *
    * Considerando nesse cenário que a Thread tem ID 0, por atribuição do número da Thread à posição do Array onde ela vai armazenar o resultado,
    * A Thread sempre faz o valor dela e segue somando o número de Threads para frente, de forma que nunca aconteça de duas Threads
    * realizarem o mesmo cálculo da sequência de somatório. E o resultado é armazenado no próprio id que é a posição do array.
    *
    *
    *
    * */
}
