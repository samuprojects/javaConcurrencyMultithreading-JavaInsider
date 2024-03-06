package theory;

@SuppressWarnings("ALL")
public class CreatingThreads {

    /*
    *
    * Para criar uma thread no Java basta utilizar a classe Thread, utilizada para cenários com mais de uma thread, isso porque a aplicação
    * com apenas um método main (executável) já tem uma thread disponibilizada automaticamente (single thread).
    *
    * Existem duas formas de utilização da classe Thread, sendo a primeira por meio da Herança
    * Foi criado uma classe estendendo de Thread (do pacote java.lang) para sobrescrever o método run com o código que será executado pela thread
    * Depois alterado para static porque foi criado dentro da classe CreateThread e permitir instânciar um objeto.
    *
    * Porém não chamamos o método run, para não rodar na mesma thread, chamamos o método start.
    * O start inicia uma nova thread
    *
    * Ao chamarmos o start e colocarmos uma mensagem para impressão no console pela thread principal
    * pode ser que em algum momento a nova thread seja executada primeiro.
    *
    * Não há como saber quem executará primeiro porque essa é uma decisão do sistema operacional, por isso,
    * o programa deve ser criado já sabendo que a ordem de execução não será mantida.
    * Em multithread não é possível saber quem terminará primeiro uma execução, por isso, cuidados são necessários.
    *
    *
    * A segunda forma de utilização de Threads é por meio de uma classe que implemente a interface Runnable (mais usual do que a primeira forma)
    * A interface Runnable também pertence ao java.lang e também possui um método run, e nele colocamos o código que será executado.
    * Para instanciar deve criar um new Thread e passar como parâmetro um Runnable para depois usar o start, diferente da herança que permitia criar um objeto diretamente.
    *
    * A grande vantagem do Runnable é que por ter apenas um método ele é uma Functional Interface e pode ser substituído por uma Expressão Lambda.
    * Ou seja, ao invés de criar uma classe que implemente Runnable podemos descarta-la. Antes do Java 8 se utilizava classes anônimas do tipo Runnable.
    * Com lambda apenas uma linha de código pode ser utilizada, por isso, é o preferido dos desenvolvedores.
    * Outro motivo é que por herança não é permitido herdar de mais de uma classe, ou seja, se a classe herdar de Thread já estará com o limite atingido de herança
    * Já a interface te dá uma flexbilidade maior e quanto a performance, uso de memório, etc, é a mesma coisa.
    *
    *
    *
    * */
}
