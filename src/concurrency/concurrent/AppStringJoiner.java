package concurrency.concurrent;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppStringJoiner {

    public static void main(String[] args) throws InterruptedException {

        try (ExecutorService e = Executors.newSingleThreadExecutor()) {
            StringJoinerRunnable runnable = new StringJoinerRunnable(List.of("A", "B", "C"));
            //e.execute(runnable); // Faz o mesmo que o submit, porém, não retorna nada. Pode ser utilizado quando não se importa com o sincronismo da tarefa
            Future<?> future = e.submit(runnable); // submit retorna um Future com a possível resposta futura que pode ser entregue
            future.get(); // thread principal bloqueia até que exista uma resposta da thread que está no ExecutorService
            System.out.println(runnable.getResult()); // depois desbloqueia e pega o resultado (união das Strings) que estava na thread a parte

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
