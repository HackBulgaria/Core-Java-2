package week6.task2.producer_consumer;

public class ThreadRunner {
	public static void main(String[] args) throws InterruptedException {
		MyBlockingQueue<String> queue = new MyBlockingQueue<>(100);

		ProducerThread p1 = new ProducerThread(queue);
		ProducerThread p2 = new ProducerThread(queue);
		ProducerThread p3 = new ProducerThread(queue);

		ConsumerThread c1 = new ConsumerThread(queue);
		ConsumerThread c2 = new ConsumerThread(queue);

		Thread t1 = new Thread(p1);
		t1.setName("producer 1");
		Thread t2 = new Thread(p2);
		t2.setName("producer 2");
		Thread t3 = new Thread(p3);
		t3.setName("producer 3");

		Thread t4 = new Thread(c1);
		t4.setName("consumer 1");
		Thread t5 = new Thread(c2);
		t5.setName("consumer 2");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
//		t1.join();
//		t2.join();
//		t3.join();
//		t4.join();
//		t5.join();
		
	}
}
