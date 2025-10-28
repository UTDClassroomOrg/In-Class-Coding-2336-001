package list;
/*
 * Stack is a LIFO (FILO)
 * A special case of MyArrayList
 */
public class MyStackOfArrayList {
	private MyArrayList myStack = new MyArrayList(); //composition relationship
	private int top;

	public boolean isEmpty() {
		return myStack.isEmpty(); //forward
	}
	
	public void push(String s) {
		myStack.addLast(s);
		top = myStack.getSize() ;
	}
	
	public void pop() {
		myStack.removeLast();
		top = myStack.getSize() ;
	}
	
	public String peek() {
		if(!isEmpty())
			return myStack.getElement(top - 1);
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
