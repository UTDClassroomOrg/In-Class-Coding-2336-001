package genericList;

public class MyStack<E> {

	MyLinkedList<E> myStack = new MyLinkedList<>(); //composition relationship
	private int top;

	public boolean isEmpty() {
		return myStack.isEmpty(); //call forward
	}

	public void push(E s) {
		myStack.addFirst(s);
		top = myStack.getSize();
	}

	public void pop() {
		myStack.removeFirst(); 
		top = myStack.getSize();
	}

	public E peek() {
		if(!isEmpty())
			return myStack.getElement(0);
		else
			return null;
			//return "The stack is empty!";
	}

	public int search(E key) {
		return myStack.find(key);
	}

	public void print() {
		myStack.print();
	}

}
