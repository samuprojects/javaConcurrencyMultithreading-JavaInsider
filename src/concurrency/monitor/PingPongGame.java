package concurrency.monitor;
/*
*
* Jogo para treinar uso do wait(), notify() e notifyAll()
* O game possui mais duas classes representando os lados do Ping e do Pong, cada um como uma thread
* Objetivo sincronizar para bom funcionamento do jogo
*
* */

@SuppressWarnings("ALL")
public class PingPongGame {

    private boolean isPingTurn = true;

    public synchronized void playPing() {
        System.out.println("Ping!");
    }

    public synchronized void playPong() {
        System.out.println("Pong!");
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
