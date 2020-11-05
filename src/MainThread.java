import java.util.Random;

class Cube implements Runnable {
    private int value;

    public Cube(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        System.out.println("Cube of " + value + " = " + value * value * value);
    }
}

class Square implements Runnable {
    private int value;

    public Square(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        System.out.println("Square of " + value + " = " + value * value);
    }
}

public class MainThread implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        Thread cubeThread, squareThread;

        while (true) {
            int value = random.nextInt(100);

            squareThread = new Thread(new Square(value));
            squareThread.start();

            cubeThread = new Thread(new Cube(value));
            cubeThread.start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("\n*******************");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MainThread());
        thread.start();
    }
}
