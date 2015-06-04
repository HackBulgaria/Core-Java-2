package week6.task2.producer_consumer;


public class ConsumerThread implements Runnable {
	private MyBlockingQueue<String> queue;

	public ConsumerThread(MyBlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (queue.size() > 0) {
			queue.poll();
		}
	}
}
