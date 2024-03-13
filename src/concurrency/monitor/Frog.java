package concurrency.monitor;

public class Frog extends Thread{

    private static final int MAX_JUMP = 50;
    private static final int MAX_REST = 500;

    private final String name;
    private final int totalDistance;
    private int currentDistance;

    private int lastJump;

    private static final Object MONITOR = new Object(); // também estático para que todas as threads vejam apenas esse monitor (só um lock disponível)

    private static int position; // para que os sapos enxerguem a mesma variável e computar quem chegou primeiro // região crítica // Race condition


    public Frog(String name, int totalDistance) {
        this.name = name;
        this.totalDistance = totalDistance;
    }

    @Override
    public void run() {
        while (currentDistance < totalDistance) {
            jump();
            report();
            rest();
        }

        crossFinishLine();
    }

    private void jump(){
        lastJump = (int) (Math.random() * MAX_JUMP);

        currentDistance += lastJump;

        if (currentDistance > totalDistance) {
            currentDistance = totalDistance;
        }
    }

    private void report() {
        System.out.format("%s jumped %d cm. Total distance is %d cm\n", name, lastJump, currentDistance);

    }

    private void rest() {
        int time = (int) (Math.random() * MAX_REST);

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void crossFinishLine(){
        synchronized (MONITOR){ // mesmo que alguns sapos cheguem juntos somente 1 vai receber o lock e informar sua posição, por isso a impressão também foi sincronizada
            position++; // o primeiro que chegar vai incrementar para 1, e sucessivamente.
            System.out.format("%s finished the race in position %d\n", name, position);
        }
    }
}
