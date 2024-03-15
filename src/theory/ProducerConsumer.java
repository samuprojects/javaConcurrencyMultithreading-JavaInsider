package theory;

@SuppressWarnings("ALL")
public class ProducerConsumer {

    /*
    *
    * Problema clássico de concorrência: Produtor / Consumidor
    *
    * Ocorre quando temos uma fila de informações onde
    * tem alguém produzindo em uma determinada ordem e outro consumindo nesta mesma sequencia.
    * Temos uma fila compartilhada, ou seja, acessado pelas duas threads (produtor/consumidor).
    * Outro ponto é que a fila tem um tamanho T (que pode ser especificado em algum momento).
    *
    * Se o produtor estiver atuando muito mais rápido que o consumidor a fila ficará cheia e terá de aguardar abrir espaço para continuar.
    * Por outro lado se o consumidor for muito rápido não haverá o que consumir tendo que bloquear também, ou seja, deve existir um mecanismo de comunicação (wait)
    *
    * Pode haver ainda outros produtores e outros consumidores e não necessariamente na mesma proporção.
    * Cada tipo de aplicação vai atuaar de uma maneira específica com relação a essas threads que produzem e consomem
    * No entanto o ponto chave é garantir que mesmo na presença de múltiplos consumidores e produtores o código se comporte adequadamente
    * com relação à concorrência (de forma sincronizada e com os mecanismos de comunicação funcionando).
    *
    *
    *            Produtor (P) / Consumidor (C)
    *
    *          TAMANHO
    *            |
    *            V       FILA COMPARTILHADA
    *        --> |_|_|_|_|_|4|3|2|1| ---
    *       |                 --->      \
    * P3 P2 P1                           \
    *        1,2,3,4...                  V
    *                                    C1 1,2,3,4...
    *                                    C2
    *                                    C3
    *                                    C4
    *
    * */
}
