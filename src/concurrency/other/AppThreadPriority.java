package concurrency.other;

/*
*
* Toda thread tem uma prioridade associada a ela.
* Para saber a prioridade chamar o getPriority()
* Por padrão todas têm prioridade 5
* Se quiser mudar pode chamar o setPriority() passando um valor de 1 a 10
* Fora desse intervalo a JVM lança exceção
* Pode ser usado constantes da classe Thread, exemplo, MAX_PRIORITY, MIN_PRIORITY, NORM_PRIORITY para definir esse valor
*
* IMPORTANTE
* Não levar esse ponto a risca, porque, muita coisa relacionado às Threads depende do escalonador (thread scheduler)
* que é um componente que não temos controle.
*
* Se o sistema operacional levasse a sério a questão das prioridades de threads, poderia ocorrer
* um cenário chamado de starvation ("morrer de fome"), quando uma thread não consegue executar
* porque todas as outras têm prioridade máxima, por exemplo.
*
* Por isso esse recurso da prioridade deve ser considerado uma dica para o escalonador.
* Sua aplicação não pode jamais depender dessa lógica para executar porque não há controle sobre isso.
*
* */
public class AppThreadPriority {

    public static void main(String[] args) {

        Thread t = new Thread(() -> System.out.println("Hello!"));

        t.setPriority(Thread.MAX_PRIORITY);

        System.out.println(t.getPriority());
    }
}
