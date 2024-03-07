package concurrency;

public class AppCounter2 {

    public static void main(String[] args) {

        SharedCounter c = new SharedCounter();

        Thread t1 = new Thread(c);
        t1.start();

        Thread t2 = new Thread(c);
        t2.start();
    }
}
