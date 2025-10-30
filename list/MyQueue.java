package list;

public class MyQueue{

	MyLinkedList myQueue = new MyLinkedList(); // Composition relationship
	private int top;

	public boolean isEmpty() {
		return myQueue.isEmpty(); //call forward
	}

	public void enqueue(String s) {
		myQueue.addLast(s);
		top = myQueue.getSize();
	}

	public void dequeue() {
		myQueue.removeFirst(); 
		top = myQueue.getSize();
	}

	public int search(String key) {
		return myQueue.find(key);
	}

	public void print() {
		myQueue.print();
	}
}
