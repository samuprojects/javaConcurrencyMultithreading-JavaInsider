package concurrency.concurrent;
/*
*
* a interface Callable foi criada para resolver dois problemas do Runnable,
* pois pode retornar dados do tipo parametrizado (qualquer coisa) e também pode lançar checked exceptions
*
* */
import java.util.List;
import java.util.concurrent.Callable;

public class StringJoinerCallable implements Callable<String> {

    private final List<String> strings;

    public StringJoinerCallable(List<String> strings) {
        this.strings = strings;
    }

    @Override
    public String call() {
        return String.join("", strings);
    }
}
