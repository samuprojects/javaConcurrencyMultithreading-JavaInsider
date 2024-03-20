package concurrency.concurrent;

/*
 * Outra forma de garantir o sincronismo no cenário do Cache, sem usar locks, é utilizando uma coleção que funciona como um Map,
 * porém, traz um sincronismo ao Map. É um Map que pode ser utilizado na presença de múltiplas threads, porque o próprio sincronismo
 * do acesso fica dentro da implementação da coleção.
 *
 * Quando trabalhar com sincronismo professor sugeriu utilizar alguma estrutura pronta do Java para deixar o código mais claro
 * e menos suscetível a erros.
 *
 * Apesar de não poder usar sempre essa solução, para esse cenário específico é o ideal.
 *
 * */

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@SuppressWarnings("ALL")
public class Cache2 {

    private static final Cache2 INSTANCE = new Cache2();

    private final ConcurrentMap<String, String> data = new ConcurrentHashMap<>();

    private Cache2() {}

    public static Cache2 getInstance() {
        return INSTANCE;
    }

    public String get(String property) {
        return data.get(property);
    }

    public void set(String property, String value) {
        data.put(property, value);
    }
}