package concurrency.other;

/*
* O Java possui 2 tipos de Threads: User threads e Daemon threads
* o primeiro tipo é o comum e no exemplo abaixo numa thread normal a thread principal encerrá e a criada fica infinitamente rodando.
* setDaemon(true) muda a User thread para Daemon thread e se quiser confirmar o tipo pode usar isDaemon().
* A diferença entre elas é que a Daemon thread pode ser encerrada pela JVM se sobrarem apenas esse tipo de thread em execução, porque,
* do contrário, a jvm sempre ficará em execução enquanto existir a user thread estiver rodando.
*
* Geralmente a daemon thread é usada como suporte a user thread, por exemplo, como garbage collector, como processos de logs, etc.
*
* Pode ser usada em cenários que precisar rodar alguma coisa em background e que ao terminar a aplicação pode ser encerrada sem causar
* prejuízos.
*
*
* */

@SuppressWarnings("ALL")
public class AppDaemonThreads {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            while (true) { // thread em loop infinito
                System.out.println("Ping!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t.setDaemon(true); // por ser daemon não ficará em loop, será encerrada pela jvm
        t.start();

        System.out.println("Executing...");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done!");
    }
}
