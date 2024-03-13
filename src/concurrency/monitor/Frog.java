package concurrency.monitor;

@SuppressWarnings("ALL")
public class Frog extends Thread{

    private static final int MAX_JUMP = 50;
    private static final int MAX_REST = 500;

    private final String name;
    private final int totalDistance;
    private int currentDistance;

    private int lastJump;


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
    }

    private void jump(){
        lastJump = (int) (Math.random() * MAX_JUMP);

        currentDistance += lastJump;

        if (currentDistance > totalDistance) {
            currentDistance = totalDistance;
        }
    }

    private void report() {
        System.out.format("%s jumped %d cm. Total distance is %d cm\n", name, lastJump, totalDistance);

    }

    private void rest() {
        int time = (int) (Math.random() * MAX_REST);

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
