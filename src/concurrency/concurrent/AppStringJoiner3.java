package concurrency.concurrent;
/*
* Outra abordagem é nós mesmos criarmos o objeto Future através da classe FutureTask
* que é uma implementação da interface Future que permite manualmente criar essa FutureTask
*
* Em termos de estrutura (mas não em funcionalidade) a FutureTask é semelhante à classe Thread
* prof sugeriu verificar documentação para ver outros métodos
*
* */

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class AppStringJoiner3 {

    public static void main(String[] args) throws Exception {

        try (ExecutorService e = Executors.newSingleThreadExecutor()) {
            FutureTask<String> task = new FutureTask<>(new StringJoinerCallable(List.of("A", "B", "C")));
            e.submit(task);
            System.out.println(task.get());

        }
    }
}
