package theory;

@SuppressWarnings("ALL")
public class SynchronizedBlock {

    /*
    *
    * Para mostrar como sincronizar threads criou contador com a estrutura:
    * atributo estatico do tipo int para ser contador, que está associado a classe e não ao objeto, por isso é armazenado no heap (é compartilhado entre as threads)
    * ou seja, é a nossa região crítica.
    * Na sequencia há um Runnable com um sleep que não afeta o bug existente estruturado em uma expressão lambda para contar de 0 a 10.
    * Depois criado uma lista com 3 threads usando StreamAPI baseadas num Runnable, inicializadas com method reference e um join para fazer a thread principal aguardar cada uma
    * Por ultimo exibe no console o valor acumulado na variável counter.
    *
    * para o join e sleep foram criados métodos a parte para manter o código principal mais limpo considerando que eles lançam exceção e foram
    * capturados nos try / catch
    *
    * Ao rodar do código o resultado nunca mostrará o 30 esperado por conta da perda de informação devido o compartilhamento de counter no heap
    * Isso ocorre por que o conter++ internamente no baixo nível é quebrada na leitura, atualização e redefinição do valor. Se entre uma delas
    * a thread pára de executar e entra outra no lugar pode ser que opere num valor inconsistente (região crítica).
    * Para corrigir isso é necessário que o acesso seja sincronizado, uma thread por vez.
    * A variável do Runnable é local e por isso não há perigo porque cada thread terá seu valor, assim como o sleep pode ser chamado em várias threads.
    * Seguindo a solução foi criado um Monitor utilizando um Object (IMPORTANTE: um monitor NÃO pode ser NULO, tem que ser um objeto válido).
    * Por isso colocado como final e para sincronizar foi criado o bloco synchronized passando o monitor como parâmetro e no bloco de código
    * inserido o counter++ para sincronizar o acesso.
    *
    * O monitor tem um lock de modo que quando a primeira thread entrar, e estiver executando o counter++, ninguém mais executa nada, ficam aguardando
    * a thread terminar sua execução e sair.
    *
    * No final o resultado estará consistente apresentando sempre o valor acumulado das threads = 30
    *
    *
    *
    *
    * */
}
