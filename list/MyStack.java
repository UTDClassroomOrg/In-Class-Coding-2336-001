package list;

public class MyStack {

	private MyLinkedList myStack = new MyLinkedList(); //composition relationship
	private int top;
	
	public boolean isEmpty() {
		return myStack.isEmpty(); //forward
	}
	
	public void push(String s) {
		myStack.addFirst(s);
		top = myStack.getSize() ;
	}
	
	public void pop() {
		myStack.removeFirst();
		top = myStack.getSize() ;
	}
	
	public String peek() {
		if(!isEmpty())
			return myStack.getElement(0);
		else
			return "Stack is empty!";
	}
	
	public int search(String key) {
		return myStack.find(key);
	}
	
	public void print() {
		myStack.print();
	}
}
