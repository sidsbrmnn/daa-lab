import java.util.Random;

class SquareThread implements Runnable {
	int x;

	SquareThread(int x) {
		this.x = x;
	}

	@Override
	public void run() {
		System.out.println("SquareThread: Square of " + x + " is " + x * x);
	}
}

class CubeThread implements Runnable {
	int x;

	CubeThread(int x) {
		this.x = x;
	}

	@Override
	public void run() {
		System.out.println("CubeThread: Cube of " + x + " is " + x * x * x);
	}
}

class RandomThread implements Runnable {
	int x;

	@Override
	public void run() {
		Random r = new Random();
		Thread t2, t3;
		try {
			while (true) {
				x = r.nextInt(100);
				System.out.println("MainThread: Generated number is " + x);
				t2 = new Thread(new SquareThread(x));
				t2.start();
				t3 = new Thread(new CubeThread(x));
				t3.start();
				Thread.sleep(1000);
				System.out.println("**********************************");
			}
		} catch (Exception e) {
			System.out.println("EXCEPTION CAUGHT");
		}
	}
}

public class MainThread {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new RandomThread());
		t1.start();
	}
}
