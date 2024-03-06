package concurrency;

public class CreateThread {

    public static void main(String[] args) {

        MyThread t = new MyThread();
        t.start();

        System.out.println("main()");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("MyThread here!");
        }
    }
}
