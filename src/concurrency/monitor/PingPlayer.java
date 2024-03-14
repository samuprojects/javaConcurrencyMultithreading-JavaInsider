package concurrency.monitor;

public class PingPlayer implements Runnable {

    private final PingPongGame game;

    public PingPlayer(PingPongGame game) {
        this.game = game;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            try {
                game.playPing();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
