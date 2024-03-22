package concurrency.other;

/*
* Muitos métodos relacionados à threads lançam a exceção InterruptedException
* Ocorre quando uma thread que entra em estado de aguardo tem sua execução interrompida por outra thread
* A InterruptedException é uma forma com que a thread interrompida tem de saber sobre isso e agir corretamente.
*
* No exemplo chamamos o interrupt() que faz a interrupção (lançando a exceção) da thread onde estamos chamando o objeto.
* A InterruptedException será relançada como uma RuntimeException com a descrição "sleep interrupted".
*
* Se quiser encerrar de uma forma mais amigável, sem lançar a exceção, poderia colocar uma mensagem no bloco do catch
*
* Outro ponto que não é comum, mas está disponível é encerrar a própria thread com o Thread.currentThread().interrupt()
*
* */

@SuppressWarnings("ALL")
public class AppInterrupt {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Ping!");
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Interrupted...");
                }
        });

        t.start();

        Thread.sleep(5000);

        t.interrupt();
    }
}
