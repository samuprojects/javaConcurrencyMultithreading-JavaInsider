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
    *
    *
    * */
}
