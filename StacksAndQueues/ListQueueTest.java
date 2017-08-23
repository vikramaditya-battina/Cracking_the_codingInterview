package StacksAndQueues;

public class ListQueueTest {
	public static void main(String args[]) {
		ListQueue<Integer> queue = new ListQueue<Integer>();
		assert queue.isEmpty() == true;
		queue.Enqueue(10);
		queue.Enqueue(5);
		assert queue.peek().equals(10);
		assert queue.dequeue().equals(10);
		queue.Enqueue(0);
		assert queue.dequeue().equals(5);
		assert queue.peek().equals(0);
		assert queue.isEmpty() == false;
		assert queue.dequeue().equals(0);
		assert queue.dequeue() == null;
		assert queue.peek() == null;
		assert queue.isEmpty() == true;
		System.out.println("All Tests are passed successfully...");
	}
}
