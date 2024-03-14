package concurrency.monitor;
/*
*
* Jogo para treinar uso do wait(), notify() e notifyAll()
* O game possui mais duas classes representando os lados do Ping e do Pong, cada um como uma thread
* Objetivo sincronizar para bom funcionamento do jogo.
* Spurious wakeup = quando uma thread "acorda" mesmo sem ter recebido um notify, por isso usado um while para testar e manter a condição de dormindo.
*
* */

public class PingPongGame {

    private boolean isPingTurn = true;

    public synchronized void playPing() throws InterruptedException {

        while (!isPingTurn) { // trocado de if para while para testar condição evitar Spurious wakeup
            wait();
        }

        System.out.println("Ping!");
        isPingTurn = true;
        notify();
    }

    public synchronized void playPong() throws InterruptedException {

        while (isPingTurn) { // trocado de if para while para testar condição evitar Spurious wakeup
            wait();
        }

        System.out.println("Pong!");
        isPingTurn = true;
        notify();
    }

    public static void main(String[] args) throws Exception {
        PingPongGame game = new PingPongGame();

        Thread pingPlayer = new Thread(new PingPlayer(game));
        Thread pongPlayer = new Thread(new PongPlayer(game));

        pingPlayer.start();
        pongPlayer.start();

        pingPlayer.join();
        pongPlayer.join();
    }

}
