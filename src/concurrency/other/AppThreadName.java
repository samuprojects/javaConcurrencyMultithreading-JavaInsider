package concurrency.other;

/*
* Nomeando as threads
* Cada thread pode ter um nome e, na prática, o melhor uso disso é para logs
* Para saber o nome padrão da thread principal atribuída pela JVM pode usar o Thread.currentThread().getName()
* Para saber o nome da outra thread criada apenas chamamos o getName no objeto da Thread (também atribuída pela JVM).
* Para alterar o nome das threads basta usar o setName no objeto das threads e;
* para a thread principal pode usar Thread.currentThread().setName("NovoNomeParaThreadPrincipal")
*
* Não é muito utilizado na prática, mas em cenários específicos pode precisar.
*
*
* */

public class AppThreadName {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> System.out.println("Hello!"));
        t1.setName("T1");

        Thread t2 = new Thread(() -> System.out.println("Hello!"));
        t2.setName("T2");

        Thread.currentThread().setName("MainThread");

        System.out.println(Thread.currentThread().getName());
        System.out.println(t1.getName());
        System.out.println(t2.getName());
    }
}
