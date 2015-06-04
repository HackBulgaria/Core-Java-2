package week6.task2.producer_consumer;

public class ProducerThread implements Runnable {

	private MyBlockingQueue<String> queue;
	public ProducerThread(MyBlockingQueue<String> queue) {
		this.queue = queue;

	}

	@Override
	public void run() {
		for (int i = 1; i < 1001; i++) {
			queue.add(Thread.currentThread().getName() + ": " + i + " - " + System.nanoTime()
					% 1_000_000);
		}
	}
}
