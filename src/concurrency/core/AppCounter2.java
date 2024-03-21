package concurrency.core;

/*
* Para bloquear a thread principal até que outras threads finalizem pode usar o join() para isso
* O join faz com que a thread que o chamou fique bloqueada até o termino da nova thread
*
* */

public class AppCounter2 {

    public static void main(String[] args) throws InterruptedException {

        SharedCounter c = new SharedCounter();

        Thread t1 = new Thread(c);
        t1.start();

        Thread t2 = new Thread(c);
        t2.start();

        t1.join();
        t2.join();

        System.out.println("End"); // após t1 e t2 terminarem a thread principal vai imprimir na tela
    }
}
