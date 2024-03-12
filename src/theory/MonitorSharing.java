package theory;

@SuppressWarnings("ALL")
public class MonitorSharing {

    /*
    *
    * Aproveitando o código anterior foi refeito agora o código como uma classe CounterThread estendendo Thread
    * no main ficaram as 3 threads geradas com method reference.
    * depois chama get para o valor do contador
    *
    * Na classe manteve o monitor porém foi testado alterar removendo o static para demonstrar um erro.
    * Isso faz com que o monitor seja um atributo da thread e ao rodar a apĺicação volta o problema do bug inconsistencia, mesmo com o synchronized.
    *
    * Para que um monitor funcione é necessário que todas as threads enxerguem o mesmo monitor.
    *
    * Removendo o static é como se tivessem várias salas com seguranças e cada um com sua chave (lock) mas para a mesma região crítica, ou seja,
    * vai ocorrer de ter várias threads acessando a região crítica e gerando a inconsistência.
    *
    * Definir como static faz com que o monitor seja um atributo da classe CounterThread e não mais da thread, deixando esse valor compartilhado para todas
    * e com o bloco synchronized restringindo o acesso uma por vez à região crítica.
    *
    *
    * */
}
