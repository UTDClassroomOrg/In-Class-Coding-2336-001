package list;

public class MyStack {

	MyLinkedList myStack = new MyLinkedList(); //composition relationship
	private int top;

	public boolean isEmpty() {
		return myStack.isEmpty(); //call forward
	}

	public void push(String s) {
		myStack.addFirst(s);
		top = myStack.getSize();
	}

	public void pop() {
		myStack.removeFirst(); 
		top = myStack.getSize();
	}

	public String peek() {
		if(!isEmpty())
			return myStack.getElement(0);
		else
			return "The stack is empty!";
	}

	public int search(String key) {
		return myStack.find(key);
	}

	public void print() {
		myStack.print();
	}

}
