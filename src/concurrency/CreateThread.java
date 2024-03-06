package concurrency;

public class CreateThread {

    public static void main(String[] args) {

        MyThread t = new MyThread(); // por herança
        t.start();

        Thread t2 = new Thread(new MyThread2()); // por interface
        t2.start();

        // por interface utilizando expressão lambda, apenas uma linha de código
        new Thread(() -> System.out.println("MyThread3 here!")).start();

        System.out.println("main()");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("MyThread here!");
        }
    }

    static class MyThread2 implements Runnable { // pode ser descartado se usar lambda
        @Override
        public void run() {
            System.out.println("MyThread2 here!");
        }
    }
}
