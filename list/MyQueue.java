package list;

public class MyQueue {
	private MyLinkedList myQueue = new MyLinkedList(); //composition relationship
	private int size;
	
	public boolean isEmpty() {
		return myQueue.isEmpty(); //forward
	}
	
	public void enqueue(String s) {
		myQueue.addLast(s);
		size = myQueue.getSize() ;
	}
	
	public void dequeue() {
		myQueue.removeFirst();
		size = myQueue.getSize() ;
	}

	
	public int search(String key) {
		return myQueue.find(key);
	}
	
	public void print() {
		myQueue.print();
	}
}
