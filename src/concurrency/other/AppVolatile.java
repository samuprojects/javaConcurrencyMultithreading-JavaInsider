package concurrency.other;

/*
* Devido cópia de valores no cache (para evitar consulta na ram) pode acontecer da thread demorar para atualizar para true
* e ainda pode ocorrer de não atualizar corretamente o valor de number na ram imprimindo zero o que é inconsistente no cenário criado
* para evitar isso e avisar para o Java não manter o valor de variáveis em um cache local e sim usar sempre o atualizado da ram
* usar o modificador volatile nas variáveis, meio que tirando o cache do caminho, gravando e lendo diretamente na ram.
*
* É muito utilizado em situações onde precisamos resolver um problema de loop com uma condição (que normalmente é um boolean)
* e outra thread vai mudar esse boolean, não há problema de concorrência nesse cenário porque o acesso a boolean é atômico,
* mas existe o problema do cache. Usando o volatile garante que assim que o valor for trocado já estará na memória ram para quem precisar.
*
* */

@SuppressWarnings("ALL")
public class AppVolatile {

    private static volatile int number;
    private static volatile boolean ready;

    private static class Executor extends Thread {

        @Override
        public void run() {
            while (!ready) { }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {

        new Executor().start();
        number = 10;
        ready = true;
    }
}
