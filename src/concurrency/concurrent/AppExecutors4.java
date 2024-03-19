package concurrency.concurrent;
/*
* Utilizar o newScheduledThreadPool retorna um ScheduledExecutorService que nos permite agendar uma tarefa
* para executar em thread a parte periodicamente ou de uma só vez com um delay específico
*
* Utilizar o scheduleWithFixedDelay recebe um long a mais para indicar a periodicidade da execução,
* por exemplo, após executado a primeira vez as outras a cada um segundo.
*
* */

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class AppExecutors4 {
    public static void main(String[] args) {

        ScheduledExecutorService e = Executors.newScheduledThreadPool(1);

        //e.schedule(() -> System.out.println("Good morning!"), 3, TimeUnit.SECONDS);

        e.scheduleWithFixedDelay(() -> System.out.println("Good morning!"), 3, 1, TimeUnit.SECONDS);

        //e.shutdown();

    }
}